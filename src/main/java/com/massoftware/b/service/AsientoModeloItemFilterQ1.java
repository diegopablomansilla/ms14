package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.AsientoModelo;
import com.massoftware.a.model.CuentaContable;

public class AsientoModeloItemFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº item from
	private Integer numeroFrom;		
	
	// GET Nº item to
	private Integer numeroTo;		
	
	// GET Asiento modelo
	private AsientoModelo asientoModelo;		
	
	// GET Cuenta contable
	private CuentaContable cuentaContable;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº item from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº item from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº item to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº item to
	public void setNumeroTo(Integer numeroTo ){
		this.numeroTo = numeroTo;
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

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		AsientoModeloItemFilterQ1 other = (AsientoModeloItemFilterQ1) obj;
		

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

		if (other.getAsientoModelo() == null && this.getAsientoModelo() != null) {
			return false;
		}

		if (other.getAsientoModelo() != null && this.getAsientoModelo() == null) {
			return false;
		}

		if (other.getAsientoModelo() != null && this.getAsientoModelo() != null) {

			if (other.getAsientoModelo().equals(this.getAsientoModelo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaContable() == null && this.getCuentaContable() != null) {
			return false;
		}

		if (other.getCuentaContable() != null && this.getCuentaContable() == null) {
			return false;
		}

		if (other.getCuentaContable() != null && this.getCuentaContable() != null) {

			if (other.getCuentaContable().equals(this.getCuentaContable()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public AsientoModeloItemFilterQ1 clone() {

		AsientoModeloItemFilterQ1 other = new AsientoModeloItemFilterQ1();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
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