package com.massoftware.c.persist.dao.ds.info;

public class DataSourceInfo implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String dataBaseKey;
	private DataSourceMetaData dataSourceMetaData;
	private DataSourceProperties dataSourceProperties;

	// ---------------------------------------------------------------------------------------------------------------------------

	public DataSourceInfo(String dataBaseKey, DataSourceMetaData dataSourceMetaData, DataSourceProperties dataSourceProperties) {
		super();
		this.dataBaseKey = dataBaseKey;
		this.dataSourceMetaData = dataSourceMetaData;
		this.dataSourceProperties = dataSourceProperties;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public DataSourceMetaData getDataSourceMetaData() {
		return dataSourceMetaData;
	}

	public DataSourceProperties getDataSourceProperties() {
		return dataSourceProperties;
	}

	public void setDataSourceMetaData(DataSourceMetaData dataSourceMetaData) {
		this.dataSourceMetaData = dataSourceMetaData;
	}

	public void setDataSourceProperties(DataSourceProperties dataSourceProperties) {
		this.dataSourceProperties = dataSourceProperties;
	}
	
	public String getDataBaseKey() {
		return dataBaseKey;
	}

	public void setDataBaseKey(String dataBaseKey) {
		this.dataBaseKey = dataBaseKey;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	

	public String toString() {
		String s = "";

		s += "\n" + "Data base key: " + this.getDataBaseKey();
		
		if (getDataSourceMetaData() != null) {
			s += getDataSourceMetaData().toString();
		}

		if (getDataSourceProperties() != null) {
			s += getDataSourceProperties().toString();
		}

		return s;
	}

	public DataSourceInfo clone() {

		DataSourceMetaData dataSourceMetaData = (this.getDataSourceMetaData() != null)
				? this.getDataSourceMetaData().clone()
				: null;
		DataSourceProperties dataSourceProperties = (this.getDataSourceProperties() != null)
				? this.getDataSourceProperties().clone()
				: null;

		// -------------------------------------------------------------------

		return new DataSourceInfo(getDataBaseKey(), dataSourceMetaData, dataSourceProperties);

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------