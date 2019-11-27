package com.massoftware.b.service.cuentacontable;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.CuentaJerarquia;

public class CuentaContableSaveCuentaJerarquiaIsIntegraEqualsErrorEx extends CuentaContableSaveEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1999950707096564034L;
	
	public CuentaJerarquia cj;

	public CuentaContableSaveCuentaJerarquiaIsIntegraEqualsErrorEx(CuentaContable cuentaContable, CuentaJerarquia cj) {
		super(cuentaContable);
		this.cj = cj;

	}

}
