package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class EjercicioContableDAO2 extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableDAO2(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, EjercicioContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("EjercicioConteble_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());				
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<EjercicioContable> find(ConnectionWrapper connection, EjercicioContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("EjercicioConteble_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());				
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<EjercicioContable> buildObjsQ1(Result r) {
		List<EjercicioContable> items = new ArrayList<EjercicioContable>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			EjercicioContable objRow = new EjercicioContable();

			objRow.setId((String) row[++c]);

			objRow.setNumero((Integer) row[++c]);
			objRow.setApertura((LocalDate) row[++c]);
			objRow.setCierre((LocalDate) row[++c]);
			objRow.setCerrado((Boolean) row[++c]);
			objRow.setCerradoModulos((Boolean) row[++c]);
			objRow.setComentario((String) row[++c]);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------
