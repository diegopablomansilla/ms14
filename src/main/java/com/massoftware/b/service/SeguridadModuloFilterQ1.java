package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;


public class SeguridadModuloFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº módulo from
	private Integer numeroFrom;		
	
	// GET Nº módulo to
	private Integer numeroTo;		
	
	// GET Nombre
	private String nombre;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº módulo from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº módulo from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº módulo to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº módulo to
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

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		SeguridadModuloFilterQ1 other = (SeguridadModuloFilterQ1) obj;
		

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

		return true;

		// -------------------------------------------------------------------
	}

	public SeguridadModuloFilterQ1 clone() {

		SeguridadModuloFilterQ1 other = new SeguridadModuloFilterQ1();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setNombre(this.getNombre());			

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------