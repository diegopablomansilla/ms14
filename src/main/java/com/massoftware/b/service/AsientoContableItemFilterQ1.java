package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import java.time.LocalDate;
import com.massoftware.a.model.AsientoContable;
import com.massoftware.a.model.CuentaContable;
import java.math.BigDecimal;

public class AsientoContableItemFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº item from
	private Integer numeroFrom;		
	
	// GET Nº item to
	private Integer numeroTo;		
	
	// GET Fecha from
	private LocalDate fechaFrom;		
	
	// GET Fecha to
	private LocalDate fechaTo;		
	
	// GET Detalle
	private String detalle;		
	
	// GET Asiento contable
	private AsientoContable asientoContable;		
	
	// GET Cuenta contable
	private CuentaContable cuentaContable;		
	
	// GET Debe from
	private BigDecimal debeFrom;		
	
	// GET Debe to
	private BigDecimal debeTo;		
	
	// GET Haber from
	private BigDecimal haberFrom;		
	
	// GET Haber to
	private BigDecimal haberTo;		

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
	
	// GET Fecha from
	public LocalDate getFechaFrom() {
		return this.fechaFrom;
	}
		
	// SET  Fecha from
	public void setFechaFrom(LocalDate fechaFrom ){
		this.fechaFrom = fechaFrom;
	}	
	
	// GET Fecha to
	public LocalDate getFechaTo() {
		return this.fechaTo;
	}
		
	// SET  Fecha to
	public void setFechaTo(LocalDate fechaTo ){
		this.fechaTo = fechaTo;
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
	
	// GET Debe from
	public BigDecimal getDebeFrom() {
		return this.debeFrom;
	}
	
	// SET  Debe from
	public void setDebeFrom(BigDecimal debeFrom ){
		this.debeFrom = debeFrom;
	}
	
	// GET Debe to
	public BigDecimal getDebeTo() {
		return this.debeTo;
	}
	
	// SET  Debe to
	public void setDebeTo(BigDecimal debeTo ){
		this.debeTo = debeTo;
	}
	
	// GET Haber from
	public BigDecimal getHaberFrom() {
		return this.haberFrom;
	}
	
	// SET  Haber from
	public void setHaberFrom(BigDecimal haberFrom ){
		this.haberFrom = haberFrom;
	}
	
	// GET Haber to
	public BigDecimal getHaberTo() {
		return this.haberTo;
	}
	
	// SET  Haber to
	public void setHaberTo(BigDecimal haberTo ){
		this.haberTo = haberTo;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		AsientoContableItemFilterQ1 other = (AsientoContableItemFilterQ1) obj;
		

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

		if (other.getFechaFrom() == null && this.getFechaFrom() != null) {
			return false;
		}

		if (other.getFechaFrom() != null && this.getFechaFrom() == null) {
			return false;
		}

		if (other.getFechaFrom() != null && this.getFechaFrom() != null) {

			if (other.getFechaFrom().equals(this.getFechaFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaTo() == null && this.getFechaTo() != null) {
			return false;
		}

		if (other.getFechaTo() != null && this.getFechaTo() == null) {
			return false;
		}

		if (other.getFechaTo() != null && this.getFechaTo() != null) {

			if (other.getFechaTo().equals(this.getFechaTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getDetalle() == null && this.getDetalle() != null) {
			return false;
		}

		if (other.getDetalle() != null && this.getDetalle() == null) {
			return false;
		}

		if (other.getDetalle() != null && this.getDetalle() != null) {

			if (other.getDetalle().equals(this.getDetalle()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getAsientoContable() == null && this.getAsientoContable() != null) {
			return false;
		}

		if (other.getAsientoContable() != null && this.getAsientoContable() == null) {
			return false;
		}

		if (other.getAsientoContable() != null && this.getAsientoContable() != null) {

			if (other.getAsientoContable().equals(this.getAsientoContable()) == false) {
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

		if (other.getDebeFrom() == null && this.getDebeFrom() != null) {
			return false;
		}

		if (other.getDebeFrom() != null && this.getDebeFrom() == null) {
			return false;
		}

		if (other.getDebeFrom() != null && this.getDebeFrom() != null) {

			if (other.getDebeFrom().equals(this.getDebeFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getDebeTo() == null && this.getDebeTo() != null) {
			return false;
		}

		if (other.getDebeTo() != null && this.getDebeTo() == null) {
			return false;
		}

		if (other.getDebeTo() != null && this.getDebeTo() != null) {

			if (other.getDebeTo().equals(this.getDebeTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getHaberFrom() == null && this.getHaberFrom() != null) {
			return false;
		}

		if (other.getHaberFrom() != null && this.getHaberFrom() == null) {
			return false;
		}

		if (other.getHaberFrom() != null && this.getHaberFrom() != null) {

			if (other.getHaberFrom().equals(this.getHaberFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getHaberTo() == null && this.getHaberTo() != null) {
			return false;
		}

		if (other.getHaberTo() != null && this.getHaberTo() == null) {
			return false;
		}

		if (other.getHaberTo() != null && this.getHaberTo() != null) {

			if (other.getHaberTo().equals(this.getHaberTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public AsientoContableItemFilterQ1 clone() {

		AsientoContableItemFilterQ1 other = new AsientoContableItemFilterQ1();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setFechaFrom(this.getFechaFrom());			
		other.setFechaTo(this.getFechaTo());			
		other.setDetalle(this.getDetalle());			
		if(this.getAsientoContable() != null) {
			other.setAsientoContable(this.getAsientoContable().clone());
		}				
		if(this.getCuentaContable() != null) {
			other.setCuentaContable(this.getCuentaContable().clone());
		}				
		other.setDebeFrom(this.getDebeFrom());			
		other.setDebeTo(this.getDebeTo());			
		other.setHaberFrom(this.getHaberFrom());			
		other.setHaberTo(this.getHaberTo());			

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------