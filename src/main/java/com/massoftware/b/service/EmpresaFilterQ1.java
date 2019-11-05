package com.massoftware.b.service;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.EjercicioContable;
import java.time.LocalDate;

public class EmpresaFilterQ1 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Ejercicio
	private EjercicioContable ejercicioContable;		
	
	// GET Fecha cierre ventas from
	private LocalDate fechaCierreVentasFrom;		
	
	// GET Fecha cierre ventas to
	private LocalDate fechaCierreVentasTo;		
	
	// GET Fecha cierre stock from
	private LocalDate fechaCierreStockFrom;		
	
	// GET Fecha cierre stock to
	private LocalDate fechaCierreStockTo;		
	
	// GET Fecha cierre fondo from
	private LocalDate fechaCierreFondoFrom;		
	
	// GET Fecha cierre fondo to
	private LocalDate fechaCierreFondoTo;		
	
	// GET Fecha cierre compras from
	private LocalDate fechaCierreComprasFrom;		
	
	// GET Fecha cierre compras to
	private LocalDate fechaCierreComprasTo;		
	
	// GET Fecha cierre contabilidad from
	private LocalDate fechaCierreContabilidadFrom;		
	
	// GET Fecha cierre contabilidad to
	private LocalDate fechaCierreContabilidadTo;		
	
	// GET Fecha cierre garantia y devoluciones from
	private LocalDate fechaCierreGarantiaDevolucionesFrom;		
	
	// GET Fecha cierre garantia y devoluciones to
	private LocalDate fechaCierreGarantiaDevolucionesTo;		
	
	// GET Fecha cierre tambos from
	private LocalDate fechaCierreTambosFrom;		
	
	// GET Fecha cierre tambos to
	private LocalDate fechaCierreTambosTo;		
	
	// GET Fecha cierre RRHH from
	private LocalDate fechaCierreRRHHFrom;		
	
	// GET Fecha cierre RRHH to
	private LocalDate fechaCierreRRHHTo;		

	// ---------------------------------------------------------------------------------------------------------------------------
	
	
	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}
		
	// SET  Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable ){
		this.ejercicioContable = ejercicioContable;
	}	
	
	// GET Fecha cierre ventas from
	public LocalDate getFechaCierreVentasFrom() {
		return this.fechaCierreVentasFrom;
	}
		
	// SET  Fecha cierre ventas from
	public void setFechaCierreVentasFrom(LocalDate fechaCierreVentasFrom ){
		this.fechaCierreVentasFrom = fechaCierreVentasFrom;
	}	
	
	// GET Fecha cierre ventas to
	public LocalDate getFechaCierreVentasTo() {
		return this.fechaCierreVentasTo;
	}
		
	// SET  Fecha cierre ventas to
	public void setFechaCierreVentasTo(LocalDate fechaCierreVentasTo ){
		this.fechaCierreVentasTo = fechaCierreVentasTo;
	}	
	
	// GET Fecha cierre stock from
	public LocalDate getFechaCierreStockFrom() {
		return this.fechaCierreStockFrom;
	}
		
	// SET  Fecha cierre stock from
	public void setFechaCierreStockFrom(LocalDate fechaCierreStockFrom ){
		this.fechaCierreStockFrom = fechaCierreStockFrom;
	}	
	
	// GET Fecha cierre stock to
	public LocalDate getFechaCierreStockTo() {
		return this.fechaCierreStockTo;
	}
		
	// SET  Fecha cierre stock to
	public void setFechaCierreStockTo(LocalDate fechaCierreStockTo ){
		this.fechaCierreStockTo = fechaCierreStockTo;
	}	
	
	// GET Fecha cierre fondo from
	public LocalDate getFechaCierreFondoFrom() {
		return this.fechaCierreFondoFrom;
	}
		
	// SET  Fecha cierre fondo from
	public void setFechaCierreFondoFrom(LocalDate fechaCierreFondoFrom ){
		this.fechaCierreFondoFrom = fechaCierreFondoFrom;
	}	
	
	// GET Fecha cierre fondo to
	public LocalDate getFechaCierreFondoTo() {
		return this.fechaCierreFondoTo;
	}
		
	// SET  Fecha cierre fondo to
	public void setFechaCierreFondoTo(LocalDate fechaCierreFondoTo ){
		this.fechaCierreFondoTo = fechaCierreFondoTo;
	}	
	
	// GET Fecha cierre compras from
	public LocalDate getFechaCierreComprasFrom() {
		return this.fechaCierreComprasFrom;
	}
		
	// SET  Fecha cierre compras from
	public void setFechaCierreComprasFrom(LocalDate fechaCierreComprasFrom ){
		this.fechaCierreComprasFrom = fechaCierreComprasFrom;
	}	
	
	// GET Fecha cierre compras to
	public LocalDate getFechaCierreComprasTo() {
		return this.fechaCierreComprasTo;
	}
		
	// SET  Fecha cierre compras to
	public void setFechaCierreComprasTo(LocalDate fechaCierreComprasTo ){
		this.fechaCierreComprasTo = fechaCierreComprasTo;
	}	
	
	// GET Fecha cierre contabilidad from
	public LocalDate getFechaCierreContabilidadFrom() {
		return this.fechaCierreContabilidadFrom;
	}
		
	// SET  Fecha cierre contabilidad from
	public void setFechaCierreContabilidadFrom(LocalDate fechaCierreContabilidadFrom ){
		this.fechaCierreContabilidadFrom = fechaCierreContabilidadFrom;
	}	
	
	// GET Fecha cierre contabilidad to
	public LocalDate getFechaCierreContabilidadTo() {
		return this.fechaCierreContabilidadTo;
	}
		
	// SET  Fecha cierre contabilidad to
	public void setFechaCierreContabilidadTo(LocalDate fechaCierreContabilidadTo ){
		this.fechaCierreContabilidadTo = fechaCierreContabilidadTo;
	}	
	
	// GET Fecha cierre garantia y devoluciones from
	public LocalDate getFechaCierreGarantiaDevolucionesFrom() {
		return this.fechaCierreGarantiaDevolucionesFrom;
	}
		
	// SET  Fecha cierre garantia y devoluciones from
	public void setFechaCierreGarantiaDevolucionesFrom(LocalDate fechaCierreGarantiaDevolucionesFrom ){
		this.fechaCierreGarantiaDevolucionesFrom = fechaCierreGarantiaDevolucionesFrom;
	}	
	
	// GET Fecha cierre garantia y devoluciones to
	public LocalDate getFechaCierreGarantiaDevolucionesTo() {
		return this.fechaCierreGarantiaDevolucionesTo;
	}
		
	// SET  Fecha cierre garantia y devoluciones to
	public void setFechaCierreGarantiaDevolucionesTo(LocalDate fechaCierreGarantiaDevolucionesTo ){
		this.fechaCierreGarantiaDevolucionesTo = fechaCierreGarantiaDevolucionesTo;
	}	
	
	// GET Fecha cierre tambos from
	public LocalDate getFechaCierreTambosFrom() {
		return this.fechaCierreTambosFrom;
	}
		
	// SET  Fecha cierre tambos from
	public void setFechaCierreTambosFrom(LocalDate fechaCierreTambosFrom ){
		this.fechaCierreTambosFrom = fechaCierreTambosFrom;
	}	
	
	// GET Fecha cierre tambos to
	public LocalDate getFechaCierreTambosTo() {
		return this.fechaCierreTambosTo;
	}
		
	// SET  Fecha cierre tambos to
	public void setFechaCierreTambosTo(LocalDate fechaCierreTambosTo ){
		this.fechaCierreTambosTo = fechaCierreTambosTo;
	}	
	
	// GET Fecha cierre RRHH from
	public LocalDate getFechaCierreRRHHFrom() {
		return this.fechaCierreRRHHFrom;
	}
		
	// SET  Fecha cierre RRHH from
	public void setFechaCierreRRHHFrom(LocalDate fechaCierreRRHHFrom ){
		this.fechaCierreRRHHFrom = fechaCierreRRHHFrom;
	}	
	
	// GET Fecha cierre RRHH to
	public LocalDate getFechaCierreRRHHTo() {
		return this.fechaCierreRRHHTo;
	}
		
	// SET  Fecha cierre RRHH to
	public void setFechaCierreRRHHTo(LocalDate fechaCierreRRHHTo ){
		this.fechaCierreRRHHTo = fechaCierreRRHHTo;
	}	

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		EmpresaFilterQ1 other = (EmpresaFilterQ1) obj;
		

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

		if (other.getFechaCierreVentasFrom() == null && this.getFechaCierreVentasFrom() != null) {
			return false;
		}

		if (other.getFechaCierreVentasFrom() != null && this.getFechaCierreVentasFrom() == null) {
			return false;
		}

		if (other.getFechaCierreVentasFrom() != null && this.getFechaCierreVentasFrom() != null) {

			if (other.getFechaCierreVentasFrom().equals(this.getFechaCierreVentasFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreVentasTo() == null && this.getFechaCierreVentasTo() != null) {
			return false;
		}

		if (other.getFechaCierreVentasTo() != null && this.getFechaCierreVentasTo() == null) {
			return false;
		}

		if (other.getFechaCierreVentasTo() != null && this.getFechaCierreVentasTo() != null) {

			if (other.getFechaCierreVentasTo().equals(this.getFechaCierreVentasTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreStockFrom() == null && this.getFechaCierreStockFrom() != null) {
			return false;
		}

		if (other.getFechaCierreStockFrom() != null && this.getFechaCierreStockFrom() == null) {
			return false;
		}

		if (other.getFechaCierreStockFrom() != null && this.getFechaCierreStockFrom() != null) {

			if (other.getFechaCierreStockFrom().equals(this.getFechaCierreStockFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreStockTo() == null && this.getFechaCierreStockTo() != null) {
			return false;
		}

		if (other.getFechaCierreStockTo() != null && this.getFechaCierreStockTo() == null) {
			return false;
		}

		if (other.getFechaCierreStockTo() != null && this.getFechaCierreStockTo() != null) {

			if (other.getFechaCierreStockTo().equals(this.getFechaCierreStockTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreFondoFrom() == null && this.getFechaCierreFondoFrom() != null) {
			return false;
		}

		if (other.getFechaCierreFondoFrom() != null && this.getFechaCierreFondoFrom() == null) {
			return false;
		}

		if (other.getFechaCierreFondoFrom() != null && this.getFechaCierreFondoFrom() != null) {

			if (other.getFechaCierreFondoFrom().equals(this.getFechaCierreFondoFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreFondoTo() == null && this.getFechaCierreFondoTo() != null) {
			return false;
		}

		if (other.getFechaCierreFondoTo() != null && this.getFechaCierreFondoTo() == null) {
			return false;
		}

		if (other.getFechaCierreFondoTo() != null && this.getFechaCierreFondoTo() != null) {

			if (other.getFechaCierreFondoTo().equals(this.getFechaCierreFondoTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreComprasFrom() == null && this.getFechaCierreComprasFrom() != null) {
			return false;
		}

		if (other.getFechaCierreComprasFrom() != null && this.getFechaCierreComprasFrom() == null) {
			return false;
		}

		if (other.getFechaCierreComprasFrom() != null && this.getFechaCierreComprasFrom() != null) {

			if (other.getFechaCierreComprasFrom().equals(this.getFechaCierreComprasFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreComprasTo() == null && this.getFechaCierreComprasTo() != null) {
			return false;
		}

		if (other.getFechaCierreComprasTo() != null && this.getFechaCierreComprasTo() == null) {
			return false;
		}

		if (other.getFechaCierreComprasTo() != null && this.getFechaCierreComprasTo() != null) {

			if (other.getFechaCierreComprasTo().equals(this.getFechaCierreComprasTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreContabilidadFrom() == null && this.getFechaCierreContabilidadFrom() != null) {
			return false;
		}

		if (other.getFechaCierreContabilidadFrom() != null && this.getFechaCierreContabilidadFrom() == null) {
			return false;
		}

		if (other.getFechaCierreContabilidadFrom() != null && this.getFechaCierreContabilidadFrom() != null) {

			if (other.getFechaCierreContabilidadFrom().equals(this.getFechaCierreContabilidadFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreContabilidadTo() == null && this.getFechaCierreContabilidadTo() != null) {
			return false;
		}

		if (other.getFechaCierreContabilidadTo() != null && this.getFechaCierreContabilidadTo() == null) {
			return false;
		}

		if (other.getFechaCierreContabilidadTo() != null && this.getFechaCierreContabilidadTo() != null) {

			if (other.getFechaCierreContabilidadTo().equals(this.getFechaCierreContabilidadTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreGarantiaDevolucionesFrom() == null && this.getFechaCierreGarantiaDevolucionesFrom() != null) {
			return false;
		}

		if (other.getFechaCierreGarantiaDevolucionesFrom() != null && this.getFechaCierreGarantiaDevolucionesFrom() == null) {
			return false;
		}

		if (other.getFechaCierreGarantiaDevolucionesFrom() != null && this.getFechaCierreGarantiaDevolucionesFrom() != null) {

			if (other.getFechaCierreGarantiaDevolucionesFrom().equals(this.getFechaCierreGarantiaDevolucionesFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreGarantiaDevolucionesTo() == null && this.getFechaCierreGarantiaDevolucionesTo() != null) {
			return false;
		}

		if (other.getFechaCierreGarantiaDevolucionesTo() != null && this.getFechaCierreGarantiaDevolucionesTo() == null) {
			return false;
		}

		if (other.getFechaCierreGarantiaDevolucionesTo() != null && this.getFechaCierreGarantiaDevolucionesTo() != null) {

			if (other.getFechaCierreGarantiaDevolucionesTo().equals(this.getFechaCierreGarantiaDevolucionesTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreTambosFrom() == null && this.getFechaCierreTambosFrom() != null) {
			return false;
		}

		if (other.getFechaCierreTambosFrom() != null && this.getFechaCierreTambosFrom() == null) {
			return false;
		}

		if (other.getFechaCierreTambosFrom() != null && this.getFechaCierreTambosFrom() != null) {

			if (other.getFechaCierreTambosFrom().equals(this.getFechaCierreTambosFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreTambosTo() == null && this.getFechaCierreTambosTo() != null) {
			return false;
		}

		if (other.getFechaCierreTambosTo() != null && this.getFechaCierreTambosTo() == null) {
			return false;
		}

		if (other.getFechaCierreTambosTo() != null && this.getFechaCierreTambosTo() != null) {

			if (other.getFechaCierreTambosTo().equals(this.getFechaCierreTambosTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreRRHHFrom() == null && this.getFechaCierreRRHHFrom() != null) {
			return false;
		}

		if (other.getFechaCierreRRHHFrom() != null && this.getFechaCierreRRHHFrom() == null) {
			return false;
		}

		if (other.getFechaCierreRRHHFrom() != null && this.getFechaCierreRRHHFrom() != null) {

			if (other.getFechaCierreRRHHFrom().equals(this.getFechaCierreRRHHFrom()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		if (other.getFechaCierreRRHHTo() == null && this.getFechaCierreRRHHTo() != null) {
			return false;
		}

		if (other.getFechaCierreRRHHTo() != null && this.getFechaCierreRRHHTo() == null) {
			return false;
		}

		if (other.getFechaCierreRRHHTo() != null && this.getFechaCierreRRHHTo() != null) {

			if (other.getFechaCierreRRHHTo().equals(this.getFechaCierreRRHHTo()) == false) {
				return false;
			}

		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public EmpresaFilterQ1 clone() {

		EmpresaFilterQ1 other = new EmpresaFilterQ1();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());
		
		if(this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}				
		other.setFechaCierreVentasFrom(this.getFechaCierreVentasFrom());			
		other.setFechaCierreVentasTo(this.getFechaCierreVentasTo());			
		other.setFechaCierreStockFrom(this.getFechaCierreStockFrom());			
		other.setFechaCierreStockTo(this.getFechaCierreStockTo());			
		other.setFechaCierreFondoFrom(this.getFechaCierreFondoFrom());			
		other.setFechaCierreFondoTo(this.getFechaCierreFondoTo());			
		other.setFechaCierreComprasFrom(this.getFechaCierreComprasFrom());			
		other.setFechaCierreComprasTo(this.getFechaCierreComprasTo());			
		other.setFechaCierreContabilidadFrom(this.getFechaCierreContabilidadFrom());			
		other.setFechaCierreContabilidadTo(this.getFechaCierreContabilidadTo());			
		other.setFechaCierreGarantiaDevolucionesFrom(this.getFechaCierreGarantiaDevolucionesFrom());			
		other.setFechaCierreGarantiaDevolucionesTo(this.getFechaCierreGarantiaDevolucionesTo());			
		other.setFechaCierreTambosFrom(this.getFechaCierreTambosFrom());			
		other.setFechaCierreTambosTo(this.getFechaCierreTambosTo());			
		other.setFechaCierreRRHHFrom(this.getFechaCierreRRHHFrom());			
		other.setFechaCierreRRHHTo(this.getFechaCierreRRHHTo());			

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------