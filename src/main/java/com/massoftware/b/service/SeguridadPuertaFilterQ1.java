package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.SeguridadModulo;

public class SeguridadPuertaFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº módulo from
	private Integer numeroFrom;		
	
	// GET Nº módulo to
	private Integer numeroTo;		
	
	// GET Nombre
	private String nombre;		
	
	// GET I.D
	private String equate;		
	
	// GET Módulo
	private SeguridadModulo seguridadModulo;		

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
	
	// GET I.D
	public String getEquate() {
		return this.equate;
	}
		
	// SET  I.D
	public void setEquate(String equate ){		
		this.equate = (equate == null || equate.trim().length() == 0) ? null : equate.trim();
	}	
	
	// GET Módulo
	public SeguridadModulo getSeguridadModulo() {
		return this.seguridadModulo;
	}
		
	// SET  Módulo
	public void setSeguridadModulo(SeguridadModulo seguridadModulo ){
		this.seguridadModulo = seguridadModulo;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		SeguridadPuertaFilterQ1 other = (SeguridadPuertaFilterQ1) obj;
		

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

		if (other.getEquate() == null && this.getEquate() != null) {
			return false;
		}

		if (other.getEquate() != null && this.getEquate() == null) {
			return false;
		}

		if (other.getEquate() != null && this.getEquate() != null) {

			if (other.getEquate().equals(this.getEquate()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getSeguridadModulo() == null && this.getSeguridadModulo() != null) {
			return false;
		}

		if (other.getSeguridadModulo() != null && this.getSeguridadModulo() == null) {
			return false;
		}

		if (other.getSeguridadModulo() != null && this.getSeguridadModulo() != null) {

			if (other.getSeguridadModulo().equals(this.getSeguridadModulo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public SeguridadPuertaFilterQ1 clone() {

		SeguridadPuertaFilterQ1 other = new SeguridadPuertaFilterQ1();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setNombre(this.getNombre());			
		other.setEquate(this.getEquate());			
		if(this.getSeguridadModulo() != null) {
			other.setSeguridadModulo(this.getSeguridadModulo().clone());
		}				

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------