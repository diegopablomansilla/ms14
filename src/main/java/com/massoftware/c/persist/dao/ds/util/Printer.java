package com.massoftware.c.persist.dao.ds.util;

public interface Printer extends Cloneable {

	public void print(String s);
	
	public Printer clone();

}
