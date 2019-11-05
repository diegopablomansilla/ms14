package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.time.LocalDate;
import com.massoftware.a.model.*;
import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class EjercicioContableDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(ConnectionWrapper connection, EjercicioContableFilterQ1 filter)
			throws SelectException, SQLException {
			
		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");	

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("EjercicioContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "id", filter.getId());		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgGE(statement, sqlWhereArgs, "apertura", filter.getAperturaFrom());
		addArgLE(statement, sqlWhereArgs, "apertura", filter.getAperturaTo());
		addArgGE(statement, sqlWhereArgs, "cierre", filter.getCierreFrom());
		addArgLE(statement, sqlWhereArgs, "cierre", filter.getCierreTo());
		addArgEQ(statement, sqlWhereArgs, "cerrado", filter.getCerrado());
		addArgEQ(statement, sqlWhereArgs, "cerradoModulos", filter.getCerradoModulos());
		addArgLIKE(statement, sqlWhereArgs, "comentario", filter.getComentario());

		sql = "SELECT\tCOUNT(*)::INTEGER\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Integer) r.getTable()[0][0];
	}
	
	public List<EjercicioContable> find(ConnectionWrapper connection, EjercicioContableFilterQ1 filter)
			throws SelectException, SQLException {
			
		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");		

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("EjercicioContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "id", filter.getId());	
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgGE(statement, sqlWhereArgs, "apertura", filter.getAperturaFrom());
		addArgLE(statement, sqlWhereArgs, "apertura", filter.getAperturaTo());
		addArgGE(statement, sqlWhereArgs, "cierre", filter.getCierreFrom());
		addArgLE(statement, sqlWhereArgs, "cierre", filter.getCierreTo());
		addArgEQ(statement, sqlWhereArgs, "cerrado", filter.getCerrado());
		addArgEQ(statement, sqlWhereArgs, "cerradoModulos", filter.getCerradoModulos());
		addArgLIKE(statement, sqlWhereArgs, "comentario", filter.getComentario());		

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
			
			items.add(objRow);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------