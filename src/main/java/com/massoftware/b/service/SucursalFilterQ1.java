package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.TipoSucursal;

public class SucursalFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº sucursal from
	private Integer numeroFrom;		
	
	// GET Nº sucursal to
	private Integer numeroTo;		
	
	// GET Nombre
	private String nombre;		
	
	// GET Abreviatura
	private String abreviatura;		
	
	// GET Tipo sucursal
	private TipoSucursal tipoSucursal;		
	
	// GET Cuenta clientes desde
	private String cuentaClientesDesde;		
	
	// GET Cuenta clientes hasta
	private String cuentaClientesHasta;		
	
	// GET Cantidad caracteres clientes from
	private Integer cantidadCaracteresClientesFrom;		
	
	// GET Cantidad caracteres clientes to
	private Integer cantidadCaracteresClientesTo;		
	
	// GET Identificacion numérica clientes
	private Boolean identificacionNumericaClientes;		
	
	// GET Permite cambiar clientes
	private Boolean permiteCambiarClientes;		
	
	// GET Cuenta proveedores desde
	private String cuentaProveedoresDesde;		
	
	// GET Cuenta proveedores hasta
	private String cuentaProveedoresHasta;		
	
	// GET Cantidad caracteres proveedores from
	private Integer cantidadCaracteresProveedoresFrom;		
	
	// GET Cantidad caracteres proveedores to
	private Integer cantidadCaracteresProveedoresTo;		
	
	// GET Identificacion numérica proveedores
	private Boolean identificacionNumericaProveedores;		
	
	// GET Permite cambiar proveedores
	private Boolean permiteCambiarProveedores;		
	
	// GET Clientes ocacionales desde from
	private Integer clientesOcacionalesDesdeFrom;		
	
	// GET Clientes ocacionales desde to
	private Integer clientesOcacionalesDesdeTo;		
	
	// GET Clientes ocacionales hasta from
	private Integer clientesOcacionalesHastaFrom;		
	
	// GET Clientes ocacionales hasta to
	private Integer clientesOcacionalesHastaTo;		
	
	// GET Número cobranza desde from
	private Integer numeroCobranzaDesdeFrom;		
	
	// GET Número cobranza desde to
	private Integer numeroCobranzaDesdeTo;		
	
	// GET Número cobranza hasta from
	private Integer numeroCobranzaHastaFrom;		
	
	// GET Número cobranza hasta to
	private Integer numeroCobranzaHastaTo;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº sucursal from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº sucursal from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº sucursal to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº sucursal to
	public void setNumeroTo(Integer numeroTo ){
		this.numeroTo = numeroTo;
	}	
	
	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}
		
	// SET  Nombre
	public void setNombre(String nombre ){		
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}	
	
	// GET Abreviatura
	public String getAbreviatura() {
		return this.abreviatura;
	}
		
	// SET  Abreviatura
	public void setAbreviatura(String abreviatura ){		
		this.abreviatura = (abreviatura == null || abreviatura.trim().length() == 0) ? null : abreviatura.trim();
	}	
	
	// GET Tipo sucursal
	public TipoSucursal getTipoSucursal() {
		return this.tipoSucursal;
	}
		
	// SET  Tipo sucursal
	public void setTipoSucursal(TipoSucursal tipoSucursal ){
		this.tipoSucursal = tipoSucursal;
	}	
	
	// GET Cuenta clientes desde
	public String getCuentaClientesDesde() {
		return this.cuentaClientesDesde;
	}
		
	// SET  Cuenta clientes desde
	public void setCuentaClientesDesde(String cuentaClientesDesde ){		
		this.cuentaClientesDesde = (cuentaClientesDesde == null || cuentaClientesDesde.trim().length() == 0) ? null : cuentaClientesDesde.trim();
	}	
	
	// GET Cuenta clientes hasta
	public String getCuentaClientesHasta() {
		return this.cuentaClientesHasta;
	}
		
	// SET  Cuenta clientes hasta
	public void setCuentaClientesHasta(String cuentaClientesHasta ){		
		this.cuentaClientesHasta = (cuentaClientesHasta == null || cuentaClientesHasta.trim().length() == 0) ? null : cuentaClientesHasta.trim();
	}	
	
	// GET Cantidad caracteres clientes from
	public Integer getCantidadCaracteresClientesFrom() {
		return this.cantidadCaracteresClientesFrom;
	}
		
	// SET  Cantidad caracteres clientes from
	public void setCantidadCaracteresClientesFrom(Integer cantidadCaracteresClientesFrom ){
		this.cantidadCaracteresClientesFrom = cantidadCaracteresClientesFrom;
	}	
	
	// GET Cantidad caracteres clientes to
	public Integer getCantidadCaracteresClientesTo() {
		return this.cantidadCaracteresClientesTo;
	}
		
	// SET  Cantidad caracteres clientes to
	public void setCantidadCaracteresClientesTo(Integer cantidadCaracteresClientesTo ){
		this.cantidadCaracteresClientesTo = cantidadCaracteresClientesTo;
	}	
	
	// GET Identificacion numérica clientes
	public Boolean getIdentificacionNumericaClientes() {
		return this.identificacionNumericaClientes;
	}
		
	// SET  Identificacion numérica clientes
	public void setIdentificacionNumericaClientes(Boolean identificacionNumericaClientes ){		
		this.identificacionNumericaClientes = identificacionNumericaClientes;
	}
	
	// GET Permite cambiar clientes
	public Boolean getPermiteCambiarClientes() {
		return this.permiteCambiarClientes;
	}
		
	// SET  Permite cambiar clientes
	public void setPermiteCambiarClientes(Boolean permiteCambiarClientes ){		
		this.permiteCambiarClientes = permiteCambiarClientes;
	}
	
	// GET Cuenta proveedores desde
	public String getCuentaProveedoresDesde() {
		return this.cuentaProveedoresDesde;
	}
		
	// SET  Cuenta proveedores desde
	public void setCuentaProveedoresDesde(String cuentaProveedoresDesde ){		
		this.cuentaProveedoresDesde = (cuentaProveedoresDesde == null || cuentaProveedoresDesde.trim().length() == 0) ? null : cuentaProveedoresDesde.trim();
	}	
	
	// GET Cuenta proveedores hasta
	public String getCuentaProveedoresHasta() {
		return this.cuentaProveedoresHasta;
	}
		
	// SET  Cuenta proveedores hasta
	public void setCuentaProveedoresHasta(String cuentaProveedoresHasta ){		
		this.cuentaProveedoresHasta = (cuentaProveedoresHasta == null || cuentaProveedoresHasta.trim().length() == 0) ? null : cuentaProveedoresHasta.trim();
	}	
	
	// GET Cantidad caracteres proveedores from
	public Integer getCantidadCaracteresProveedoresFrom() {
		return this.cantidadCaracteresProveedoresFrom;
	}
		
	// SET  Cantidad caracteres proveedores from
	public void setCantidadCaracteresProveedoresFrom(Integer cantidadCaracteresProveedoresFrom ){
		this.cantidadCaracteresProveedoresFrom = cantidadCaracteresProveedoresFrom;
	}	
	
	// GET Cantidad caracteres proveedores to
	public Integer getCantidadCaracteresProveedoresTo() {
		return this.cantidadCaracteresProveedoresTo;
	}
		
	// SET  Cantidad caracteres proveedores to
	public void setCantidadCaracteresProveedoresTo(Integer cantidadCaracteresProveedoresTo ){
		this.cantidadCaracteresProveedoresTo = cantidadCaracteresProveedoresTo;
	}	
	
	// GET Identificacion numérica proveedores
	public Boolean getIdentificacionNumericaProveedores() {
		return this.identificacionNumericaProveedores;
	}
		
	// SET  Identificacion numérica proveedores
	public void setIdentificacionNumericaProveedores(Boolean identificacionNumericaProveedores ){		
		this.identificacionNumericaProveedores = identificacionNumericaProveedores;
	}
	
	// GET Permite cambiar proveedores
	public Boolean getPermiteCambiarProveedores() {
		return this.permiteCambiarProveedores;
	}
		
	// SET  Permite cambiar proveedores
	public void setPermiteCambiarProveedores(Boolean permiteCambiarProveedores ){		
		this.permiteCambiarProveedores = permiteCambiarProveedores;
	}
	
	// GET Clientes ocacionales desde from
	public Integer getClientesOcacionalesDesdeFrom() {
		return this.clientesOcacionalesDesdeFrom;
	}
		
	// SET  Clientes ocacionales desde from
	public void setClientesOcacionalesDesdeFrom(Integer clientesOcacionalesDesdeFrom ){
		this.clientesOcacionalesDesdeFrom = clientesOcacionalesDesdeFrom;
	}	
	
	// GET Clientes ocacionales desde to
	public Integer getClientesOcacionalesDesdeTo() {
		return this.clientesOcacionalesDesdeTo;
	}
		
	// SET  Clientes ocacionales desde to
	public void setClientesOcacionalesDesdeTo(Integer clientesOcacionalesDesdeTo ){
		this.clientesOcacionalesDesdeTo = clientesOcacionalesDesdeTo;
	}	
	
	// GET Clientes ocacionales hasta from
	public Integer getClientesOcacionalesHastaFrom() {
		return this.clientesOcacionalesHastaFrom;
	}
		
	// SET  Clientes ocacionales hasta from
	public void setClientesOcacionalesHastaFrom(Integer clientesOcacionalesHastaFrom ){
		this.clientesOcacionalesHastaFrom = clientesOcacionalesHastaFrom;
	}	
	
	// GET Clientes ocacionales hasta to
	public Integer getClientesOcacionalesHastaTo() {
		return this.clientesOcacionalesHastaTo;
	}
		
	// SET  Clientes ocacionales hasta to
	public void setClientesOcacionalesHastaTo(Integer clientesOcacionalesHastaTo ){
		this.clientesOcacionalesHastaTo = clientesOcacionalesHastaTo;
	}	
	
	// GET Número cobranza desde from
	public Integer getNumeroCobranzaDesdeFrom() {
		return this.numeroCobranzaDesdeFrom;
	}
		
	// SET  Número cobranza desde from
	public void setNumeroCobranzaDesdeFrom(Integer numeroCobranzaDesdeFrom ){
		this.numeroCobranzaDesdeFrom = numeroCobranzaDesdeFrom;
	}	
	
	// GET Número cobranza desde to
	public Integer getNumeroCobranzaDesdeTo() {
		return this.numeroCobranzaDesdeTo;
	}
		
	// SET  Número cobranza desde to
	public void setNumeroCobranzaDesdeTo(Integer numeroCobranzaDesdeTo ){
		this.numeroCobranzaDesdeTo = numeroCobranzaDesdeTo;
	}	
	
	// GET Número cobranza hasta from
	public Integer getNumeroCobranzaHastaFrom() {
		return this.numeroCobranzaHastaFrom;
	}
		
	// SET  Número cobranza hasta from
	public void setNumeroCobranzaHastaFrom(Integer numeroCobranzaHastaFrom ){
		this.numeroCobranzaHastaFrom = numeroCobranzaHastaFrom;
	}	
	
	// GET Número cobranza hasta to
	public Integer getNumeroCobranzaHastaTo() {
		return this.numeroCobranzaHastaTo;
	}
		
	// SET  Número cobranza hasta to
	public void setNumeroCobranzaHastaTo(Integer numeroCobranzaHastaTo ){
		this.numeroCobranzaHastaTo = numeroCobranzaHastaTo;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		SucursalFilterQ1 other = (SucursalFilterQ1) obj;
		

		// -------------------------------------------------------------------

		if (other.getNumeroFrom() == null && this.getNumeroFrom() != null) {
			return false;
		}

		if (other.getNumeroFrom() != null && this.getNumeroFrom() == null) {
			return false;
		}

		if (other.getNumeroFrom() != null && this.getNumeroFrom() != null) {

			if (other.getNumeroFrom().equals(this.getNumeroFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getNumeroTo() == null && this.getNumeroTo() != null) {
			return false;
		}

		if (other.getNumeroTo() != null && this.getNumeroTo() == null) {
			return false;
		}

		if (other.getNumeroTo() != null && this.getNumeroTo() != null) {

			if (other.getNumeroTo().equals(this.getNumeroTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getNombre() == null && this.getNombre() != null) {
			return false;
		}

		if (other.getNombre() != null && this.getNombre() == null) {
			return false;
		}

		if (other.getNombre() != null && this.getNombre() != null) {

			if (other.getNombre().equals(this.getNombre()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getAbreviatura() == null && this.getAbreviatura() != null) {
			return false;
		}

		if (other.getAbreviatura() != null && this.getAbreviatura() == null) {
			return false;
		}

		if (other.getAbreviatura() != null && this.getAbreviatura() != null) {

			if (other.getAbreviatura().equals(this.getAbreviatura()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getTipoSucursal() == null && this.getTipoSucursal() != null) {
			return false;
		}

		if (other.getTipoSucursal() != null && this.getTipoSucursal() == null) {
			return false;
		}

		if (other.getTipoSucursal() != null && this.getTipoSucursal() != null) {

			if (other.getTipoSucursal().equals(this.getTipoSucursal()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaClientesDesde() == null && this.getCuentaClientesDesde() != null) {
			return false;
		}

		if (other.getCuentaClientesDesde() != null && this.getCuentaClientesDesde() == null) {
			return false;
		}

		if (other.getCuentaClientesDesde() != null && this.getCuentaClientesDesde() != null) {

			if (other.getCuentaClientesDesde().equals(this.getCuentaClientesDesde()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaClientesHasta() == null && this.getCuentaClientesHasta() != null) {
			return false;
		}

		if (other.getCuentaClientesHasta() != null && this.getCuentaClientesHasta() == null) {
			return false;
		}

		if (other.getCuentaClientesHasta() != null && this.getCuentaClientesHasta() != null) {

			if (other.getCuentaClientesHasta().equals(this.getCuentaClientesHasta()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCantidadCaracteresClientesFrom() == null && this.getCantidadCaracteresClientesFrom() != null) {
			return false;
		}

		if (other.getCantidadCaracteresClientesFrom() != null && this.getCantidadCaracteresClientesFrom() == null) {
			return false;
		}

		if (other.getCantidadCaracteresClientesFrom() != null && this.getCantidadCaracteresClientesFrom() != null) {

			if (other.getCantidadCaracteresClientesFrom().equals(this.getCantidadCaracteresClientesFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCantidadCaracteresClientesTo() == null && this.getCantidadCaracteresClientesTo() != null) {
			return false;
		}

		if (other.getCantidadCaracteresClientesTo() != null && this.getCantidadCaracteresClientesTo() == null) {
			return false;
		}

		if (other.getCantidadCaracteresClientesTo() != null && this.getCantidadCaracteresClientesTo() != null) {

			if (other.getCantidadCaracteresClientesTo().equals(this.getCantidadCaracteresClientesTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getIdentificacionNumericaClientes() == null && this.getIdentificacionNumericaClientes() != null) {
			return false;
		}

		if (other.getIdentificacionNumericaClientes() != null && this.getIdentificacionNumericaClientes() == null) {
			return false;
		}

		if (other.getIdentificacionNumericaClientes() != null && this.getIdentificacionNumericaClientes() != null) {

			if (other.getIdentificacionNumericaClientes().equals(this.getIdentificacionNumericaClientes()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getPermiteCambiarClientes() == null && this.getPermiteCambiarClientes() != null) {
			return false;
		}

		if (other.getPermiteCambiarClientes() != null && this.getPermiteCambiarClientes() == null) {
			return false;
		}

		if (other.getPermiteCambiarClientes() != null && this.getPermiteCambiarClientes() != null) {

			if (other.getPermiteCambiarClientes().equals(this.getPermiteCambiarClientes()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaProveedoresDesde() == null && this.getCuentaProveedoresDesde() != null) {
			return false;
		}

		if (other.getCuentaProveedoresDesde() != null && this.getCuentaProveedoresDesde() == null) {
			return false;
		}

		if (other.getCuentaProveedoresDesde() != null && this.getCuentaProveedoresDesde() != null) {

			if (other.getCuentaProveedoresDesde().equals(this.getCuentaProveedoresDesde()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaProveedoresHasta() == null && this.getCuentaProveedoresHasta() != null) {
			return false;
		}

		if (other.getCuentaProveedoresHasta() != null && this.getCuentaProveedoresHasta() == null) {
			return false;
		}

		if (other.getCuentaProveedoresHasta() != null && this.getCuentaProveedoresHasta() != null) {

			if (other.getCuentaProveedoresHasta().equals(this.getCuentaProveedoresHasta()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCantidadCaracteresProveedoresFrom() == null && this.getCantidadCaracteresProveedoresFrom() != null) {
			return false;
		}

		if (other.getCantidadCaracteresProveedoresFrom() != null && this.getCantidadCaracteresProveedoresFrom() == null) {
			return false;
		}

		if (other.getCantidadCaracteresProveedoresFrom() != null && this.getCantidadCaracteresProveedoresFrom() != null) {

			if (other.getCantidadCaracteresProveedoresFrom().equals(this.getCantidadCaracteresProveedoresFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCantidadCaracteresProveedoresTo() == null && this.getCantidadCaracteresProveedoresTo() != null) {
			return false;
		}

		if (other.getCantidadCaracteresProveedoresTo() != null && this.getCantidadCaracteresProveedoresTo() == null) {
			return false;
		}

		if (other.getCantidadCaracteresProveedoresTo() != null && this.getCantidadCaracteresProveedoresTo() != null) {

			if (other.getCantidadCaracteresProveedoresTo().equals(this.getCantidadCaracteresProveedoresTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getIdentificacionNumericaProveedores() == null && this.getIdentificacionNumericaProveedores() != null) {
			return false;
		}

		if (other.getIdentificacionNumericaProveedores() != null && this.getIdentificacionNumericaProveedores() == null) {
			return false;
		}

		if (other.getIdentificacionNumericaProveedores() != null && this.getIdentificacionNumericaProveedores() != null) {

			if (other.getIdentificacionNumericaProveedores().equals(this.getIdentificacionNumericaProveedores()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getPermiteCambiarProveedores() == null && this.getPermiteCambiarProveedores() != null) {
			return false;
		}

		if (other.getPermiteCambiarProveedores() != null && this.getPermiteCambiarProveedores() == null) {
			return false;
		}

		if (other.getPermiteCambiarProveedores() != null && this.getPermiteCambiarProveedores() != null) {

			if (other.getPermiteCambiarProveedores().equals(this.getPermiteCambiarProveedores()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getClientesOcacionalesDesdeFrom() == null && this.getClientesOcacionalesDesdeFrom() != null) {
			return false;
		}

		if (other.getClientesOcacionalesDesdeFrom() != null && this.getClientesOcacionalesDesdeFrom() == null) {
			return false;
		}

		if (other.getClientesOcacionalesDesdeFrom() != null && this.getClientesOcacionalesDesdeFrom() != null) {

			if (other.getClientesOcacionalesDesdeFrom().equals(this.getClientesOcacionalesDesdeFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getClientesOcacionalesDesdeTo() == null && this.getClientesOcacionalesDesdeTo() != null) {
			return false;
		}

		if (other.getClientesOcacionalesDesdeTo() != null && this.getClientesOcacionalesDesdeTo() == null) {
			return false;
		}

		if (other.getClientesOcacionalesDesdeTo() != null && this.getClientesOcacionalesDesdeTo() != null) {

			if (other.getClientesOcacionalesDesdeTo().equals(this.getClientesOcacionalesDesdeTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getClientesOcacionalesHastaFrom() == null && this.getClientesOcacionalesHastaFrom() != null) {
			return false;
		}

		if (other.getClientesOcacionalesHastaFrom() != null && this.getClientesOcacionalesHastaFrom() == null) {
			return false;
		}

		if (other.getClientesOcacionalesHastaFrom() != null && this.getClientesOcacionalesHastaFrom() != null) {

			if (other.getClientesOcacionalesHastaFrom().equals(this.getClientesOcacionalesHastaFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getClientesOcacionalesHastaTo() == null && this.getClientesOcacionalesHastaTo() != null) {
			return false;
		}

		if (other.getClientesOcacionalesHastaTo() != null && this.getClientesOcacionalesHastaTo() == null) {
			return false;
		}

		if (other.getClientesOcacionalesHastaTo() != null && this.getClientesOcacionalesHastaTo() != null) {

			if (other.getClientesOcacionalesHastaTo().equals(this.getClientesOcacionalesHastaTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getNumeroCobranzaDesdeFrom() == null && this.getNumeroCobranzaDesdeFrom() != null) {
			return false;
		}

		if (other.getNumeroCobranzaDesdeFrom() != null && this.getNumeroCobranzaDesdeFrom() == null) {
			return false;
		}

		if (other.getNumeroCobranzaDesdeFrom() != null && this.getNumeroCobranzaDesdeFrom() != null) {

			if (other.getNumeroCobranzaDesdeFrom().equals(this.getNumeroCobranzaDesdeFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getNumeroCobranzaDesdeTo() == null && this.getNumeroCobranzaDesdeTo() != null) {
			return false;
		}

		if (other.getNumeroCobranzaDesdeTo() != null && this.getNumeroCobranzaDesdeTo() == null) {
			return false;
		}

		if (other.getNumeroCobranzaDesdeTo() != null && this.getNumeroCobranzaDesdeTo() != null) {

			if (other.getNumeroCobranzaDesdeTo().equals(this.getNumeroCobranzaDesdeTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getNumeroCobranzaHastaFrom() == null && this.getNumeroCobranzaHastaFrom() != null) {
			return false;
		}

		if (other.getNumeroCobranzaHastaFrom() != null && this.getNumeroCobranzaHastaFrom() == null) {
			return false;
		}

		if (other.getNumeroCobranzaHastaFrom() != null && this.getNumeroCobranzaHastaFrom() != null) {

			if (other.getNumeroCobranzaHastaFrom().equals(this.getNumeroCobranzaHastaFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getNumeroCobranzaHastaTo() == null && this.getNumeroCobranzaHastaTo() != null) {
			return false;
		}

		if (other.getNumeroCobranzaHastaTo() != null && this.getNumeroCobranzaHastaTo() == null) {
			return false;
		}

		if (other.getNumeroCobranzaHastaTo() != null && this.getNumeroCobranzaHastaTo() != null) {

			if (other.getNumeroCobranzaHastaTo().equals(this.getNumeroCobranzaHastaTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public SucursalFilterQ1 clone() {

		SucursalFilterQ1 other = new SucursalFilterQ1();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setNombre(this.getNombre());			
		other.setAbreviatura(this.getAbreviatura());			
		if(this.getTipoSucursal() != null) {
			other.setTipoSucursal(this.getTipoSucursal().clone());
		}				
		other.setCuentaClientesDesde(this.getCuentaClientesDesde());			
		other.setCuentaClientesHasta(this.getCuentaClientesHasta());			
		other.setCantidadCaracteresClientesFrom(this.getCantidadCaracteresClientesFrom());			
		other.setCantidadCaracteresClientesTo(this.getCantidadCaracteresClientesTo());			
		other.setIdentificacionNumericaClientes(this.getIdentificacionNumericaClientes());			
		other.setPermiteCambiarClientes(this.getPermiteCambiarClientes());			
		other.setCuentaProveedoresDesde(this.getCuentaProveedoresDesde());			
		other.setCuentaProveedoresHasta(this.getCuentaProveedoresHasta());			
		other.setCantidadCaracteresProveedoresFrom(this.getCantidadCaracteresProveedoresFrom());			
		other.setCantidadCaracteresProveedoresTo(this.getCantidadCaracteresProveedoresTo());			
		other.setIdentificacionNumericaProveedores(this.getIdentificacionNumericaProveedores());			
		other.setPermiteCambiarProveedores(this.getPermiteCambiarProveedores());			
		other.setClientesOcacionalesDesdeFrom(this.getClientesOcacionalesDesdeFrom());			
		other.setClientesOcacionalesDesdeTo(this.getClientesOcacionalesDesdeTo());			
		other.setClientesOcacionalesHastaFrom(this.getClientesOcacionalesHastaFrom());			
		other.setClientesOcacionalesHastaTo(this.getClientesOcacionalesHastaTo());			
		other.setNumeroCobranzaDesdeFrom(this.getNumeroCobranzaDesdeFrom());			
		other.setNumeroCobranzaDesdeTo(this.getNumeroCobranzaDesdeTo());			
		other.setNumeroCobranzaHastaFrom(this.getNumeroCobranzaHastaFrom());			
		other.setNumeroCobranzaHastaTo(this.getNumeroCobranzaHastaTo());			

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------