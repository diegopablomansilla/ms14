package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import java.time.LocalDate;

public class EjercicioContableFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº ejercicio from
	private Integer numeroFrom;		
	
	// GET Nº ejercicio to
	private Integer numeroTo;		
	
	// GET Apertura from
	private LocalDate aperturaFrom;		
	
	// GET Apertura to
	private LocalDate aperturaTo;		
	
	// GET Cierre from
	private LocalDate cierreFrom;		
	
	// GET Cierre to
	private LocalDate cierreTo;		
	
	// GET Cerrado
	private Boolean cerrado;		
	
	// GET Módulos cerrados
	private Boolean cerradoModulos;		
	
	// GET Comentario
	private String comentario;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Nº ejercicio from
	public Integer getNumeroFrom() {
		return this.numeroFrom;
	}
		
	// SET  Nº ejercicio from
	public void setNumeroFrom(Integer numeroFrom ){
		this.numeroFrom = numeroFrom;
	}	
	
	// GET Nº ejercicio to
	public Integer getNumeroTo() {
		return this.numeroTo;
	}
		
	// SET  Nº ejercicio to
	public void setNumeroTo(Integer numeroTo ){
		this.numeroTo = numeroTo;
	}	
	
	// GET Apertura from
	public LocalDate getAperturaFrom() {
		return this.aperturaFrom;
	}
		
	// SET  Apertura from
	public void setAperturaFrom(LocalDate aperturaFrom ){
		this.aperturaFrom = aperturaFrom;
	}	
	
	// GET Apertura to
	public LocalDate getAperturaTo() {
		return this.aperturaTo;
	}
		
	// SET  Apertura to
	public void setAperturaTo(LocalDate aperturaTo ){
		this.aperturaTo = aperturaTo;
	}	
	
	// GET Cierre from
	public LocalDate getCierreFrom() {
		return this.cierreFrom;
	}
		
	// SET  Cierre from
	public void setCierreFrom(LocalDate cierreFrom ){
		this.cierreFrom = cierreFrom;
	}	
	
	// GET Cierre to
	public LocalDate getCierreTo() {
		return this.cierreTo;
	}
		
	// SET  Cierre to
	public void setCierreTo(LocalDate cierreTo ){
		this.cierreTo = cierreTo;
	}	
	
	// GET Cerrado
	public Boolean getCerrado() {
		return this.cerrado;
	}
		
	// SET  Cerrado
	public void setCerrado(Boolean cerrado ){		
		this.cerrado = cerrado;
	}
	
	// GET Módulos cerrados
	public Boolean getCerradoModulos() {
		return this.cerradoModulos;
	}
		
	// SET  Módulos cerrados
	public void setCerradoModulos(Boolean cerradoModulos ){		
		this.cerradoModulos = cerradoModulos;
	}
	
	// GET Comentario
	public String getComentario() {
		return this.comentario;
	}
		
	// SET  Comentario
	public void setComentario(String comentario ){		
		this.comentario = (comentario == null || comentario.trim().length() == 0) ? null : comentario.trim();
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		EjercicioContableFilterQ1 other = (EjercicioContableFilterQ1) obj;
		

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

		if (other.getAperturaFrom() == null && this.getAperturaFrom() != null) {
			return false;
		}

		if (other.getAperturaFrom() != null && this.getAperturaFrom() == null) {
			return false;
		}

		if (other.getAperturaFrom() != null && this.getAperturaFrom() != null) {

			if (other.getAperturaFrom().equals(this.getAperturaFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getAperturaTo() == null && this.getAperturaTo() != null) {
			return false;
		}

		if (other.getAperturaTo() != null && this.getAperturaTo() == null) {
			return false;
		}

		if (other.getAperturaTo() != null && this.getAperturaTo() != null) {

			if (other.getAperturaTo().equals(this.getAperturaTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCierreFrom() == null && this.getCierreFrom() != null) {
			return false;
		}

		if (other.getCierreFrom() != null && this.getCierreFrom() == null) {
			return false;
		}

		if (other.getCierreFrom() != null && this.getCierreFrom() != null) {

			if (other.getCierreFrom().equals(this.getCierreFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCierreTo() == null && this.getCierreTo() != null) {
			return false;
		}

		if (other.getCierreTo() != null && this.getCierreTo() == null) {
			return false;
		}

		if (other.getCierreTo() != null && this.getCierreTo() != null) {

			if (other.getCierreTo().equals(this.getCierreTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCerrado() == null && this.getCerrado() != null) {
			return false;
		}

		if (other.getCerrado() != null && this.getCerrado() == null) {
			return false;
		}

		if (other.getCerrado() != null && this.getCerrado() != null) {

			if (other.getCerrado().equals(this.getCerrado()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCerradoModulos() == null && this.getCerradoModulos() != null) {
			return false;
		}

		if (other.getCerradoModulos() != null && this.getCerradoModulos() == null) {
			return false;
		}

		if (other.getCerradoModulos() != null && this.getCerradoModulos() != null) {

			if (other.getCerradoModulos().equals(this.getCerradoModulos()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getComentario() == null && this.getComentario() != null) {
			return false;
		}

		if (other.getComentario() != null && this.getComentario() == null) {
			return false;
		}

		if (other.getComentario() != null && this.getComentario() != null) {

			if (other.getComentario().equals(this.getComentario()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public EjercicioContableFilterQ1 clone() {

		EjercicioContableFilterQ1 other = new EjercicioContableFilterQ1();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setNumeroFrom(this.getNumeroFrom());			
		other.setNumeroTo(this.getNumeroTo());			
		other.setAperturaFrom(this.getAperturaFrom());			
		other.setAperturaTo(this.getAperturaTo());			
		other.setCierreFrom(this.getCierreFrom());			
		other.setCierreTo(this.getCierreTo());			
		other.setCerrado(this.getCerrado());			
		other.setCerradoModulos(this.getCerradoModulos());			
		other.setComentario(this.getComentario());			

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------