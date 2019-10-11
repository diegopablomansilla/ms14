package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import com.massoftware.a.model.*;
import com.massoftware.b.service.AsientoContableFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class AsientoContableDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public AsientoContableDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, AsientoContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("AsientoContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgGE(statement, sqlWhereArgs, "fecha", filter.getFechaFrom());
		addArgLE(statement, sqlWhereArgs, "fecha", filter.getFechaTo());
		addArgLIKE(statement, sqlWhereArgs, "detalle", filter.getDetalle());
		addArgEQ(statement, sqlWhereArgs, "ejercicioContable", (filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "minutaContable", (filter.getMinutaContable() != null) ? filter.getMinutaContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "sucursal", (filter.getSucursal() != null) ? filter.getSucursal().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "asientoContableModulo", (filter.getAsientoContableModulo() != null) ? filter.getAsientoContableModulo().getId() : null);

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<AsientoContable> find(ConnectionWrapper connection, AsientoContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("AsientoContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgGE(statement, sqlWhereArgs, "fecha", filter.getFechaFrom());
		addArgLE(statement, sqlWhereArgs, "fecha", filter.getFechaTo());
		addArgLIKE(statement, sqlWhereArgs, "detalle", filter.getDetalle());
		addArgEQ(statement, sqlWhereArgs, "ejercicioContable", (filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "minutaContable", (filter.getMinutaContable() != null) ? filter.getMinutaContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "sucursal", (filter.getSucursal() != null) ? filter.getSucursal().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "asientoContableModulo", (filter.getAsientoContableModulo() != null) ? filter.getAsientoContableModulo().getId() : null);		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<AsientoContable> buildObjsQ1(Result r) {
		List<AsientoContable> items = new ArrayList<AsientoContable>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			AsientoContable objRow = new AsientoContable();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			objRow.setFecha((LocalDate) row[++c]);
			objRow.setDetalle((String) row[++c]);
			EjercicioContable objRowEjercicioContable = new EjercicioContable();
			objRowEjercicioContable.setId((String) row[++c]);
			
			if(objRowEjercicioContable.getId() != null){
				objRow.setEjercicioContable(objRowEjercicioContable);
			}
			
			MinutaContable objRowMinutaContable = new MinutaContable();
			objRowMinutaContable.setId((String) row[++c]);
			
			if(objRowMinutaContable.getId() != null){
				objRow.setMinutaContable(objRowMinutaContable);
			}
			
			Sucursal objRowSucursal = new Sucursal();
			objRowSucursal.setId((String) row[++c]);
			
			if(objRowSucursal.getId() != null){
				objRow.setSucursal(objRowSucursal);
			}
			
			AsientoContableModulo objRowAsientoContableModulo = new AsientoContableModulo();
			objRowAsientoContableModulo.setId((String) row[++c]);
			
			if(objRowAsientoContableModulo.getId() != null){
				objRow.setAsientoContableModulo(objRowAsientoContableModulo);
			}
			
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------