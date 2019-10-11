package com.massoftware.c.persist.dao.ds.util;

public class PrinterImpl implements Printer {

	public void print(String s) {
		System.out.println(s);
	}

	public Printer clone() {
		return new PrinterImpl();
	}

}
