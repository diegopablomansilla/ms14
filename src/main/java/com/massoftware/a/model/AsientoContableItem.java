package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;

import java.time.LocalDate;
import com.massoftware.a.model.AsientoContable;
import com.massoftware.a.model.CuentaContable;
import java.math.BigDecimal;

public class AsientoContableItem extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Nº item
	private Integer numero;		
	
	// GET Fecha
	private LocalDate fecha;		
	
	// GET Detalle
	private String detalle;		
	
	// GET Asiento contable
	private AsientoContable asientoContable;		
	
	// GET Cuenta contable
	private CuentaContable cuentaContable;		
	
	// GET Debe
	private BigDecimal debe;		
	
	// GET Haber
	private BigDecimal haber;		
	
	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}	
	
	
	// GET Nº item
	public Integer getNumero() {
		return this.numero;
	}
		
	// SET  Nº item
	public void setNumero(Integer numero ){
		this.numero = numero;
	}	
	
	// GET Fecha
	public LocalDate getFecha() {
		return this.fecha;
	}
		
	// SET  Fecha
	public void setFecha(LocalDate fecha ){
		this.fecha = fecha;
	}	
	
	// GET Detalle
	public String getDetalle() {
		return this.detalle;
	}
		
	// SET  Detalle
	public void setDetalle(String detalle ){		
		this.detalle = (detalle == null || detalle.trim().length() == 0) ? null : detalle.trim();
	}	
	
	// GET Asiento contable
	public AsientoContable getAsientoContable() {
		return this.asientoContable;
	}
		
	// SET  Asiento contable
	public void setAsientoContable(AsientoContable asientoContable ){
		this.asientoContable = asientoContable;
	}	
	
	// GET Cuenta contable
	public CuentaContable getCuentaContable() {
		return this.cuentaContable;
	}
		
	// SET  Cuenta contable
	public void setCuentaContable(CuentaContable cuentaContable ){
		this.cuentaContable = cuentaContable;
	}	
	
	// GET Debe
	public BigDecimal getDebe() {
		return this.debe;
	}
	
	// SET  Debe
	public void setDebe(BigDecimal debe ){
		this.debe = debe;
	}
	
	// GET Haber
	public BigDecimal getHaber() {
		return this.haber;
	}
	
	// SET  Haber
	public void setHaber(BigDecimal haber ){
		this.haber = haber;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getNumero() != null && this.getDetalle() != null){
			return this.getNumero() + " - " +  this.getDetalle();
		} else if(this.getNumero() != null && this.getDetalle() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getDetalle() != null){
			return this.getDetalle().toString();
		} else {
			return super.toString();
		}
	}
		
	public AsientoContableItem clone() {
		
		AsientoContableItem other = new AsientoContableItem();
		
		other.setId(this.getId());
		
		other.setNumero(this.getNumero());			
		other.setFecha(this.getFecha());			
		other.setDetalle(this.getDetalle());			
		if(this.getAsientoContable() != null) {
			other.setAsientoContable(this.getAsientoContable().clone());
		}				
		if(this.getCuentaContable() != null) {
			other.setCuentaContable(this.getCuentaContable().clone());
		}				
		other.setDebe(this.getDebe());			
		other.setHaber(this.getHaber());			
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------