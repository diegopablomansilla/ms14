package com.massoftware.b.service.cuentacontable;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.EjercicioContable;
//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

public class CuentaContableFilterQ6 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Ejercicio
	private EjercicioContable ejercicioContable;

	// GET Integra
	private CuentaContable integra;

	// GET Cuenta de jerarquia
	private String cuentaJerarquia;

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable) {
		this.ejercicioContable = ejercicioContable;
	}

	// GET Integra
	public CuentaContable getIntegra() {
		return this.integra;
	}

	// SET Integra
	public void setIntegra(CuentaContable integra) {
		this.integra = integra;
	}

	// GET Cuenta de jerarquia
	public String getCuentaJerarquia() {
		return this.cuentaJerarquia;
	}

	// SET Cuenta de jerarquia
	public void setCuentaJerarquia(String cuentaJerarquia) {
		this.cuentaJerarquia = (cuentaJerarquia == null || cuentaJerarquia.trim().length() == 0) ? null
				: cuentaJerarquia.trim();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		CuentaContableFilterQ6 other = (CuentaContableFilterQ6) obj;

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

		return true;

		// -------------------------------------------------------------------
	}

	public CuentaContableFilterQ6 clone() {

		CuentaContableFilterQ6 other = new CuentaContableFilterQ6();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());

		if (this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}
		if (this.getIntegra() != null) {
			other.setIntegra(this.getIntegra().clone());
		}
		other.setCuentaJerarquia(this.getCuentaJerarquia());

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------