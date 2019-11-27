package com.massoftware.b.service.cuentacontable;

import com.massoftware.a.model.EjercicioContable;
//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

public class CuentaContableFilterQ4 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Cuenta contable
	private String codigo;

	// GET Ejercicio
	private EjercicioContable ejercicioContable;

	// ---------------------------------------------------------------------------------------------------------------------------

	// GET Cuenta contable
	public String getCodigo() {
		return this.codigo;
	}

	// SET Cuenta contable
	public void setCodigo(String codigo) {
		this.codigo = (codigo == null || codigo.trim().length() == 0) ? null : codigo.trim();
	}

	// GET Ejercicio
	public EjercicioContable getEjercicioContable() {
		return this.ejercicioContable;
	}

	// SET Ejercicio
	public void setEjercicioContable(EjercicioContable ejercicioContable) {
		this.ejercicioContable = ejercicioContable;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		CuentaContableFilterQ4 other = (CuentaContableFilterQ4) obj;

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

		return true;

		// -------------------------------------------------------------------
	}

	public CuentaContableFilterQ4 clone() {

		CuentaContableFilterQ4 other = new CuentaContableFilterQ4();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());

		other.setCodigo(this.getCodigo());
		if (this.getEjercicioContable() != null) {
			other.setEjercicioContable(this.getEjercicioContable().clone());
		}

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------