package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.massoftware.a.model.*;
import com.massoftware.b.service.SeguridadPuertaFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class SeguridadPuertaDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public SeguridadPuertaDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(ConnectionWrapper connection, SeguridadPuertaFilterQ1 filter)
			throws SelectException, SQLException {
			
		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");	

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("SeguridadPuerta_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "id", filter.getId());		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());
		addArgLIKE(statement, sqlWhereArgs, "equate", filter.getEquate());
		addArgEQ(statement, sqlWhereArgs, "seguridadModulo", (filter.getSeguridadModulo() != null) ? filter.getSeguridadModulo().getId() : null);

		sql = "SELECT\tCOUNT(*)::INTEGER\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Integer) r.getTable()[0][0];
	}
	
	public List<SeguridadPuerta> find(ConnectionWrapper connection, SeguridadPuertaFilterQ1 filter)
			throws SelectException, SQLException {
			
		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");		

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("SeguridadPuerta_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "id", filter.getId());	
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());
		addArgLIKE(statement, sqlWhereArgs, "equate", filter.getEquate());
		addArgEQ(statement, sqlWhereArgs, "seguridadModulo", (filter.getSeguridadModulo() != null) ? filter.getSeguridadModulo().getId() : null);		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<SeguridadPuerta> buildObjsQ1(Result r) {
		
		List<SeguridadPuerta> items = new ArrayList<SeguridadPuerta>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			SeguridadPuerta objRow = new SeguridadPuerta();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			objRow.setNombre((String) row[++c]);
			objRow.setEquate((String) row[++c]);
			SeguridadModulo objRowSeguridadModulo = new SeguridadModulo();
			objRowSeguridadModulo.setId((String) row[++c]);
			
			if(objRowSeguridadModulo.getId() != null){
				objRow.setSeguridadModulo(objRowSeguridadModulo);
			}
			
			
			items.add(objRow);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------