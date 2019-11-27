package com.massoftware.b.service.cuentacontable;

//import com.massoftware.a.model.*;
import com.massoftware.b.service.util.GenericFilter;

public class CuentaContableFilterQ2 extends GenericFilter {

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean equals(Object obj) {

		if (super.equals(obj) == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		// -------------------------------------------------------------------

		return true;

		// -------------------------------------------------------------------
	}

	public CuentaContableFilterQ2 clone() {

		CuentaContableFilterQ2 other = new CuentaContableFilterQ2();

		other.setId(this.getId());
		other.setFts(this.getFts());
		other.setOffset(this.getOffset());
		other.setLimit(this.getLimit());
		other.setOrderBy(this.getOrderBy());
		other.setOrderByDesc(this.getOrderByDesc());

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------