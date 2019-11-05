package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import java.time.LocalDate;
import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.MinutaContable;
import com.massoftware.a.model.Sucursal;
import com.massoftware.a.model.AsientoContableModulo;

public class AsientoContableFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº asiento from
	private Integer numeroFrom;		
	
	// GET Nº asiento to
	private Integer numeroTo;		
	
	// GET Fecha from
	private LocalDate fechaFrom;		
	
	// GET Fecha to
	private LocalDate fechaTo;		
	
	// GET Detalle
	private String detalle;		
	
	// GET Ejercicio
	private EjercicioContable ejercicioContable;		
	
	// GET Minuta contable
	private MinutaContable minutaContable;		
	
	// GET Sucursal
	private Sucursal sucursal;		
	
	// GET Módulo
	private AsientoContableModulo asientoContableModulo;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº asiento from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº asiento from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº asiento to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº asiento to
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
	
	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}
		
	// SET  Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}	
	
	// GET Minuta contable
	public MinutaContable getMinutaContable() {
		return this.minutaContable;
	}
		
	// SET  Minuta contable
	public void setMinutaContable(MinutaContable minutaContable ){
		this.minutaContable = minutaContable;
	}	
	
	// GET Sucursal
	public Sucursal getSucursal() {
		return this.sucursal;
	}
		
	// SET  Sucursal
	public void setSucursal(Sucursal sucursal ){
		this.sucursal = sucursal;
	}	
	
	// GET Módulo
	public AsientoContableModulo getAsientoContableModulo() {
		return this.asientoContableModulo;
	}
		
	// SET  Módulo
	public void setAsientoContableModulo(AsientoContableModulo asientoContableModulo ){
		this.asientoContableModulo = asientoContableModulo;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		AsientoContableFilterQ1 other = (AsientoContableFilterQ1) obj;
		

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

		if (other.getEjercicioContable() == null && this.getEjercicioContable() != null) {
			return false;
		}

		if (other.getEjercicioContable() != null && this.getEjercicioContable() == null) {
			return false;
		}

		if (other.getEjercicioContable() != null && this.getEjercicioContable() != null) {

			if (other.getEjercicioContable().equals(this.getEjercicioContable()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getMinutaContable() == null && this.getMinutaContable() != null) {
			return false;
		}

		if (other.getMinutaContable() != null && this.getMinutaContable() == null) {
			return false;
		}

		if (other.getMinutaContable() != null && this.getMinutaContable() != null) {

			if (other.getMinutaContable().equals(this.getMinutaContable()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getSucursal() == null && this.getSucursal() != null) {
			return false;
		}

		if (other.getSucursal() != null && this.getSucursal() == null) {
			return false;
		}

		if (other.getSucursal() != null && this.getSucursal() != null) {

			if (other.getSucursal().equals(this.getSucursal()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getAsientoContableModulo() == null && this.getAsientoContableModulo() != null) {
			return false;
		}

		if (other.getAsientoContableModulo() != null && this.getAsientoContableModulo() == null) {
			return false;
		}

		if (other.getAsientoContableModulo() != null && this.getAsientoContableModulo() != null) {

			if (other.getAsientoContableModulo().equals(this.getAsientoContableModulo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public AsientoContableFilterQ1 clone() {

		AsientoContableFilterQ1 other = new AsientoContableFilterQ1();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setFechaFrom(this.getFechaFrom());			
		other.setFechaTo(this.getFechaTo());			
		other.setDetalle(this.getDetalle());			
		if(this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}				
		if(this.getMinutaContable() != null) {
			other.setMinutaContable(this.getMinutaContable().clone());
		}				
		if(this.getSucursal() != null) {
			other.setSucursal(this.getSucursal().clone());
		}				
		if(this.getAsientoContableModulo() != null) {
			other.setAsientoContableModulo(this.getAsientoContableModulo().clone());
		}				

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------