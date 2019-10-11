package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;

import com.massoftware.a.model.TipoSucursal;

public class Sucursal extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Nº sucursal
	private Integer numero;		
	
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
	
	// GET Cantidad caracteres clientes
	private Integer cantidadCaracteresClientes;		
	
	// GET Identificacion numérica clientes
	private Boolean identificacionNumericaClientes;		
	
	// GET Permite cambiar clientes
	private Boolean permiteCambiarClientes;		
	
	// GET Cuenta proveedores desde
	private String cuentaProveedoresDesde;		
	
	// GET Cuenta proveedores hasta
	private String cuentaProveedoresHasta;		
	
	// GET Cantidad caracteres proveedores
	private Integer cantidadCaracteresProveedores;		
	
	// GET Identificacion numérica proveedores
	private Boolean identificacionNumericaProveedores;		
	
	// GET Permite cambiar proveedores
	private Boolean permiteCambiarProveedores;		
	
	// GET Clientes ocacionales desde
	private Integer clientesOcacionalesDesde;		
	
	// GET Clientes ocacionales hasta
	private Integer clientesOcacionalesHasta;		
	
	// GET Número cobranza desde
	private Integer numeroCobranzaDesde;		
	
	// GET Número cobranza hasta
	private Integer numeroCobranzaHasta;		
	
	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}	
	
	
	// GET Nº sucursal
	public Integer getNumero() {
		return this.numero;
	}
		
	// SET  Nº sucursal
	public void setNumero(Integer numero ){
		this.numero = numero;
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
	
	// GET Cantidad caracteres clientes
	public Integer getCantidadCaracteresClientes() {
		return this.cantidadCaracteresClientes;
	}
		
	// SET  Cantidad caracteres clientes
	public void setCantidadCaracteresClientes(Integer cantidadCaracteresClientes ){
		this.cantidadCaracteresClientes = cantidadCaracteresClientes;
	}	
	
	// GET Identificacion numérica clientes
	public Boolean getIdentificacionNumericaClientes() {
		return this.identificacionNumericaClientes;
	}
		
	// SET  Identificacion numérica clientes
	public void setIdentificacionNumericaClientes(Boolean identificacionNumericaClientes ){		
		this.identificacionNumericaClientes = (identificacionNumericaClientes == null) ? false : identificacionNumericaClientes;
	}
	
	// GET Permite cambiar clientes
	public Boolean getPermiteCambiarClientes() {
		return this.permiteCambiarClientes;
	}
		
	// SET  Permite cambiar clientes
	public void setPermiteCambiarClientes(Boolean permiteCambiarClientes ){		
		this.permiteCambiarClientes = (permiteCambiarClientes == null) ? false : permiteCambiarClientes;
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
	
	// GET Cantidad caracteres proveedores
	public Integer getCantidadCaracteresProveedores() {
		return this.cantidadCaracteresProveedores;
	}
		
	// SET  Cantidad caracteres proveedores
	public void setCantidadCaracteresProveedores(Integer cantidadCaracteresProveedores ){
		this.cantidadCaracteresProveedores = cantidadCaracteresProveedores;
	}	
	
	// GET Identificacion numérica proveedores
	public Boolean getIdentificacionNumericaProveedores() {
		return this.identificacionNumericaProveedores;
	}
		
	// SET  Identificacion numérica proveedores
	public void setIdentificacionNumericaProveedores(Boolean identificacionNumericaProveedores ){		
		this.identificacionNumericaProveedores = (identificacionNumericaProveedores == null) ? false : identificacionNumericaProveedores;
	}
	
	// GET Permite cambiar proveedores
	public Boolean getPermiteCambiarProveedores() {
		return this.permiteCambiarProveedores;
	}
		
	// SET  Permite cambiar proveedores
	public void setPermiteCambiarProveedores(Boolean permiteCambiarProveedores ){		
		this.permiteCambiarProveedores = (permiteCambiarProveedores == null) ? false : permiteCambiarProveedores;
	}
	
	// GET Clientes ocacionales desde
	public Integer getClientesOcacionalesDesde() {
		return this.clientesOcacionalesDesde;
	}
		
	// SET  Clientes ocacionales desde
	public void setClientesOcacionalesDesde(Integer clientesOcacionalesDesde ){
		this.clientesOcacionalesDesde = clientesOcacionalesDesde;
	}	
	
	// GET Clientes ocacionales hasta
	public Integer getClientesOcacionalesHasta() {
		return this.clientesOcacionalesHasta;
	}
		
	// SET  Clientes ocacionales hasta
	public void setClientesOcacionalesHasta(Integer clientesOcacionalesHasta ){
		this.clientesOcacionalesHasta = clientesOcacionalesHasta;
	}	
	
	// GET Número cobranza desde
	public Integer getNumeroCobranzaDesde() {
		return this.numeroCobranzaDesde;
	}
		
	// SET  Número cobranza desde
	public void setNumeroCobranzaDesde(Integer numeroCobranzaDesde ){
		this.numeroCobranzaDesde = numeroCobranzaDesde;
	}	
	
	// GET Número cobranza hasta
	public Integer getNumeroCobranzaHasta() {
		return this.numeroCobranzaHasta;
	}
		
	// SET  Número cobranza hasta
	public void setNumeroCobranzaHasta(Integer numeroCobranzaHasta ){
		this.numeroCobranzaHasta = numeroCobranzaHasta;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getNombre() != null){
			return this.getNumero() + " - " +  this.getNombre();
		} else if(this.getNumero() != null && this.getNombre() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getNombre() != null){
			return this.getNombre().toString();
		} else {
			return super.toString();
		}
	}
		
	public Sucursal clone() {
		
		Sucursal other = new Sucursal();
		
		other.setId(this.getId());
		
		other.setNumero(this.getNumero());			
		other.setNombre(this.getNombre());			
		other.setAbreviatura(this.getAbreviatura());			
		if(this.getTipoSucursal() != null) {
			other.setTipoSucursal(this.getTipoSucursal().clone());
		}				
		other.setCuentaClientesDesde(this.getCuentaClientesDesde());			
		other.setCuentaClientesHasta(this.getCuentaClientesHasta());			
		other.setCantidadCaracteresClientes(this.getCantidadCaracteresClientes());			
		other.setIdentificacionNumericaClientes(this.getIdentificacionNumericaClientes());			
		other.setPermiteCambiarClientes(this.getPermiteCambiarClientes());			
		other.setCuentaProveedoresDesde(this.getCuentaProveedoresDesde());			
		other.setCuentaProveedoresHasta(this.getCuentaProveedoresHasta());			
		other.setCantidadCaracteresProveedores(this.getCantidadCaracteresProveedores());			
		other.setIdentificacionNumericaProveedores(this.getIdentificacionNumericaProveedores());			
		other.setPermiteCambiarProveedores(this.getPermiteCambiarProveedores());			
		other.setClientesOcacionalesDesde(this.getClientesOcacionalesDesde());			
		other.setClientesOcacionalesHasta(this.getClientesOcacionalesHasta());			
		other.setNumeroCobranzaDesde(this.getNumeroCobranzaDesde());			
		other.setNumeroCobranzaHasta(this.getNumeroCobranzaHasta());			
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------