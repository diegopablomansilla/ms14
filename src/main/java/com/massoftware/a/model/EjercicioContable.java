package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;

import java.time.LocalDate;

public class EjercicioContable extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Nº ejercicio
	private Integer numero;		
	
	// GET Apertura
	private LocalDate apertura;		
	
	// GET Cierre
	private LocalDate cierre;		
	
	// GET Cerrado
	private Boolean cerrado;		
	
	// GET Cerrado módulos
	private Boolean cerradoModulos;		
	
	// GET Comentario
	private String comentario;		
	
	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}	
	
	
	// GET Nº ejercicio
	public Integer getNumero() {
		return this.numero;
	}
		
	// SET  Nº ejercicio
	public void setNumero(Integer numero ){
		this.numero = numero;
	}	
	
	// GET Apertura
	public LocalDate getApertura() {
		return this.apertura;
	}
		
	// SET  Apertura
	public void setApertura(LocalDate apertura ){
		this.apertura = apertura;
	}	
	
	// GET Cierre
	public LocalDate getCierre() {
		return this.cierre;
	}
		
	// SET  Cierre
	public void setCierre(LocalDate cierre ){
		this.cierre = cierre;
	}	
	
	// GET Cerrado
	public Boolean getCerrado() {
		return this.cerrado;
	}
		
	// SET  Cerrado
	public void setCerrado(Boolean cerrado ){		
		this.cerrado = (cerrado == null) ? false : cerrado;
	}
	
	// GET Cerrado módulos
	public Boolean getCerradoModulos() {
		return this.cerradoModulos;
	}
		
	// SET  Cerrado módulos
	public void setCerradoModulos(Boolean cerradoModulos ){		
		this.cerradoModulos = (cerradoModulos == null) ? false : cerradoModulos;
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

	public String toString() {
		if(this.getNumero() != null && this.getApertura() != null){
			return this.getNumero() + " - " +  this.getApertura();
		} else if(this.getNumero() != null && this.getApertura() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getApertura() != null){
			return this.getApertura().toString();
		} else {
			return super.toString();
		}
	}
		
	public EjercicioContable clone() {
		
		EjercicioContable other = new EjercicioContable();
		
		other.setId(this.getId());
		
		other.setNumero(this.getNumero());			
		other.setApertura(this.getApertura());			
		other.setCierre(this.getCierre());			
		other.setCerrado(this.getCerrado());			
		other.setCerradoModulos(this.getCerradoModulos());			
		other.setComentario(this.getComentario());			
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------