package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.massoftware.a.model.*;
import com.massoftware.b.service.AsientoContableItemFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class AsientoContableItemDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public AsientoContableItemDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, AsientoContableItemFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("AsientoContableItem_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgGE(statement, sqlWhereArgs, "fecha", filter.getFechaFrom());
		addArgLE(statement, sqlWhereArgs, "fecha", filter.getFechaTo());
		addArgLIKE(statement, sqlWhereArgs, "detalle", filter.getDetalle());
		addArgEQ(statement, sqlWhereArgs, "asientoContable", (filter.getAsientoContable() != null) ? filter.getAsientoContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "cuentaContable", (filter.getCuentaContable() != null) ? filter.getCuentaContable().getId() : null);
		addArgGE(statement, sqlWhereArgs, "debe", filter.getDebeFrom());
		addArgLE(statement, sqlWhereArgs, "debe", filter.getDebeTo());
		addArgGE(statement, sqlWhereArgs, "haber", filter.getHaberFrom());
		addArgLE(statement, sqlWhereArgs, "haber", filter.getHaberTo());

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<AsientoContableItem> find(ConnectionWrapper connection, AsientoContableItemFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("AsientoContableItem_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgGE(statement, sqlWhereArgs, "fecha", filter.getFechaFrom());
		addArgLE(statement, sqlWhereArgs, "fecha", filter.getFechaTo());
		addArgLIKE(statement, sqlWhereArgs, "detalle", filter.getDetalle());
		addArgEQ(statement, sqlWhereArgs, "asientoContable", (filter.getAsientoContable() != null) ? filter.getAsientoContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "cuentaContable", (filter.getCuentaContable() != null) ? filter.getCuentaContable().getId() : null);
		addArgGE(statement, sqlWhereArgs, "debe", filter.getDebeFrom());
		addArgLE(statement, sqlWhereArgs, "debe", filter.getDebeTo());
		addArgGE(statement, sqlWhereArgs, "haber", filter.getHaberFrom());
		addArgLE(statement, sqlWhereArgs, "haber", filter.getHaberTo());		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<AsientoContableItem> buildObjsQ1(Result r) {
		List<AsientoContableItem> items = new ArrayList<AsientoContableItem>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			AsientoContableItem objRow = new AsientoContableItem();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			objRow.setFecha((LocalDate) row[++c]);
			objRow.setDetalle((String) row[++c]);
			AsientoContable objRowAsientoContable = new AsientoContable();
			objRowAsientoContable.setId((String) row[++c]);
			
			if(objRowAsientoContable.getId() != null){
				objRow.setAsientoContable(objRowAsientoContable);
			}
			
			CuentaContable objRowCuentaContable = new CuentaContable();
			objRowCuentaContable.setId((String) row[++c]);
			
			if(objRowCuentaContable.getId() != null){
				objRow.setCuentaContable(objRowCuentaContable);
			}
			
			objRow.setDebe((BigDecimal) row[++c]);
			objRow.setHaber((BigDecimal) row[++c]);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------