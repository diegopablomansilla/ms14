package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;

import com.massoftware.a.model.AsientoModelo;
import com.massoftware.a.model.CuentaContable;

public class AsientoModeloItem extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Nº item
	private Integer numero;		
	
	// GET Asiento modelo
	private AsientoModelo asientoModelo;		
	
	// GET Cuenta contable
	private CuentaContable cuentaContable;		
	
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
	
	// GET Asiento modelo
	public AsientoModelo getAsientoModelo() {
		return this.asientoModelo;
	}
		
	// SET  Asiento modelo
	public void setAsientoModelo(AsientoModelo asientoModelo ){
		this.asientoModelo = asientoModelo;
	}	
	
	// GET Cuenta contable
	public CuentaContable getCuentaContable() {
		return this.cuentaContable;
	}
		
	// SET  Cuenta contable
	public void setCuentaContable(CuentaContable cuentaContable ){
		this.cuentaContable = cuentaContable;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		if(this.getAsientoModelo() != null && this.getNumero() != null){
			return this.getAsientoModelo() + " - " +  this.getNumero();
		} else if(this.getAsientoModelo() != null && this.getNumero() == null){
			return this.getAsientoModelo().toString();
		} else if(this.getAsientoModelo() == null && this.getNumero() != null){
			return this.getNumero().toString();
		} else {
			return super.toString();
		}
	}
		
	public AsientoModeloItem clone() {
		
		AsientoModeloItem other = new AsientoModeloItem();
		
		other.setId(this.getId());
		
		other.setNumero(this.getNumero());			
		if(this.getAsientoModelo() != null) {
			other.setAsientoModelo(this.getAsientoModelo().clone());
		}				
		if(this.getCuentaContable() != null) {
			other.setCuentaContable(this.getCuentaContable().clone());
		}				
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------