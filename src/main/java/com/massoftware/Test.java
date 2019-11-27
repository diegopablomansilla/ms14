package com.massoftware;

import java.util.Arrays;

import com.massoftware.a.model.CuentaJerarquia;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuentaJerarquia cuentaJerarquia = new CuentaJerarquia("91234567800", "91234560000");

		System.out.println("isNull = " + cuentaJerarquia.isNullError);
		System.out.println("isEmpty = " + cuentaJerarquia.isEmptyError);
		System.out.println("isLength11 = " + cuentaJerarquia.isLength11);
		System.out.println("chars.length = " + cuentaJerarquia.chars.length);
		System.out.println("isIntegraEqualsError = " + cuentaJerarquia.isIntegraEqualsError);

		System.out.println("p0 = [" + cuentaJerarquia.p0 + "], s0 = [" + cuentaJerarquia.s0 + "],  Is Number Error = "
				+ cuentaJerarquia.p0NumberError + ", Is Value Error = " + cuentaJerarquia.p0ValueError);
		System.out.println("p1 = [" + cuentaJerarquia.p1 + "], s1 = [" + cuentaJerarquia.s1 + "], Is Number Error = "
				+ cuentaJerarquia.p1NumberError + ", Is Value Error = " + cuentaJerarquia.p1ValueError);
		System.out.println("p2 = [" + cuentaJerarquia.p2 + "], s2 = [" + cuentaJerarquia.s2 + "], Is Number Error = "
				+ cuentaJerarquia.p2NumberError + ", Is Value Error = " + cuentaJerarquia.p2ValueError);
		System.out.println("p3 = [" + cuentaJerarquia.p3 + "], s3 = [" + cuentaJerarquia.s3 + "], Is Number Error = "
				+ cuentaJerarquia.p3NumberError + ", Is Value Error = " + cuentaJerarquia.p3ValueError);
		System.out.println("p4 = [" + cuentaJerarquia.p4 + "], s4 = [" + cuentaJerarquia.s4 + "], Is Number Error = "
				+ cuentaJerarquia.p4NumberError + ", Is Value Error = " + cuentaJerarquia.p4ValueError);
		System.out.println("p5 = [" + cuentaJerarquia.p5 + "], s5 = [" + cuentaJerarquia.s5 + "], Is Number Error = "
				+ cuentaJerarquia.p5NumberError + ", Is Value Error = " + cuentaJerarquia.p5ValueError);

		System.out.println("format = " + cuentaJerarquia.format);
		
		System.out.println("formatPositionsufix = " + cuentaJerarquia.formatPositionsufix);
		System.out.println("formatPrefixSufix = " + cuentaJerarquia.formatPrefixSufix);
		
		System.out.println("formatIntegra = " + cuentaJerarquia.formatIntegra);
		
		
		System.out.println("formatIntegraPrefixSufix = " + cuentaJerarquia.formatIntegraPrefixSufix);
		
		

	}

}
