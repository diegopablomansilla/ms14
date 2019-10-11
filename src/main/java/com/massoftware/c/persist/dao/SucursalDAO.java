package com.massoftware.c.persist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.*;
import com.massoftware.b.service.SucursalFilterQ1;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.SelectException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class SucursalDAO extends AbstractDAO {

	private SourceSQL sourceSQL;

	// ---------------------------------------------------------------------------------------------------------------------------

	public SucursalDAO(SourceSQL sourceSQL) {
		super();
		this.sourceSQL = sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(ConnectionWrapper connection, SucursalFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("Sucursal_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();		
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());
		addArgLIKE(statement, sqlWhereArgs, "abreviatura", filter.getAbreviatura());
		addArgEQ(statement, sqlWhereArgs, "tipoSucursal", (filter.getTipoSucursal() != null) ? filter.getTipoSucursal().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "cuentaClientesDesde", filter.getCuentaClientesDesde());
		addArgLIKE(statement, sqlWhereArgs, "cuentaClientesHasta", filter.getCuentaClientesHasta());
		addArgGE(statement, sqlWhereArgs, "cantidadCaracteresClientes", filter.getCantidadCaracteresClientesFrom());
		addArgLE(statement, sqlWhereArgs, "cantidadCaracteresClientes", filter.getCantidadCaracteresClientesTo());
		addArgEQ(statement, sqlWhereArgs, "identificacionNumericaClientes", filter.getIdentificacionNumericaClientes());
		addArgEQ(statement, sqlWhereArgs, "permiteCambiarClientes", filter.getPermiteCambiarClientes());
		addArgLIKE(statement, sqlWhereArgs, "cuentaProveedoresDesde", filter.getCuentaProveedoresDesde());
		addArgLIKE(statement, sqlWhereArgs, "cuentaProveedoresHasta", filter.getCuentaProveedoresHasta());
		addArgGE(statement, sqlWhereArgs, "cantidadCaracteresProveedores", filter.getCantidadCaracteresProveedoresFrom());
		addArgLE(statement, sqlWhereArgs, "cantidadCaracteresProveedores", filter.getCantidadCaracteresProveedoresTo());
		addArgEQ(statement, sqlWhereArgs, "identificacionNumericaProveedores", filter.getIdentificacionNumericaProveedores());
		addArgEQ(statement, sqlWhereArgs, "permiteCambiarProveedores", filter.getPermiteCambiarProveedores());
		addArgGE(statement, sqlWhereArgs, "clientesOcacionalesDesde", filter.getClientesOcacionalesDesdeFrom());
		addArgLE(statement, sqlWhereArgs, "clientesOcacionalesDesde", filter.getClientesOcacionalesDesdeTo());
		addArgGE(statement, sqlWhereArgs, "clientesOcacionalesHasta", filter.getClientesOcacionalesHastaFrom());
		addArgLE(statement, sqlWhereArgs, "clientesOcacionalesHasta", filter.getClientesOcacionalesHastaTo());
		addArgGE(statement, sqlWhereArgs, "numeroCobranzaDesde", filter.getNumeroCobranzaDesdeFrom());
		addArgLE(statement, sqlWhereArgs, "numeroCobranzaDesde", filter.getNumeroCobranzaDesdeTo());
		addArgGE(statement, sqlWhereArgs, "numeroCobranzaHasta", filter.getNumeroCobranzaHastaFrom());
		addArgLE(statement, sqlWhereArgs, "numeroCobranzaHasta", filter.getNumeroCobranzaHastaTo());

		sql = "SELECT\tCOUNT(*)\nFROM" + sql.split("FROM")[1];
		
		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", "").trim();

		sql = sql.replace("${PAGE}", "").trim();

		statement.setSql(sql);

		Result r = connection.query(statement);		
		
		return (Long) r.getTable()[0][0];
	}
	
	public List<Sucursal> find(ConnectionWrapper connection, SucursalFilterQ1 filter)
			throws SelectException, SQLException {

		Statement statement = new Statement();

		String sql = this.sourceSQL.get("Sucursal_q1");

		List<String> sqlWhereArgs = new ArrayList<String>();
		
		addArgGE(statement, sqlWhereArgs, "numero", filter.getNumeroFrom());
		addArgLE(statement, sqlWhereArgs, "numero", filter.getNumeroTo());
		addArgLIKE(statement, sqlWhereArgs, "nombre", filter.getNombre());
		addArgLIKE(statement, sqlWhereArgs, "abreviatura", filter.getAbreviatura());
		addArgEQ(statement, sqlWhereArgs, "tipoSucursal", (filter.getTipoSucursal() != null) ? filter.getTipoSucursal().getId() : null);
		addArgLIKE(statement, sqlWhereArgs, "cuentaClientesDesde", filter.getCuentaClientesDesde());
		addArgLIKE(statement, sqlWhereArgs, "cuentaClientesHasta", filter.getCuentaClientesHasta());
		addArgGE(statement, sqlWhereArgs, "cantidadCaracteresClientes", filter.getCantidadCaracteresClientesFrom());
		addArgLE(statement, sqlWhereArgs, "cantidadCaracteresClientes", filter.getCantidadCaracteresClientesTo());
		addArgEQ(statement, sqlWhereArgs, "identificacionNumericaClientes", filter.getIdentificacionNumericaClientes());
		addArgEQ(statement, sqlWhereArgs, "permiteCambiarClientes", filter.getPermiteCambiarClientes());
		addArgLIKE(statement, sqlWhereArgs, "cuentaProveedoresDesde", filter.getCuentaProveedoresDesde());
		addArgLIKE(statement, sqlWhereArgs, "cuentaProveedoresHasta", filter.getCuentaProveedoresHasta());
		addArgGE(statement, sqlWhereArgs, "cantidadCaracteresProveedores", filter.getCantidadCaracteresProveedoresFrom());
		addArgLE(statement, sqlWhereArgs, "cantidadCaracteresProveedores", filter.getCantidadCaracteresProveedoresTo());
		addArgEQ(statement, sqlWhereArgs, "identificacionNumericaProveedores", filter.getIdentificacionNumericaProveedores());
		addArgEQ(statement, sqlWhereArgs, "permiteCambiarProveedores", filter.getPermiteCambiarProveedores());
		addArgGE(statement, sqlWhereArgs, "clientesOcacionalesDesde", filter.getClientesOcacionalesDesdeFrom());
		addArgLE(statement, sqlWhereArgs, "clientesOcacionalesDesde", filter.getClientesOcacionalesDesdeTo());
		addArgGE(statement, sqlWhereArgs, "clientesOcacionalesHasta", filter.getClientesOcacionalesHastaFrom());
		addArgLE(statement, sqlWhereArgs, "clientesOcacionalesHasta", filter.getClientesOcacionalesHastaTo());
		addArgGE(statement, sqlWhereArgs, "numeroCobranzaDesde", filter.getNumeroCobranzaDesdeFrom());
		addArgLE(statement, sqlWhereArgs, "numeroCobranzaDesde", filter.getNumeroCobranzaDesdeTo());
		addArgGE(statement, sqlWhereArgs, "numeroCobranzaHasta", filter.getNumeroCobranzaHastaFrom());
		addArgLE(statement, sqlWhereArgs, "numeroCobranzaHasta", filter.getNumeroCobranzaHastaTo());		

		addArgsPage(filter, statement);

		sql = sql.replace("${WHERE}", buildWhereSQL(sqlWhereArgs)).trim();

		sql = sql.replace("${ORDER_BY}", buildOrderSQL(filter)).trim();

		sql = sql.replace("${PAGE}", buildPageSQL(filter)).trim();

		statement.setSql(sql);

		Result r = connection.query(statement);

		return buildObjsQ1(r);
	}

	private List<Sucursal> buildObjsQ1(Result r) {
		List<Sucursal> items = new ArrayList<Sucursal>();

		if (r.getRowCount() == 0) {
			return items;
		}

		for (Object[] row : r.getTable()) {
			int c = -1;

			Sucursal objRow = new Sucursal();

			objRow.setId((String) row[++c]);
			
			objRow.setNumero((Integer) row[++c]);
			objRow.setNombre((String) row[++c]);
			objRow.setAbreviatura((String) row[++c]);
			TipoSucursal objRowTipoSucursal = new TipoSucursal();
			objRowTipoSucursal.setId((String) row[++c]);
			
			if(objRowTipoSucursal.getId() != null){
				objRow.setTipoSucursal(objRowTipoSucursal);
			}
			
			objRow.setCuentaClientesDesde((String) row[++c]);
			objRow.setCuentaClientesHasta((String) row[++c]);
			objRow.setCantidadCaracteresClientes((Integer) row[++c]);
			objRow.setIdentificacionNumericaClientes((Boolean) row[++c]);
			objRow.setPermiteCambiarClientes((Boolean) row[++c]);
			objRow.setCuentaProveedoresDesde((String) row[++c]);
			objRow.setCuentaProveedoresHasta((String) row[++c]);
			objRow.setCantidadCaracteresProveedores((Integer) row[++c]);
			objRow.setIdentificacionNumericaProveedores((Boolean) row[++c]);
			objRow.setPermiteCambiarProveedores((Boolean) row[++c]);
			objRow.setClientesOcacionalesDesde((Integer) row[++c]);
			objRow.setClientesOcacionalesHasta((Integer) row[++c]);
			objRow.setNumeroCobranzaDesde((Integer) row[++c]);
			objRow.setNumeroCobranzaHasta((Integer) row[++c]);
		}

		return items;
	}

} // END CLASS -----------------------------------------------------------------