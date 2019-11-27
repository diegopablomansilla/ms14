package com.massoftware.b.service.cuentacontable;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

import com.massoftware.a.model.EjercicioContable;

public class CuentaContableFilterQ3 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Ejercicio
	private EjercicioContable ejercicioContable;

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

		CuentaContableFilterQ1 other = (CuentaContableFilterQ1) obj;

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

	public CuentaContableFilterQ1 clone() {

		CuentaContableFilterQ1 other = new CuentaContableFilterQ1();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());

		if (this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}
		other.setCuentaJerarquia(this.getCuentaJerarquia());

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------