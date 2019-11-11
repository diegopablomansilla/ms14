package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.a.model.CostoVenta;
import com.massoftware.a.model.SeguridadPuerta;

public class CuentaContable extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Cuenta contable
	private String codigo;		
	
	// GET Nombre
	private String nombre;		
	
	// GET Ejercicio
	private EjercicioContable ejercicioContable;		
	
	// GET Integra
	private CuentaContable integra;		
	
	// GET Cuenta de jerarquia
	private String cuentaJerarquia;		
	
	// GET Imputable
	private Boolean imputable;		
	
	// GET Ajusta por inflación
	private Boolean ajustaPorInflacion;		
	
	// GET Estado
	private Boolean cuentaContableEstado;		
	
	// GET Cuenta con apropiación
	private Boolean cuentaConApropiacion;		
	
	// GET Centro costo contable
	private CentroCostoContable centroCostoContable;		
	
	// GET Cuenta agrupadora
	private String cuentaAgrupadora;		
	
	// GET Porcentaje
	private Double porcentaje;		
	
	// GET Punto de equilibrio
	private PuntoEquilibrio puntoEquilibrio;		
	
	// GET Costo de venta
	private CostoVenta costoVenta;		
	
	// GET Puerta
	private SeguridadPuerta seguridadPuerta;		
	
	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}	
	
	
	// GET Cuenta contable
	public String getCodigo() {
		return this.codigo;
	}
		
	// SET  Cuenta contable
	public void setCodigo(String codigo ){		
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}	
	
	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}
		
	// SET  Nombre
	public void setNombre(String nombre ){		
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}	
	
	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}
		
	// SET  Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}	
	
	// GET Integra
	public CuentaContable getIntegra() {
		return this.integra;
	}
		
	// SET  Integra
	public void setIntegra(CuentaContable integra ){
		this.integra = integra;
	}	
	
	// GET Cuenta de jerarquia
	public String getCuentaJerarquia() {
		return this.cuentaJerarquia;
	}
		
	// SET  Cuenta de jerarquia
	public void setCuentaJerarquia(String cuentaJerarquia ){		
		this.cuentaJerarquia = (cuentaJerarquia == null || cuentaJerarquia.trim().length() == 0) ? null : cuentaJerarquia.trim();
	}	
	
	// GET Imputable
	public Boolean getImputable() {
		return this.imputable;
	}
		
	// SET  Imputable
	public void setImputable(Boolean imputable ){		
		this.imputable = (imputable == null) ? false : imputable;
	}
	
	// GET Ajusta por inflación
	public Boolean getAjustaPorInflacion() {
		return this.ajustaPorInflacion;
	}
		
	// SET  Ajusta por inflación
	public void setAjustaPorInflacion(Boolean ajustaPorInflacion ){		
		this.ajustaPorInflacion = (ajustaPorInflacion == null) ? false : ajustaPorInflacion;
	}
	
	// GET Estado
	public Boolean getCuentaContableEstado() {
		return this.cuentaContableEstado;
	}
		
	// SET  Estado
	public void setCuentaContableEstado(Boolean cuentaContableEstado ){		
		this.cuentaContableEstado = (cuentaContableEstado == null) ? false : cuentaContableEstado;
	}
	
	// GET Cuenta con apropiación
	public Boolean getCuentaConApropiacion() {
		return this.cuentaConApropiacion;
	}
		
	// SET  Cuenta con apropiación
	public void setCuentaConApropiacion(Boolean cuentaConApropiacion ){		
		this.cuentaConApropiacion = (cuentaConApropiacion == null) ? false : cuentaConApropiacion;
	}
	
	// GET Centro costo contable
	public CentroCostoContable getCentroCostoContable() {
		return this.centroCostoContable;
	}
		
	// SET  Centro costo contable
	public void setCentroCostoContable(CentroCostoContable centroCostoContable ){
		this.centroCostoContable = centroCostoContable;
	}	
	
	// GET Cuenta agrupadora
	public String getCuentaAgrupadora() {
		return this.cuentaAgrupadora;
	}
		
	// SET  Cuenta agrupadora
	public void setCuentaAgrupadora(String cuentaAgrupadora ){		
		this.cuentaAgrupadora = (cuentaAgrupadora == null || cuentaAgrupadora.trim().length() == 0) ? null : cuentaAgrupadora.trim();
	}	
	
	// GET Porcentaje
	public Double getPorcentaje() {
		return this.porcentaje;
	}
		
	// SET  Porcentaje
	public void setPorcentaje(Double porcentaje ){
		this.porcentaje = porcentaje;
	}	
	
	// GET Punto de equilibrio
	public PuntoEquilibrio getPuntoEquilibrio() {
		return this.puntoEquilibrio;
	}
		
	// SET  Punto de equilibrio
	public void setPuntoEquilibrio(PuntoEquilibrio puntoEquilibrio ){
		this.puntoEquilibrio = puntoEquilibrio;
	}	
	
	// GET Costo de venta
	public CostoVenta getCostoVenta() {
		return this.costoVenta;
	}
		
	// SET  Costo de venta
	public void setCostoVenta(CostoVenta costoVenta ){
		this.costoVenta = costoVenta;
	}	
	
	// GET Puerta
	public SeguridadPuerta getSeguridadPuerta() {
		return this.seguridadPuerta;
	}
		
	// SET  Puerta
	public void setSeguridadPuerta(SeguridadPuerta seguridadPuerta ){
		this.seguridadPuerta = seguridadPuerta;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getCodigo() != null && this.getNombre() != null){
			return this.getCodigo() + " - " +  this.getNombre();
		} else if(this.getCodigo() != null && this.getNombre() == null){
			return this.getCodigo().toString();
		} else if(this.getCodigo() == null && this.getNombre() != null){
			return this.getNombre().toString();
		} else {
			return super.toString();
		}
	}
		
	public CuentaContable clone() {
		
		CuentaContable other = new CuentaContable();
		
		other.setId(this.getId());
		
		other.setCodigo(this.getCodigo());			
		other.setNombre(this.getNombre());			
		if(this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}				
		if(this.getIntegra() != null) {
			other.setIntegra(this.getIntegra().clone());
		}				
		other.setCuentaJerarquia(this.getCuentaJerarquia());			
		other.setImputable(this.getImputable());			
		other.setAjustaPorInflacion(this.getAjustaPorInflacion());			
		other.setCuentaContableEstado(this.getCuentaContableEstado());			
		other.setCuentaConApropiacion(this.getCuentaConApropiacion());			
		if(this.getCentroCostoContable() != null) {
			other.setCentroCostoContable(this.getCentroCostoContable().clone());
		}				
		other.setCuentaAgrupadora(this.getCuentaAgrupadora());			
		other.setPorcentaje(this.getPorcentaje());			
		if(this.getPuntoEquilibrio() != null) {
			other.setPuntoEquilibrio(this.getPuntoEquilibrio().clone());
		}				
		if(this.getCostoVenta() != null) {
			other.setCostoVenta(this.getCostoVenta().clone());
		}				
		if(this.getSeguridadPuerta() != null) {
			other.setSeguridadPuerta(this.getSeguridadPuerta().clone());
		}				
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------