package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.time.LocalDate;
import com.massoftware.a.model.*;
import com.massoftware.b.service.EmpresaFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class EmpresaDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EmpresaDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(ConnectionWrapper connection, EmpresaFilterQ1 filter) throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("Empresa_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "id", filter.getId());

		addArgEQ(statement, sqlWhereArgs, "ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgGE(statement, sqlWhereArgs, "fechaCierreVentas", filter.getFechaCierreVentasFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreVentas", filter.getFechaCierreVentasTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreStock", filter.getFechaCierreStockFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreStock", filter.getFechaCierreStockTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreFondo", filter.getFechaCierreFondoFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreFondo", filter.getFechaCierreFondoTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreCompras", filter.getFechaCierreComprasFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreCompras", filter.getFechaCierreComprasTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreContabilidad", filter.getFechaCierreContabilidadFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreContabilidad", filter.getFechaCierreContabilidadTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreGarantiaDevoluciones",
				filter.getFechaCierreGarantiaDevolucionesFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreGarantiaDevoluciones",
				filter.getFechaCierreGarantiaDevolucionesTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreTambos", filter.getFechaCierreTambosFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreTambos", filter.getFechaCierreTambosTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreRRHH", filter.getFechaCierreRRHHFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreRRHH", filter.getFechaCierreRRHHTo());

		sql = "SELECT\tCOUNT(*)::INTEGER\nFROM" + sql.split("FROM")[1];

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return (Integer) r.getTable()[0][0];
	}

	public List<Empresa> find(ConnectionWrapper connection, EmpresaFilterQ1 filter)
			throws SelectException, SQLException {

		Objects.requireNonNull(connection, "connection is null!!");
		Objects.requireNonNull(filter, "filter is null!!");

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("Empresa_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		addArgEQ(statement, sqlWhereArgs, "id", filter.getId());

		addArgEQ(statement, sqlWhereArgs, "ejercicioContable",
				(filter.getEjercicioContable() != null) ? filter.getEjercicioContable().getId() : null);
		addArgGE(statement, sqlWhereArgs, "fechaCierreVentas", filter.getFechaCierreVentasFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreVentas", filter.getFechaCierreVentasTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreStock", filter.getFechaCierreStockFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreStock", filter.getFechaCierreStockTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreFondo", filter.getFechaCierreFondoFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreFondo", filter.getFechaCierreFondoTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreCompras", filter.getFechaCierreComprasFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreCompras", filter.getFechaCierreComprasTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreContabilidad", filter.getFechaCierreContabilidadFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreContabilidad", filter.getFechaCierreContabilidadTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreGarantiaDevoluciones",
				filter.getFechaCierreGarantiaDevolucionesFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreGarantiaDevoluciones",
				filter.getFechaCierreGarantiaDevolucionesTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreTambos", filter.getFechaCierreTambosFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreTambos", filter.getFechaCierreTambosTo());
		addArgGE(statement, sqlWhereArgs, "fechaCierreRRHH", filter.getFechaCierreRRHHFrom());
		addArgLE(statement, sqlWhereArgs, "fechaCierreRRHH", filter.getFechaCierreRRHHTo());

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<Empresa> buildObjsQ1(Result r) {

		List<Empresa> items = new ArrayList<Empresa>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			Empresa objRow = new Empresa();

			objRow.setId((String) row[++c]);

			EjercicioContable objRowEjercicioContable = new EjercicioContable();
			objRowEjercicioContable.setId((String) row[++c]);

			objRowEjercicioContable.setNumero((Integer) row[++c]);
			objRowEjercicioContable.setApertura((LocalDate) row[++c]);
			objRowEjercicioContable.setCierre((LocalDate) row[++c]);
			objRowEjercicioContable.setCerrado((Boolean) row[++c]);
			objRowEjercicioContable.setCerradoModulos((Boolean) row[++c]);
			objRowEjercicioContable.setComentario((String) row[++c]);

			if (objRowEjercicioContable.getId() != null) {
				objRow.setEjercicioContable(objRowEjercicioContable);
			}

			objRow.setFechaCierreVentas((LocalDate) row[++c]);
			objRow.setFechaCierreStock((LocalDate) row[++c]);
			objRow.setFechaCierreFondo((LocalDate) row[++c]);
			objRow.setFechaCierreCompras((LocalDate) row[++c]);
			objRow.setFechaCierreContabilidad((LocalDate) row[++c]);
			objRow.setFechaCierreGarantiaDevoluciones((LocalDate) row[++c]);
			objRow.setFechaCierreTambos((LocalDate) row[++c]);
			objRow.setFechaCierreRRHH((LocalDate) row[++c]);

			items.add(objRow);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------