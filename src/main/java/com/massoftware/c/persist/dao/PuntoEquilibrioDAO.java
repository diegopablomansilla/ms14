package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.massoftware.a.model.*;
import com.massoftware.b.service.PuntoEquilibrioFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class PuntoEquilibrioDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public PuntoEquilibrioDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(ConnectionWrapper connection, PuntoEquilibrioFilterQ1 filter)
			throws SelectException, SQLException {
			
		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");	

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("PuntoEquilibrio_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "PuntoEquilibrio_0.id", filter.getId());		
		
		addArgGE(statement, sqlWhereArgs, "PuntoEquilibrio_0.numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "PuntoEquilibrio_0.numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "PuntoEquilibrio_0.nombre", filter.getNombre());
		addArgEQ(statement, sqlWhereArgs, "PuntoEquilibrio_0.tipoPuntoEquilibrio", (filter.getTipoPuntoEquilibrio() != null) ? filter.getTipoPuntoEquilibrio().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "PuntoEquilibrio_0.ejercicioContable", (filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);

		sql = "SELECT\tCOUNT(*)::INTEGER\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Integer) r.getTable()[0][0];
	}
	
	public List<PuntoEquilibrio> find(ConnectionWrapper connection, PuntoEquilibrioFilterQ1 filter)
			throws SelectException, SQLException {
			
		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");		

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("PuntoEquilibrio_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "PuntoEquilibrio_0.id", filter.getId());	
		
		addArgGE(statement, sqlWhereArgs, "PuntoEquilibrio_0.numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "PuntoEquilibrio_0.numero", filter.getNumeroTo());
		
		
		addArgLIKE(statement, sqlWhereArgs, "PuntoEquilibrio_0.nombre", filter.getNombre());
		
		
		addArgEQ(statement, sqlWhereArgs, "PuntoEquilibrio_0.tipoPuntoEquilibrio", (filter.getTipoPuntoEquilibrio() != null) ? filter.getTipoPuntoEquilibrio().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "PuntoEquilibrio_0.ejercicioContable", (filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<PuntoEquilibrio> buildObjsQ1(Result r) {
		
		List<PuntoEquilibrio> items = new ArrayList<PuntoEquilibrio>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			PuntoEquilibrio objRow = new PuntoEquilibrio();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			objRow.setNombre((String) row[++c]);
			
			TipoPuntoEquilibrio objRowTipoPuntoEquilibrio = new TipoPuntoEquilibrio();
			objRowTipoPuntoEquilibrio.setId((String) row[++c]);			
			objRowTipoPuntoEquilibrio.setNumero((Integer) row[++c]);
			objRowTipoPuntoEquilibrio.setNombre((String) row[++c]);
			
			if(objRowTipoPuntoEquilibrio.getId() != null){
				objRow.setTipoPuntoEquilibrio(objRowTipoPuntoEquilibrio);
			}
			
			EjercicioContable objRowEjercicioContable = new EjercicioContable();
			objRowEjercicioContable.setId((String) row[++c]);
			
			if(objRowEjercicioContable.getId() != null){
				objRow.setEjercicioContable(objRowEjercicioContable);
			}
			
			
			items.add(objRow);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------