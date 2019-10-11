package com.massoftware.c.persist;

import java.util.List;

import com.massoftware.a.model.*;
import com.massoftware.b.service.*;
import com.massoftware.c.persist.dao.*;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class DataBase extends AbstractDataBase {

	// ---------------------------------------------------------------------------------------------------------------------------

	
	private UsuarioDAO usuarioDAO;
	private SeguridadModuloDAO seguridadModuloDAO;
	private SeguridadPuertaDAO seguridadPuertaDAO;
	private EjercicioContableDAO ejercicioContableDAO;
	private CentroCostoContableDAO centroCostoContableDAO;
	private TipoPuntoEquilibrioDAO tipoPuntoEquilibrioDAO;
	private PuntoEquilibrioDAO puntoEquilibrioDAO;
	private CostoVentaDAO costoVentaDAO;
	private CuentaContableEstadoDAO cuentaContableEstadoDAO;
	private CuentaContableDAO cuentaContableDAO;
	private AsientoModeloDAO asientoModeloDAO;
	private AsientoModeloItemDAO asientoModeloItemDAO;

	// ---------------------------------------------------------------------------------------------------------------------------

	protected DataBase(SourceSQL sourceSQL, ConnectionWrapper connection) {
		super(sourceSQL, connection);		
		
		usuarioDAO = new UsuarioDAO(this.sourceSQL);	
		seguridadModuloDAO = new SeguridadModuloDAO(this.sourceSQL);	
		seguridadPuertaDAO = new SeguridadPuertaDAO(this.sourceSQL);	
		ejercicioContableDAO = new EjercicioContableDAO(this.sourceSQL);	
		centroCostoContableDAO = new CentroCostoContableDAO(this.sourceSQL);	
		tipoPuntoEquilibrioDAO = new TipoPuntoEquilibrioDAO(this.sourceSQL);	
		puntoEquilibrioDAO = new PuntoEquilibrioDAO(this.sourceSQL);	
		costoVentaDAO = new CostoVentaDAO(this.sourceSQL);	
		cuentaContableEstadoDAO = new CuentaContableEstadoDAO(this.sourceSQL);	
		cuentaContableDAO = new CuentaContableDAO(this.sourceSQL);	
		asientoModeloDAO = new AsientoModeloDAO(this.sourceSQL);	
		asientoModeloItemDAO = new AsientoModeloItemDAO(this.sourceSQL);			
	}	
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<Usuario> find(UsuarioFilterQ1 filter) throws Exception {
		return usuarioDAO.find(connection, filter);
	}

	public Long count(UsuarioFilterQ1 filter) throws Exception {
		return usuarioDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<SeguridadModulo> find(SeguridadModuloFilterQ1 filter) throws Exception {
		return seguridadModuloDAO.find(connection, filter);
	}

	public Long count(SeguridadModuloFilterQ1 filter) throws Exception {
		return seguridadModuloDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<SeguridadPuerta> find(SeguridadPuertaFilterQ1 filter) throws Exception {
		return seguridadPuertaDAO.find(connection, filter);
	}

	public Long count(SeguridadPuertaFilterQ1 filter) throws Exception {
		return seguridadPuertaDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<EjercicioContable> find(EjercicioContableFilterQ1 filter) throws Exception {
		return ejercicioContableDAO.find(connection, filter);
	}

	public Long count(EjercicioContableFilterQ1 filter) throws Exception {
		return ejercicioContableDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CentroCostoContable> find(CentroCostoContableFilterQ1 filter) throws Exception {
		return centroCostoContableDAO.find(connection, filter);
	}

	public Long count(CentroCostoContableFilterQ1 filter) throws Exception {
		return centroCostoContableDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<TipoPuntoEquilibrio> find(TipoPuntoEquilibrioFilterQ1 filter) throws Exception {
		return tipoPuntoEquilibrioDAO.find(connection, filter);
	}

	public Long count(TipoPuntoEquilibrioFilterQ1 filter) throws Exception {
		return tipoPuntoEquilibrioDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<PuntoEquilibrio> find(PuntoEquilibrioFilterQ1 filter) throws Exception {
		return puntoEquilibrioDAO.find(connection, filter);
	}

	public Long count(PuntoEquilibrioFilterQ1 filter) throws Exception {
		return puntoEquilibrioDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CostoVenta> find(CostoVentaFilterQ1 filter) throws Exception {
		return costoVentaDAO.find(connection, filter);
	}

	public Long count(CostoVentaFilterQ1 filter) throws Exception {
		return costoVentaDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CuentaContableEstado> find(CuentaContableEstadoFilterQ1 filter) throws Exception {
		return cuentaContableEstadoDAO.find(connection, filter);
	}

	public Long count(CuentaContableEstadoFilterQ1 filter) throws Exception {
		return cuentaContableEstadoDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CuentaContable> find(CuentaContableFilterQ1 filter) throws Exception {
		return cuentaContableDAO.find(connection, filter);
	}

	public Long count(CuentaContableFilterQ1 filter) throws Exception {
		return cuentaContableDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoModelo> find(AsientoModeloFilterQ1 filter) throws Exception {
		return asientoModeloDAO.find(connection, filter);
	}

	public Long count(AsientoModeloFilterQ1 filter) throws Exception {
		return asientoModeloDAO.count(connection, filter);
	}	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoModeloItem> find(AsientoModeloItemFilterQ1 filter) throws Exception {
		return asientoModeloItemDAO.find(connection, filter);
	}

	public Long count(AsientoModeloItemFilterQ1 filter) throws Exception {
		return asientoModeloItemDAO.count(connection, filter);
	}	
	
} // END CLASS -----------------------------------------------------------------