package com.massoftware.ui;

public class GlobalProperties {

	private static String dataBaseKey = "massoftware";

	public synchronized static String getDataBaseKey() {
		return dataBaseKey;
	}

	public synchronized static void setDataBaseKey(String dataBaseKeyArg) {
		dataBaseKey = dataBaseKeyArg;
	}

}
