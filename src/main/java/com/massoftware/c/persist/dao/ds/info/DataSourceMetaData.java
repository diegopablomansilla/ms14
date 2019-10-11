package com.massoftware.c.persist.dao.ds.info;

public class DataSourceMetaData implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String url = "unknown";
	private String userName = "unknown";
	private String databaseProductName = "unknown";
	private String databaseProductVersion = "unknown";
	private String driverName = "unknown";
	private String driverVersion = "unknown";
	private String jDBCMajorVersion = "unknown";
	private String jDBCMinorVersion = "unknown";

	// ---------------------------------------------------------------------------------------------------------------------------

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDatabaseProductName() {
		return databaseProductName;
	}

	public void setDatabaseProductName(String databaseProductName) {
		this.databaseProductName = databaseProductName;
	}

	public String getDatabaseProductVersion() {
		return databaseProductVersion;
	}

	public void setDatabaseProductVersion(String databaseProductVersion) {
		this.databaseProductVersion = databaseProductVersion;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}

	public String getjDBCMajorVersion() {
		return jDBCMajorVersion;
	}

	public void setjDBCMajorVersion(String jDBCMajorVersion) {
		this.jDBCMajorVersion = jDBCMajorVersion;
	}

	public String getjDBCMinorVersion() {
		return jDBCMinorVersion;
	}

	public void setjDBCMinorVersion(String jDBCMinorVersion) {
		this.jDBCMinorVersion = jDBCMinorVersion;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean isPostgreSql() {
		return getDatabaseProductName().equals("PostgreSQL");
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		String s = "";

		s += "\n\turl:" + url + "";
		s += "\n\tuserName:" + userName + "";
		s += "\n\tdatabaseProductName:" + databaseProductName + "";
		s += "\n\tdatabaseProductVersion:" + databaseProductVersion + "";
		s += "\n\tdriverName:" + driverName + "";
		s += "\n\tdriverVersion:" + driverVersion + "";
		s += "\n\tjDBCMajorVersion:" + jDBCMajorVersion + "";
		s += "\n\tjDBCMinorVersion:" + jDBCMinorVersion + "";

		s += "\n";

		return s;
	}

	public DataSourceMetaData clone() {

		DataSourceMetaData other = new DataSourceMetaData();

		other.setUrl(this.getUrl());
		other.setUserName(this.getUserName());
		other.setDatabaseProductName(this.getDatabaseProductName());
		other.setDatabaseProductVersion(this.getDatabaseProductVersion());
		other.setDriverName(this.getDriverName());
		other.setDriverVersion(this.getDriverVersion());
		other.setjDBCMajorVersion(this.getjDBCMajorVersion());
		other.setjDBCMinorVersion(this.getjDBCMinorVersion());

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------
