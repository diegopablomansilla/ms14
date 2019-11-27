package com.massoftware.b.service.cuentacontable;

import com.massoftware.a.model.CuentaContable;

public class CuentaContableSaveEx extends Exception {

	private CuentaContable cuentaContable;

	public CuentaContableSaveEx(CuentaContable cuentaContable) {
		super();
		this.cuentaContable = cuentaContable;
	}

	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8947465985803229963L;

}
