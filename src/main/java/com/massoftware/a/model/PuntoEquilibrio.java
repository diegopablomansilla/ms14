package com.massoftware.a.model;

import com.massoftware.a.model.util.EntityId;

import com.massoftware.a.model.TipoPuntoEquilibrio;
import com.massoftware.a.model.EjercicioContable;

public class PuntoEquilibrio extends EntityId {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String id;
	
	
	// GET Nº cc
	private Integer numero;		
	
	// GET Nombre
	private String nombre;		
	
	// GET Tipo
	private TipoPuntoEquilibrio tipoPuntoEquilibrio;		
	
	// GET Ejercicio
	private EjercicioContable ejercicioContable;		
	
	// ---------------------------------------------------------------------------------------------------------------------------


	// GET ID
	public String getId() {
		return this.id;
	}
	// SET ID
	public void setId(String id){
		this.id = (id == null || id.trim().length() == 0) ? null : id.trim();
	}	
	
	
	// GET Nº cc
	public Integer getNumero() {
		return this.numero;
	}
		
	// SET  Nº cc
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
		
	public PuntoEquilibrio clone() {
		
		PuntoEquilibrio other = new PuntoEquilibrio();
		
		other.setId(this.getId());
		
		other.setNumero(this.getNumero());			
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