package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;


public class TipoSucursalFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº tipo from
	private Integer numeroFrom;		
	
	// GET Nº tipo to
	private Integer numeroTo;		
	
	// GET Nombre
	private String nombre;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº tipo from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº tipo from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº tipo to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº tipo to
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

		TipoSucursalFilterQ1 other = (TipoSucursalFilterQ1) obj;
		

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

	public TipoSucursalFilterQ1 clone() {

		TipoSucursalFilterQ1 other = new TipoSucursalFilterQ1();

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