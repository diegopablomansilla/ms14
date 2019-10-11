package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.*;
import com.massoftware.b.service.AsientoModeloItemFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class AsientoModeloItemDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public AsientoModeloItemDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, AsientoModeloItemFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("AsientoModeloItem_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgEQ(statement, sqlWhereArgs, "asientoModelo", (filter.getAsientoModelo() != null) ? filter.getAsientoModelo().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "cuentaContable", (filter.getCuentaContable() != null) ? filter.getCuentaContable().getId() : null);

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<AsientoModeloItem> find(ConnectionWrapper connection, AsientoModeloItemFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("AsientoModeloItem_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgEQ(statement, sqlWhereArgs, "asientoModelo", (filter.getAsientoModelo() != null) ? filter.getAsientoModelo().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "cuentaContable", (filter.getCuentaContable() != null) ? filter.getCuentaContable().getId() : null);		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<AsientoModeloItem> buildObjsQ1(Result r) {
		List<AsientoModeloItem> items = new ArrayList<AsientoModeloItem>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			AsientoModeloItem objRow = new AsientoModeloItem();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			AsientoModelo objRowAsientoModelo = new AsientoModelo();
			objRowAsientoModelo.setId((String) row[++c]);
			
			if(objRowAsientoModelo.getId() != null){
				objRow.setAsientoModelo(objRowAsientoModelo);
			}
			
			CuentaContable objRowCuentaContable = new CuentaContable();
			objRowCuentaContable.setId((String) row[++c]);
			
			if(objRowCuentaContable.getId() != null){
				objRow.setCuentaContable(objRowCuentaContable);
			}
			
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------