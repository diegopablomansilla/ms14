package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;


public class SeguridadModulo extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Nº módulo
	private Integer numero;		
	
	// GET Nombre
	private String nombre;		
	
	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}	
	
	
	// GET Nº módulo
	public Integer getNumero() {
		return this.numero;
	}
		
	// SET  Nº módulo
	public void setNumero(Integer numero ){
		this.numero = numero;
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

	public String toString() {
		if(this.getNumero() != null && this.getNombre() != null){
			return this.getNumero() + " - " +  this.getNombre();
		} else if(this.getNumero() != null && this.getNombre() == null){
			return this.getNumero().toString();
		} else if(this.getNumero() == null && this.getNombre() != null){
			return this.getNombre().toString();
		} else {
			return super.toString();
		}
	}
		
	public SeguridadModulo clone() {
		
		SeguridadModulo other = new SeguridadModulo();
		
		other.setId(this.getId());
		
		other.setNumero(this.getNumero());			
		other.setNombre(this.getNombre());			
		
		// -------------------------------------------------------------------
		
		return other;
		
		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------