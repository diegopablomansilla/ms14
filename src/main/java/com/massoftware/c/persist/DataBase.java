package com.massoftware.c.persist;

import java.util.List;

import com.massoftware.a.model.AsientoContable;
import com.massoftware.a.model.AsientoContableItem;
import com.massoftware.a.model.AsientoContableModulo;
import com.massoftware.a.model.AsientoModelo;
import com.massoftware.a.model.AsientoModeloItem;
import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.a.model.CostoVenta;
import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.Empresa;
import com.massoftware.a.model.MinutaContable;
import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.a.model.SeguridadModulo;
import com.massoftware.a.model.SeguridadPuerta;
import com.massoftware.a.model.Sucursal;
import com.massoftware.a.model.TipoPuntoEquilibrio;
import com.massoftware.a.model.TipoSucursal;
import com.massoftware.a.model.Usuario;
import com.massoftware.b.service.AsientoContableFilterQ1;
import com.massoftware.b.service.AsientoContableItemFilterQ1;
import com.massoftware.b.service.AsientoContableModuloFilterQ1;
import com.massoftware.b.service.AsientoModeloFilterQ1;
import com.massoftware.b.service.AsientoModeloItemFilterQ1;
import com.massoftware.b.service.CentroCostoContableFilterQ1;
import com.massoftware.b.service.CostoVentaFilterQ1;
import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.b.service.EmpresaFilterQ1;
import com.massoftware.b.service.MinutaContableFilterQ1;
import com.massoftware.b.service.PuntoEquilibrioFilterQ1;
import com.massoftware.b.service.SeguridadModuloFilterQ1;
import com.massoftware.b.service.SeguridadPuertaFilterQ1;
import com.massoftware.b.service.SucursalFilterQ1;
import com.massoftware.b.service.TipoPuntoEquilibrioFilterQ1;
import com.massoftware.b.service.TipoSucursalFilterQ1;
import com.massoftware.b.service.UsuarioFilterQ1;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ1;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ2;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ3;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ4;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ5;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ6;
import com.massoftware.c.persist.dao.AsientoContableDAO;
import com.massoftware.c.persist.dao.AsientoContableItemDAO;
import com.massoftware.c.persist.dao.AsientoContableModuloDAO;
import com.massoftware.c.persist.dao.AsientoModeloDAO;
import com.massoftware.c.persist.dao.AsientoModeloItemDAO;
import com.massoftware.c.persist.dao.CentroCostoContableDAO;
import com.massoftware.c.persist.dao.CostoVentaDAO;
import com.massoftware.c.persist.dao.CuentaContableDAO;
import com.massoftware.c.persist.dao.EjercicioContableDAO;
import com.massoftware.c.persist.dao.EmpresaDAO;
import com.massoftware.c.persist.dao.MinutaContableDAO;
import com.massoftware.c.persist.dao.PuntoEquilibrioDAO;
import com.massoftware.c.persist.dao.SeguridadModuloDAO;
import com.massoftware.c.persist.dao.SeguridadPuertaDAO;
import com.massoftware.c.persist.dao.SucursalDAO;
import com.massoftware.c.persist.dao.TipoPuntoEquilibrioDAO;
import com.massoftware.c.persist.dao.TipoSucursalDAO;
import com.massoftware.c.persist.dao.UsuarioDAO;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class DataBase extends AbstractDataBase {

	// ---------------------------------------------------------------------------------------------------------------------------

	private UsuarioDAO usuarioDAO;
	private SeguridadModuloDAO seguridadModuloDAO;
	private SeguridadPuertaDAO seguridadPuertaDAO;
	private TipoSucursalDAO tipoSucursalDAO;
	private SucursalDAO sucursalDAO;
	private EjercicioContableDAO ejercicioContableDAO;
	private CentroCostoContableDAO centroCostoContableDAO;
	private TipoPuntoEquilibrioDAO tipoPuntoEquilibrioDAO;
	private PuntoEquilibrioDAO puntoEquilibrioDAO;
	private CostoVentaDAO costoVentaDAO;
	private CuentaContableDAO cuentaContableDAO;
	private AsientoModeloDAO asientoModeloDAO;
	private AsientoModeloItemDAO asientoModeloItemDAO;
	private MinutaContableDAO minutaContableDAO;
	private AsientoContableModuloDAO asientoContableModuloDAO;
	private AsientoContableDAO asientoContableDAO;
	private AsientoContableItemDAO asientoContableItemDAO;
	private EmpresaDAO empresaDAO;

	// ---------------------------------------------------------------------------------------------------------------------------

	protected DataBase(SourceSQL sourceSQL, ConnectionWrapper connection) {
		super(sourceSQL, connection);

		usuarioDAO = new UsuarioDAO(this.sourceSQL);
		seguridadModuloDAO = new SeguridadModuloDAO(this.sourceSQL);
		seguridadPuertaDAO = new SeguridadPuertaDAO(this.sourceSQL);
		tipoSucursalDAO = new TipoSucursalDAO(this.sourceSQL);
		sucursalDAO = new SucursalDAO(this.sourceSQL);
		ejercicioContableDAO = new EjercicioContableDAO(this.sourceSQL);
		centroCostoContableDAO = new CentroCostoContableDAO(this.sourceSQL);
		tipoPuntoEquilibrioDAO = new TipoPuntoEquilibrioDAO(this.sourceSQL);
		puntoEquilibrioDAO = new PuntoEquilibrioDAO(this.sourceSQL);
		costoVentaDAO = new CostoVentaDAO(this.sourceSQL);
		cuentaContableDAO = new CuentaContableDAO(this.sourceSQL);
		asientoModeloDAO = new AsientoModeloDAO(this.sourceSQL);
		asientoModeloItemDAO = new AsientoModeloItemDAO(this.sourceSQL);
		minutaContableDAO = new MinutaContableDAO(this.sourceSQL);
		asientoContableModuloDAO = new AsientoContableModuloDAO(this.sourceSQL);
		asientoContableDAO = new AsientoContableDAO(this.sourceSQL);
		asientoContableItemDAO = new AsientoContableItemDAO(this.sourceSQL);
		empresaDAO = new EmpresaDAO(this.sourceSQL);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public List<Usuario> find(UsuarioFilterQ1 filter) throws Exception {
		return usuarioDAO.find(connection, filter);
	}

	public Integer count(UsuarioFilterQ1 filter) throws Exception {
		return usuarioDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<SeguridadModulo> find(SeguridadModuloFilterQ1 filter) throws Exception {
		return seguridadModuloDAO.find(connection, filter);
	}

	public Integer count(SeguridadModuloFilterQ1 filter) throws Exception {
		return seguridadModuloDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<SeguridadPuerta> find(SeguridadPuertaFilterQ1 filter) throws Exception {
		return seguridadPuertaDAO.find(connection, filter);
	}

	public Integer count(SeguridadPuertaFilterQ1 filter) throws Exception {
		return seguridadPuertaDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<TipoSucursal> find(TipoSucursalFilterQ1 filter) throws Exception {
		return tipoSucursalDAO.find(connection, filter);
	}

	public Integer count(TipoSucursalFilterQ1 filter) throws Exception {
		return tipoSucursalDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<Sucursal> find(SucursalFilterQ1 filter) throws Exception {
		return sucursalDAO.find(connection, filter);
	}

	public Integer count(SucursalFilterQ1 filter) throws Exception {
		return sucursalDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<EjercicioContable> find(EjercicioContableFilterQ1 filter) throws Exception {
		return ejercicioContableDAO.find(connection, filter);
	}

	public Integer count(EjercicioContableFilterQ1 filter) throws Exception {
		return ejercicioContableDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CentroCostoContable> find(CentroCostoContableFilterQ1 filter) throws Exception {
		return centroCostoContableDAO.find(connection, filter);
	}

	public Integer count(CentroCostoContableFilterQ1 filter) throws Exception {
		return centroCostoContableDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<TipoPuntoEquilibrio> find(TipoPuntoEquilibrioFilterQ1 filter) throws Exception {
		return tipoPuntoEquilibrioDAO.find(connection, filter);
	}

	public Integer count(TipoPuntoEquilibrioFilterQ1 filter) throws Exception {
		return tipoPuntoEquilibrioDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<PuntoEquilibrio> find(PuntoEquilibrioFilterQ1 filter) throws Exception {
		return puntoEquilibrioDAO.find(connection, filter);
	}

	public Integer count(PuntoEquilibrioFilterQ1 filter) throws Exception {
		return puntoEquilibrioDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CostoVenta> find(CostoVentaFilterQ1 filter) throws Exception {
		return costoVentaDAO.find(connection, filter);
	}

	public Integer count(CostoVentaFilterQ1 filter) throws Exception {
		return costoVentaDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<CuentaContable> find(CuentaContableFilterQ1 filter) throws Exception {
		return cuentaContableDAO.find(connection, filter);
	}

	public List<CuentaContable> find(CuentaContableFilterQ2 filter) throws Exception {
		return cuentaContableDAO.find(connection, filter);
	}

	public List<CuentaContable> find(CuentaContableFilterQ3 filter) throws Exception {
		return cuentaContableDAO.find(connection, filter);
	}

	public Integer count(CuentaContableFilterQ1 filter) throws Exception {
		return cuentaContableDAO.count(connection, filter);
	}

	public boolean exists(CuentaContableFilterQ4 filter) throws Exception {
		return cuentaContableDAO.exists(connection, filter);
	}

	public boolean exists(CuentaContableFilterQ5 filter) throws Exception {
		return cuentaContableDAO.exists(connection, filter);
	}

	public boolean exists(CuentaContableFilterQ6 filter) throws Exception {
		return cuentaContableDAO.exists(connection, filter);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoModelo> find(AsientoModeloFilterQ1 filter) throws Exception {
		return asientoModeloDAO.find(connection, filter);
	}

	public Integer count(AsientoModeloFilterQ1 filter) throws Exception {
		return asientoModeloDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoModeloItem> find(AsientoModeloItemFilterQ1 filter) throws Exception {
		return asientoModeloItemDAO.find(connection, filter);
	}

	public Integer count(AsientoModeloItemFilterQ1 filter) throws Exception {
		return asientoModeloItemDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<MinutaContable> find(MinutaContableFilterQ1 filter) throws Exception {
		return minutaContableDAO.find(connection, filter);
	}

	public Integer count(MinutaContableFilterQ1 filter) throws Exception {
		return minutaContableDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoContableModulo> find(AsientoContableModuloFilterQ1 filter) throws Exception {
		return asientoContableModuloDAO.find(connection, filter);
	}

	public Integer count(AsientoContableModuloFilterQ1 filter) throws Exception {
		return asientoContableModuloDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoContable> find(AsientoContableFilterQ1 filter) throws Exception {
		return asientoContableDAO.find(connection, filter);
	}

	public Integer count(AsientoContableFilterQ1 filter) throws Exception {
		return asientoContableDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<AsientoContableItem> find(AsientoContableItemFilterQ1 filter) throws Exception {
		return asientoContableItemDAO.find(connection, filter);
	}

	public Integer count(AsientoContableItemFilterQ1 filter) throws Exception {
		return asientoContableItemDAO.count(connection, filter);
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<Empresa> find(EmpresaFilterQ1 filter) throws Exception {
		return empresaDAO.find(connection, filter);
	}

	public Integer count(EmpresaFilterQ1 filter) throws Exception {
		return empresaDAO.count(connection, filter);
	}

} // END CLASS -----------------------------------------------------------------