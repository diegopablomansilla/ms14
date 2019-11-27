package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.a.model.CostoVenta;
import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.a.model.SeguridadModulo;
import com.massoftware.a.model.SeguridadPuerta;
import com.massoftware.a.model.TipoPuntoEquilibrio;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ1;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ2;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ3;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ4;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ5;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ6;
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

	public Integer count(ConnectionWrapper connection, CuentaContableFilterQ1 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("CuentaContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.id", filter.getId());

		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.codigo", filter.getCodigo());
		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.nombre", filter.getNombre());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.integra",
				(filter.getIntegra() != null) ? filter.getIntegra().getId() : null);

//		addArgLIKE(statement, sqlWhereArgs, "cuentaJerarquia", filter.getCuentaJerarquia());
		addArgStartEQ(statement, sqlWhereArgs, "CuentaContable_0.cuentaJerarquia", filter.getCuentaJerarquia());

		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.imputable", filter.getImputable());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.ajustaPorInflacion", filter.getAjustaPorInflacion());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.cuentaContableEstado", filter.getCuentaContableEstado());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.cuentaConApropiacion", filter.getCuentaConApropiacion());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.centroCostoContable",
				(filter.getCentroCostoContable() != null) ? filter.getCentroCostoContable().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.cuentaAgrupadora", filter.getCuentaAgrupadora());
		addArgGE(statement, sqlWhereArgs, "CuentaContable_0.porcentaje", filter.getPorcentajeFrom());
		addArgLE(statement, sqlWhereArgs, "CuentaContable_0.porcentaje", filter.getPorcentajeTo());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.puntoEquilibrio",
				(filter.getPuntoEquilibrio() != null) ? filter.getPuntoEquilibrio().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.costoVenta",
				(filter.getCostoVenta() != null) ? filter.getCostoVenta().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.seguridadPuerta",
				(filter.getSeguridadPuerta() != null) ? filter.getSeguridadPuerta().getId() : null);

		sql = "SELECT\tCOUNT(*)::INTEGER\nFROM" + sql.split("FROM")[1];

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return (Integer) r.getTable()[0][0];
	}

	public List<CuentaContable> find(ConnectionWrapper connection, CuentaContableFilterQ1 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("CuentaContable_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.id", filter.getId());

		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.codigo", filter.getCodigo());
		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.nombre", filter.getNombre());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.integra",
				(filter.getIntegra() != null) ? filter.getIntegra().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.cuentaJerarquia", filter.getCuentaJerarquia());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.imputable", filter.getImputable());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.ajustaPorInflacion", filter.getAjustaPorInflacion());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.cuentaContableEstado", filter.getCuentaContableEstado());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.cuentaConApropiacion", filter.getCuentaConApropiacion());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.centroCostoContable",
				(filter.getCentroCostoContable() != null) ? filter.getCentroCostoContable().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "CuentaContable_0.cuentaAgrupadora", filter.getCuentaAgrupadora());
		addArgGE(statement, sqlWhereArgs, "CuentaContable_0.porcentaje", filter.getPorcentajeFrom());
		addArgLE(statement, sqlWhereArgs, "CuentaContable_0.porcentaje", filter.getPorcentajeTo());
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.puntoEquilibrio",
				(filter.getPuntoEquilibrio() != null) ? filter.getPuntoEquilibrio().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.costoVenta",
				(filter.getCostoVenta() != null) ? filter.getCostoVenta().getId() : null);
		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.seguridadPuerta",
				(filter.getSeguridadPuerta() != null) ? filter.getSeguridadPuerta().getId() : null);

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

			if (objRowEjercicioContable.getId() != null) {
				objRow.setEjercicioContable(objRowEjercicioContable);
			}

			CuentaContable objRowIntegra = new CuentaContable();
			objRowIntegra.setId((String) row[++c]);

			if (objRowIntegra.getId() != null) {
				objRow.setIntegra(objRowIntegra);
			}

			objRow.setCuentaJerarquia((String) row[++c]);
			objRow.setImputable((Boolean) row[++c]);
			objRow.setAjustaPorInflacion((Boolean) row[++c]);
			objRow.setCuentaContableEstado((Boolean) row[++c]);
			objRow.setCuentaConApropiacion((Boolean) row[++c]);

			// ------------------------

			CentroCostoContable objRowCentroCostoContable = new CentroCostoContable();
			objRowCentroCostoContable.setId((String) row[++c]);

			objRowCentroCostoContable.setNumero((Integer) row[++c]);
			objRowCentroCostoContable.setNombre((String) row[++c]);
			objRowCentroCostoContable.setAbreviatura((String) row[++c]);
			EjercicioContable objRowCentroCostoContableEjercicioContable = new EjercicioContable();
			objRowCentroCostoContableEjercicioContable.setId((String) row[++c]);

			if (objRowCentroCostoContableEjercicioContable.getId() != null) {
				objRowCentroCostoContable.setEjercicioContable(objRowEjercicioContable);
			}

			if (objRowCentroCostoContable.getId() != null) {
				objRow.setCentroCostoContable(objRowCentroCostoContable);
			}

			// ------------------------

			objRow.setCuentaAgrupadora((String) row[++c]);
			objRow.setPorcentaje((Double) row[++c]);
			PuntoEquilibrio objRowPuntoEquilibrio = new PuntoEquilibrio();
			objRowPuntoEquilibrio.setId((String) row[++c]);

			if (objRowPuntoEquilibrio.getId() != null) {
				objRow.setPuntoEquilibrio(objRowPuntoEquilibrio);
			}

			CostoVenta objRowCostoVenta = new CostoVenta();
			objRowCostoVenta.setId((String) row[++c]);

			if (objRowCostoVenta.getId() != null) {
				objRow.setCostoVenta(objRowCostoVenta);
			}

			SeguridadPuerta objRowSeguridadPuerta = new SeguridadPuerta();
			objRowSeguridadPuerta.setId((String) row[++c]);

			if (objRowSeguridadPuerta.getId() != null) {
				objRow.setSeguridadPuerta(objRowSeguridadPuerta);
			}

			items.add(objRow);
		}

		return items;
	}

	public List<CuentaContable> find(ConnectionWrapper connection, CuentaContableFilterQ2 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("CuentaContable_q2");

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgEQ(statement, sqlWhereArgs, "CuentaContable_0.id", filter.getId());

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

//		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

//		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ2(r);
	}

	private List<CuentaContable> buildObjsQ2(Result r) {

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

			if (objRowEjercicioContable.getId() != null) {
				objRow.setEjercicioContable(objRowEjercicioContable);
			}

			CuentaContable objRowIntegra = new CuentaContable();
			objRowIntegra.setId((String) row[++c]);
			objRowIntegra.setCuentaJerarquia((String) row[++c]);

			if (objRowIntegra.getId() != null) {
				objRow.setIntegra(objRowIntegra);
			}

			objRow.setCuentaJerarquia((String) row[++c]);
			objRow.setImputable((Boolean) row[++c]);
			objRow.setAjustaPorInflacion((Boolean) row[++c]);
			objRow.setCuentaContableEstado((Boolean) row[++c]);
			objRow.setCuentaConApropiacion((Boolean) row[++c]);

			// ------------------------ CentroCostoContable

			CentroCostoContable objRowCentroCostoContable = new CentroCostoContable();

			objRowCentroCostoContable.setId((String) row[++c]);
			objRowCentroCostoContable.setNumero((Integer) row[++c]);
			objRowCentroCostoContable.setNombre((String) row[++c]);
			objRowCentroCostoContable.setAbreviatura((String) row[++c]);

			EjercicioContable objRowCentroCostoContableEjercicioContable = new EjercicioContable();
			objRowCentroCostoContableEjercicioContable.setId((String) row[++c]);
			if (objRowCentroCostoContableEjercicioContable.getId() != null) {
				objRowCentroCostoContable.setEjercicioContable(objRowEjercicioContable);
			}

			if (objRowCentroCostoContable.getId() != null) {
				objRow.setCentroCostoContable(objRowCentroCostoContable);
			}

			// ------------------------ CentroCostoContable

			objRow.setCuentaAgrupadora((String) row[++c]);
			objRow.setPorcentaje((Double) row[++c]);

			// ------------------------ PuntoEquilibrio

			PuntoEquilibrio objRowPuntoEquilibrio = new PuntoEquilibrio();
			objRowPuntoEquilibrio.setId((String) row[++c]);
			objRowPuntoEquilibrio.setNumero((Integer) row[++c]);
			objRowPuntoEquilibrio.setNombre((String) row[++c]);

			TipoPuntoEquilibrio objRowTipoPuntoEquilibrio = new TipoPuntoEquilibrio();
			objRowTipoPuntoEquilibrio.setId((String) row[++c]);
//			objRowTipoPuntoEquilibrio.setNumero((Integer) row[++c]);
//			objRowTipoPuntoEquilibrio.setNombre((String) row[++c]);

			if (objRowTipoPuntoEquilibrio.getId() != null) {
				objRowPuntoEquilibrio.setTipoPuntoEquilibrio(objRowTipoPuntoEquilibrio);
			}

			EjercicioContable objRowPuntoEquilibrioEjercicioContable = new EjercicioContable();
			objRowPuntoEquilibrioEjercicioContable.setId((String) row[++c]);

			if (objRowPuntoEquilibrioEjercicioContable.getId() != null) {
				objRowPuntoEquilibrio.setEjercicioContable(objRowPuntoEquilibrioEjercicioContable);
			}

			if (objRowPuntoEquilibrio.getId() != null) {
				objRow.setPuntoEquilibrio(objRowPuntoEquilibrio);
			}

			// ------------------------ PuntoEquilibrio

			//

			// ------------------------ CostoVenta

			CostoVenta objRowCostoVenta = new CostoVenta();
			objRowCostoVenta.setId((String) row[++c]);
			objRowCostoVenta.setNumero((Integer) row[++c]);
			objRowCostoVenta.setNombre((String) row[++c]);

			if (objRowCostoVenta.getId() != null) {
				objRow.setCostoVenta(objRowCostoVenta);
			}

			// ------------------------ CostoVenta

			//

			// ------------------------ SeguridadPuerta

			SeguridadPuerta objRowSeguridadPuerta = new SeguridadPuerta();
			objRowSeguridadPuerta.setId((String) row[++c]);

			objRowSeguridadPuerta.setNumero((Integer) row[++c]);
			objRowSeguridadPuerta.setNombre((String) row[++c]);
			objRowSeguridadPuerta.setEquate((String) row[++c]);
			SeguridadModulo objRowSeguridadModulo = new SeguridadModulo();
			objRowSeguridadModulo.setId((String) row[++c]);

			if (objRowSeguridadModulo.getId() != null) {
				objRowSeguridadPuerta.setSeguridadModulo(objRowSeguridadModulo);
			}

			if (objRowSeguridadPuerta.getId() != null) {
				objRow.setSeguridadPuerta(objRowSeguridadPuerta);
			}

			// ------------------------ SeguridadPuerta

			items.add(objRow);
		}

		return items;
	}

	public List<CuentaContable> find(ConnectionWrapper connection, CuentaContableFilterQ3 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");
		Objects.requireNonNull(filter.getEjercicioContable(), "ejercicioContable is null!!");
		Objects.requireNonNull(filter.getEjercicioContable().getId(), "ejercicioContable.id is null!!");
		Objects.requireNonNull(filter.getCuentaJerarquia(), "cuentaJerarquia is null!!");

		Statement statement = new Statement();

//		String sql = this.sourceSQL.get("CuentaContable_q3");

		String sql = "SELECT id, cuentaJerarquia FROM massoftware.CuentaContable ${WHERE}";

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgEQ(statement, sqlWhereArgs, "ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);

		addArgEQ(statement, sqlWhereArgs, "cuentaJerarquia", filter.getCuentaJerarquia());

//		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

//		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

//		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ3(r);
	}

	private List<CuentaContable> buildObjsQ3(Result r) {

		List<CuentaContable> items = new ArrayList<CuentaContable>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			CuentaContable objRow = new CuentaContable();

			objRow.setId((String) row[++c]);

			objRow.setCuentaJerarquia((String) row[++c]);

			items.add(objRow);
		}

		return items;
	}

	public boolean exists(ConnectionWrapper connection, CuentaContableFilterQ4 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");
		Objects.requireNonNull(filter.getId(), "filter id is null!!");
		Objects.requireNonNull(filter.getEjercicioContable(), "filter ejercicioContable is null!!");
		Objects.requireNonNull(filter.getEjercicioContable().getId(), "filter ejercicioContable.id is null!!");
		Objects.requireNonNull(filter.getCodigo(), "filter codigo is null!!");

		Statement statement = new Statement();

		String sql = "SELECT count(*) > 0 FROM massoftware.CuentaContable ${WHERE}";

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgNEQ(statement, sqlWhereArgs, "id", filter.getId());

		addArgEQLIKE(statement, sqlWhereArgs, "codigo", filter.getCodigo());

		addArgEQ(statement, sqlWhereArgs, "ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return (boolean) r.getTable()[0][0];
	}

	public boolean exists(ConnectionWrapper connection, CuentaContableFilterQ5 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");
		Objects.requireNonNull(filter.getId(), "filter id is null!!");
		Objects.requireNonNull(filter.getEjercicioContable(), "filter ejercicioContable is null!!");
		Objects.requireNonNull(filter.getEjercicioContable().getId(), "filter ejercicioContable.id is null!!");
		Objects.requireNonNull(filter.getNombre(), "filter nombre is null!!");

		Statement statement = new Statement();

		String sql = "SELECT count(*) > 0 FROM massoftware.CuentaContable ${WHERE}";

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgNEQ(statement, sqlWhereArgs, "id", filter.getId());

		addArgEQLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());

		addArgEQ(statement, sqlWhereArgs, "ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return (boolean) r.getTable()[0][0];
	}

	public boolean exists(ConnectionWrapper connection, CuentaContableFilterQ6 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");
		Objects.requireNonNull(filter.getId(), "filter id is null!!");
		Objects.requireNonNull(filter.getEjercicioContable(), "filter ejercicioContable is null!!");
		Objects.requireNonNull(filter.getEjercicioContable().getId(), "filter ejercicioContable.id is null!!");
//		Objects.requireNonNull(filter.getIntegra(), "filter Integra is null!!");
//		Objects.requireNonNull(filter.getIntegra().getId(), "filter integra.id is null!!");
		Objects.requireNonNull(filter.getCuentaJerarquia(), "filter cuentaJerarquia is null!!");

		Statement statement = new Statement();

		String sql = "SELECT count(*) > 0 FROM massoftware.CuentaContable ${WHERE}";

		List<String> sqlWhereArgs = new ArrayList<String>();

		addArgNEQ(statement, sqlWhereArgs, "id", filter.getId());

		addArgEQ(statement, sqlWhereArgs, "integra",
				(filter.getIntegra() != null) ? filter.getIntegra().getId() : null);

		addArgEQ(statement, sqlWhereArgs, "cuentaJerarquia", filter.getCuentaJerarquia());

		addArgEQ(statement, sqlWhereArgs, "ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return (boolean) r.getTable()[0][0];
	}

} // END CLASS -----------------------------------------------------------------