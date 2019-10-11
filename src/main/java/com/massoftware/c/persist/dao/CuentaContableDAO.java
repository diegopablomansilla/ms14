package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.*;
import com.massoftware.b.service.CuentaContableFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class CuentaContableDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, CuentaContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("CuentaContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();		
		
		addArgLIKE(statement, sqlWhereArgs, "codigo", filter.getCodigo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());
		addArgEQ(statement, sqlWhereArgs, "ejercicioContable", (filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "integra", filter.getIntegra());
		addArgLIKE(statement, sqlWhereArgs, "cuentaJerarquia", filter.getCuentaJerarquia());
		addArgEQ(statement, sqlWhereArgs, "imputable", filter.getImputable());
		addArgEQ(statement, sqlWhereArgs, "ajustaPorInflacion", filter.getAjustaPorInflacion());
		addArgEQ(statement, sqlWhereArgs, "cuentaContableEstado", (filter.getCuentaContableEstado() != null) ? filter.getCuentaContableEstado().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "cuentaConApropiacion", filter.getCuentaConApropiacion());
		addArgEQ(statement, sqlWhereArgs, "centroCostoContable", (filter.getCentroCostoContable() != null) ? filter.getCentroCostoContable().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "cuentaAgrupadora", filter.getCuentaAgrupadora());
		addArgGE(statement, sqlWhereArgs, "porcentaje", filter.getPorcentajeFrom());
		addArgLE(statement, sqlWhereArgs, "porcentaje", filter.getPorcentajeTo());
		addArgEQ(statement, sqlWhereArgs, "puntoEquilibrio", (filter.getPuntoEquilibrio() != null) ? filter.getPuntoEquilibrio().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "costoVenta", (filter.getCostoVenta() != null) ? filter.getCostoVenta().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "seguridadPuerta", (filter.getSeguridadPuerta() != null) ? filter.getSeguridadPuerta().getId() : null);

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<CuentaContable> find(ConnectionWrapper connection, CuentaContableFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("CuentaContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		
		addArgLIKE(statement, sqlWhereArgs, "codigo", filter.getCodigo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());
		addArgEQ(statement, sqlWhereArgs, "ejercicioContable", (filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "integra", filter.getIntegra());
		addArgLIKE(statement, sqlWhereArgs, "cuentaJerarquia", filter.getCuentaJerarquia());
		addArgEQ(statement, sqlWhereArgs, "imputable", filter.getImputable());
		addArgEQ(statement, sqlWhereArgs, "ajustaPorInflacion", filter.getAjustaPorInflacion());
		addArgEQ(statement, sqlWhereArgs, "cuentaContableEstado", (filter.getCuentaContableEstado() != null) ? filter.getCuentaContableEstado().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "cuentaConApropiacion", filter.getCuentaConApropiacion());
		addArgEQ(statement, sqlWhereArgs, "centroCostoContable", (filter.getCentroCostoContable() != null) ? filter.getCentroCostoContable().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "cuentaAgrupadora", filter.getCuentaAgrupadora());
		addArgGE(statement, sqlWhereArgs, "porcentaje", filter.getPorcentajeFrom());
		addArgLE(statement, sqlWhereArgs, "porcentaje", filter.getPorcentajeTo());
		addArgEQ(statement, sqlWhereArgs, "puntoEquilibrio", (filter.getPuntoEquilibrio() != null) ? filter.getPuntoEquilibrio().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "costoVenta", (filter.getCostoVenta() != null) ? filter.getCostoVenta().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "seguridadPuerta", (filter.getSeguridadPuerta() != null) ? filter.getSeguridadPuerta().getId() : null);		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<CuentaContable> buildObjsQ1(Result r) {
		List<CuentaContable> items = new ArrayList<CuentaContable>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			CuentaContable objRow = new CuentaContable();

			objRow.setId((String) row[++c]);
			
			objRow.setCodigo((String) row[++c]);
			objRow.setNombre((String) row[++c]);
			EjercicioContable objRowEjercicioContable = new EjercicioContable();
			objRowEjercicioContable.setId((String) row[++c]);
			
			if(objRowEjercicioContable.getId() != null){
				objRow.setEjercicioContable(objRowEjercicioContable);
			}
			
			objRow.setIntegra((String) row[++c]);
			objRow.setCuentaJerarquia((String) row[++c]);
			objRow.setImputable((Boolean) row[++c]);
			objRow.setAjustaPorInflacion((Boolean) row[++c]);
			CuentaContableEstado objRowCuentaContableEstado = new CuentaContableEstado();
			objRowCuentaContableEstado.setId((String) row[++c]);
			
			if(objRowCuentaContableEstado.getId() != null){
				objRow.setCuentaContableEstado(objRowCuentaContableEstado);
			}
			
			objRow.setCuentaConApropiacion((Boolean) row[++c]);
			CentroCostoContable objRowCentroCostoContable = new CentroCostoContable();
			objRowCentroCostoContable.setId((String) row[++c]);
			
			if(objRowCentroCostoContable.getId() != null){
				objRow.setCentroCostoContable(objRowCentroCostoContable);
			}
			
			objRow.setCuentaAgrupadora((String) row[++c]);
			objRow.setPorcentaje((Double) row[++c]);
			PuntoEquilibrio objRowPuntoEquilibrio = new PuntoEquilibrio();
			objRowPuntoEquilibrio.setId((String) row[++c]);
			
			if(objRowPuntoEquilibrio.getId() != null){
				objRow.setPuntoEquilibrio(objRowPuntoEquilibrio);
			}
			
			CostoVenta objRowCostoVenta = new CostoVenta();
			objRowCostoVenta.setId((String) row[++c]);
			
			if(objRowCostoVenta.getId() != null){
				objRow.setCostoVenta(objRowCostoVenta);
			}
			
			SeguridadPuerta objRowSeguridadPuerta = new SeguridadPuerta();
			objRowSeguridadPuerta.setId((String) row[++c]);
			
			if(objRowSeguridadPuerta.getId() != null){
				objRow.setSeguridadPuerta(objRowSeguridadPuerta);
			}
			
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------