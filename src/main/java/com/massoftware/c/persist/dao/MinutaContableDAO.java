package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.*;
import com.massoftware.b.service.MinutaContableFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class MinutaContableDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public MinutaContableDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, MinutaContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("MinutaContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<MinutaContable> find(ConnectionWrapper connection, MinutaContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("MinutaContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<MinutaContable> buildObjsQ1(Result r) {
		List<MinutaContable> items = new ArrayList<MinutaContable>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			MinutaContable objRow = new MinutaContable();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			objRow.setNombre((String) row[++c]);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------