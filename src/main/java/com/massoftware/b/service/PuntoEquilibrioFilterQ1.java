package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.TipoPuntoEquilibrio;
import com.massoftware.a.model.EjercicioContable;

public class PuntoEquilibrioFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº cc from
	private Integer numeroFrom;		
	
	// GET Nº cc to
	private Integer numeroTo;		
	
	// GET Nombre
	private String nombre;		
	
	// GET Tipo
	private TipoPuntoEquilibrio tipoPuntoEquilibrio;		
	
	// GET Ejercicio
	private EjercicioContable ejercicioContable;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº cc from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº cc from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº cc to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº cc to
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
	
	// GET Tipo
	public TipoPuntoEquilibrio getTipoPuntoEquilibrio() {
		return this.tipoPuntoEquilibrio;
	}
		
	// SET  Tipo
	public void setTipoPuntoEquilibrio(TipoPuntoEquilibrio tipoPuntoEquilibrio ){
		this.tipoPuntoEquilibrio = tipoPuntoEquilibrio;
	}	
	
	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}
		
	// SET  Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		PuntoEquilibrioFilterQ1 other = (PuntoEquilibrioFilterQ1) obj;
		

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

		if (other.getTipoPuntoEquilibrio() == null && this.getTipoPuntoEquilibrio() != null) {
			return false;
		}

		if (other.getTipoPuntoEquilibrio() != null && this.getTipoPuntoEquilibrio() == null) {
			return false;
		}

		if (other.getTipoPuntoEquilibrio() != null && this.getTipoPuntoEquilibrio() != null) {

			if (other.getTipoPuntoEquilibrio().equals(this.getTipoPuntoEquilibrio()) == false) {
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

		return true;

		// -------------------------------------------------------------------
	}

	public PuntoEquilibrioFilterQ1 clone() {

		PuntoEquilibrioFilterQ1 other = new PuntoEquilibrioFilterQ1();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setNombre(this.getNombre());			
		if(this.getTipoPuntoEquilibrio() != null) {
			other.setTipoPuntoEquilibrio(this.getTipoPuntoEquilibrio().clone());
		}				
		if(this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}				

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------