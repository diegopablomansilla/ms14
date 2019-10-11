package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.CuentaContableEstado;
import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.a.model.CostoVenta;
import com.massoftware.a.model.SeguridadPuerta;

public class CuentaContableFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Cuenta contable
	private String codigo;		
	
	// GET Nombre
	private String nombre;		
	
	// GET Ejercicio
	private EjercicioContable ejercicioContable;		
	
	// GET Integra
	private String integra;		
	
	// GET Cuenta de jerarquia
	private String cuentaJerarquia;		
	
	// GET Imputable
	private Boolean imputable;		
	
	// GET Ajusta por inflación
	private Boolean ajustaPorInflacion;		
	
	// GET Estado
	private CuentaContableEstado cuentaContableEstado;		
	
	// GET Cuenta con apropiación
	private Boolean cuentaConApropiacion;		
	
	// GET Centro costo contable
	private CentroCostoContable centroCostoContable;		
	
	// GET Cuenta agrupadora
	private String cuentaAgrupadora;		
	
	// GET Porcentaje from
	private Double porcentajeFrom;		
	
	// GET Porcentaje to
	private Double porcentajeTo;		
	
	// GET Punto de equilibrio
	private PuntoEquilibrio puntoEquilibrio;		
	
	// GET Costo de venta
	private CostoVenta costoVenta;		
	
	// GET Puerta
	private SeguridadPuerta seguridadPuerta;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Cuenta contable
	public String getCodigo() {
		return this.codigo;
	}
		
	// SET  Cuenta contable
	public void setCodigo(String codigo ){		
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}	
	
	// GET Nombre
	public String getNombre() {
		return this.nombre;
	}
		
	// SET  Nombre
	public void setNombre(String nombre ){		
		this.nombre = (nombre == null || nombre.trim().length() == 0) ? null : nombre.trim();
	}	
	
	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}
		
	// SET  Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}	
	
	// GET Integra
	public String getIntegra() {
		return this.integra;
	}
		
	// SET  Integra
	public void setIntegra(String integra ){		
		this.integra = (integra == null || integra.trim().length() == 0) ? null : integra.trim();
	}	
	
	// GET Cuenta de jerarquia
	public String getCuentaJerarquia() {
		return this.cuentaJerarquia;
	}
		
	// SET  Cuenta de jerarquia
	public void setCuentaJerarquia(String cuentaJerarquia ){		
		this.cuentaJerarquia = (cuentaJerarquia == null || cuentaJerarquia.trim().length() == 0) ? null : cuentaJerarquia.trim();
	}	
	
	// GET Imputable
	public Boolean getImputable() {
		return this.imputable;
	}
		
	// SET  Imputable
	public void setImputable(Boolean imputable ){		
		this.imputable = imputable;
	}
	
	// GET Ajusta por inflación
	public Boolean getAjustaPorInflacion() {
		return this.ajustaPorInflacion;
	}
		
	// SET  Ajusta por inflación
	public void setAjustaPorInflacion(Boolean ajustaPorInflacion ){		
		this.ajustaPorInflacion = ajustaPorInflacion;
	}
	
	// GET Estado
	public CuentaContableEstado getCuentaContableEstado() {
		return this.cuentaContableEstado;
	}
		
	// SET  Estado
	public void setCuentaContableEstado(CuentaContableEstado cuentaContableEstado ){
		this.cuentaContableEstado = cuentaContableEstado;
	}	
	
	// GET Cuenta con apropiación
	public Boolean getCuentaConApropiacion() {
		return this.cuentaConApropiacion;
	}
		
	// SET  Cuenta con apropiación
	public void setCuentaConApropiacion(Boolean cuentaConApropiacion ){		
		this.cuentaConApropiacion = cuentaConApropiacion;
	}
	
	// GET Centro costo contable
	public CentroCostoContable getCentroCostoContable() {
		return this.centroCostoContable;
	}
		
	// SET  Centro costo contable
	public void setCentroCostoContable(CentroCostoContable centroCostoContable ){
		this.centroCostoContable = centroCostoContable;
	}	
	
	// GET Cuenta agrupadora
	public String getCuentaAgrupadora() {
		return this.cuentaAgrupadora;
	}
		
	// SET  Cuenta agrupadora
	public void setCuentaAgrupadora(String cuentaAgrupadora ){		
		this.cuentaAgrupadora = (cuentaAgrupadora == null || cuentaAgrupadora.trim().length() == 0) ? null : cuentaAgrupadora.trim();
	}	
	
	// GET Porcentaje from
	public Double getPorcentajeFrom() {
		return this.porcentajeFrom;
	}
		
	// SET  Porcentaje from
	public void setPorcentajeFrom(Double porcentajeFrom ){
		this.porcentajeFrom = porcentajeFrom;
	}	
	
	// GET Porcentaje to
	public Double getPorcentajeTo() {
		return this.porcentajeFrom;
	}
		
	// SET  Porcentaje to
	public void setPorcentajeTo(Double porcentajeFrom ){
		this.porcentajeFrom = porcentajeFrom;
	}	
	
	// GET Punto de equilibrio
	public PuntoEquilibrio getPuntoEquilibrio() {
		return this.puntoEquilibrio;
	}
		
	// SET  Punto de equilibrio
	public void setPuntoEquilibrio(PuntoEquilibrio puntoEquilibrio ){
		this.puntoEquilibrio = puntoEquilibrio;
	}	
	
	// GET Costo de venta
	public CostoVenta getCostoVenta() {
		return this.costoVenta;
	}
		
	// SET  Costo de venta
	public void setCostoVenta(CostoVenta costoVenta ){
		this.costoVenta = costoVenta;
	}	
	
	// GET Puerta
	public SeguridadPuerta getSeguridadPuerta() {
		return this.seguridadPuerta;
	}
		
	// SET  Puerta
	public void setSeguridadPuerta(SeguridadPuerta seguridadPuerta ){
		this.seguridadPuerta = seguridadPuerta;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		CuentaContableFilterQ1 other = (CuentaContableFilterQ1) obj;
		

		// -------------------------------------------------------------------

		if (other.getCodigo() == null && this.getCodigo() != null) {
			return false;
		}

		if (other.getCodigo() != null && this.getCodigo() == null) {
			return false;
		}

		if (other.getCodigo() != null && this.getCodigo() != null) {

			if (other.getCodigo().equals(this.getCodigo()) == false) {
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

		if (other.getIntegra() == null && this.getIntegra() != null) {
			return false;
		}

		if (other.getIntegra() != null && this.getIntegra() == null) {
			return false;
		}

		if (other.getIntegra() != null && this.getIntegra() != null) {

			if (other.getIntegra().equals(this.getIntegra()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaJerarquia() == null && this.getCuentaJerarquia() != null) {
			return false;
		}

		if (other.getCuentaJerarquia() != null && this.getCuentaJerarquia() == null) {
			return false;
		}

		if (other.getCuentaJerarquia() != null && this.getCuentaJerarquia() != null) {

			if (other.getCuentaJerarquia().equals(this.getCuentaJerarquia()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getImputable() == null && this.getImputable() != null) {
			return false;
		}

		if (other.getImputable() != null && this.getImputable() == null) {
			return false;
		}

		if (other.getImputable() != null && this.getImputable() != null) {

			if (other.getImputable().equals(this.getImputable()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getAjustaPorInflacion() == null && this.getAjustaPorInflacion() != null) {
			return false;
		}

		if (other.getAjustaPorInflacion() != null && this.getAjustaPorInflacion() == null) {
			return false;
		}

		if (other.getAjustaPorInflacion() != null && this.getAjustaPorInflacion() != null) {

			if (other.getAjustaPorInflacion().equals(this.getAjustaPorInflacion()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaContableEstado() == null && this.getCuentaContableEstado() != null) {
			return false;
		}

		if (other.getCuentaContableEstado() != null && this.getCuentaContableEstado() == null) {
			return false;
		}

		if (other.getCuentaContableEstado() != null && this.getCuentaContableEstado() != null) {

			if (other.getCuentaContableEstado().equals(this.getCuentaContableEstado()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaConApropiacion() == null && this.getCuentaConApropiacion() != null) {
			return false;
		}

		if (other.getCuentaConApropiacion() != null && this.getCuentaConApropiacion() == null) {
			return false;
		}

		if (other.getCuentaConApropiacion() != null && this.getCuentaConApropiacion() != null) {

			if (other.getCuentaConApropiacion().equals(this.getCuentaConApropiacion()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCentroCostoContable() == null && this.getCentroCostoContable() != null) {
			return false;
		}

		if (other.getCentroCostoContable() != null && this.getCentroCostoContable() == null) {
			return false;
		}

		if (other.getCentroCostoContable() != null && this.getCentroCostoContable() != null) {

			if (other.getCentroCostoContable().equals(this.getCentroCostoContable()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCuentaAgrupadora() == null && this.getCuentaAgrupadora() != null) {
			return false;
		}

		if (other.getCuentaAgrupadora() != null && this.getCuentaAgrupadora() == null) {
			return false;
		}

		if (other.getCuentaAgrupadora() != null && this.getCuentaAgrupadora() != null) {

			if (other.getCuentaAgrupadora().equals(this.getCuentaAgrupadora()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getPorcentajeFrom() == null && this.getPorcentajeFrom() != null) {
			return false;
		}

		if (other.getPorcentajeFrom() != null && this.getPorcentajeFrom() == null) {
			return false;
		}

		if (other.getPorcentajeFrom() != null && this.getPorcentajeFrom() != null) {

			if (other.getPorcentajeFrom().equals(this.getPorcentajeFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getPorcentajeTo() == null && this.getPorcentajeTo() != null) {
			return false;
		}

		if (other.getPorcentajeTo() != null && this.getPorcentajeTo() == null) {
			return false;
		}

		if (other.getPorcentajeTo() != null && this.getPorcentajeTo() != null) {

			if (other.getPorcentajeTo().equals(this.getPorcentajeTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getPuntoEquilibrio() == null && this.getPuntoEquilibrio() != null) {
			return false;
		}

		if (other.getPuntoEquilibrio() != null && this.getPuntoEquilibrio() == null) {
			return false;
		}

		if (other.getPuntoEquilibrio() != null && this.getPuntoEquilibrio() != null) {

			if (other.getPuntoEquilibrio().equals(this.getPuntoEquilibrio()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getCostoVenta() == null && this.getCostoVenta() != null) {
			return false;
		}

		if (other.getCostoVenta() != null && this.getCostoVenta() == null) {
			return false;
		}

		if (other.getCostoVenta() != null && this.getCostoVenta() != null) {

			if (other.getCostoVenta().equals(this.getCostoVenta()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getSeguridadPuerta() == null && this.getSeguridadPuerta() != null) {
			return false;
		}

		if (other.getSeguridadPuerta() != null && this.getSeguridadPuerta() == null) {
			return false;
		}

		if (other.getSeguridadPuerta() != null && this.getSeguridadPuerta() != null) {

			if (other.getSeguridadPuerta().equals(this.getSeguridadPuerta()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public CuentaContableFilterQ1 clone() {

		CuentaContableFilterQ1 other = new CuentaContableFilterQ1();

		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		other.setCodigo(this.getCodigo());			
		other.setNombre(this.getNombre());			
		if(this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}				
		other.setIntegra(this.getIntegra());			
		other.setCuentaJerarquia(this.getCuentaJerarquia());			
		other.setImputable(this.getImputable());			
		other.setAjustaPorInflacion(this.getAjustaPorInflacion());			
		if(this.getCuentaContableEstado() != null) {
			other.setCuentaContableEstado(this.getCuentaContableEstado().clone());
		}				
		other.setCuentaConApropiacion(this.getCuentaConApropiacion());			
		if(this.getCentroCostoContable() != null) {
			other.setCentroCostoContable(this.getCentroCostoContable().clone());
		}				
		other.setCuentaAgrupadora(this.getCuentaAgrupadora());			
		other.setPorcentajeFrom(this.getPorcentajeFrom());			
		other.setPorcentajeTo(this.getPorcentajeTo());			
		if(this.getPuntoEquilibrio() != null) {
			other.setPuntoEquilibrio(this.getPuntoEquilibrio().clone());
		}				
		if(this.getCostoVenta() != null) {
			other.setCostoVenta(this.getCostoVenta().clone());
		}				
		if(this.getSeguridadPuerta() != null) {
			other.setSeguridadPuerta(this.getSeguridadPuerta().clone());
		}				

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------