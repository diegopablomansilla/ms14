package com.massoftware.c.persist.dao.ds.info;

public class DataSourceProperties implements Cloneable {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String driverClassName = "unknown";
	private int initialSize = -1;
	private int maxActive = -1;
	private int maxIdle = -1;
	private String validationQuery = "unknown";
	private String url = "unknown";
	private String userName = "unknown";
	private String userPassword = "unknown";
	private boolean verbose = false;
	private String schema = "unknown";
	private boolean convertToJavaTimeValues = false;

	// ---------------------------------------------------------------------------------------------------------------------------

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public boolean isConvertToJavaTimeValues() {
		return convertToJavaTimeValues;
	}

	public void setConvertToJavaTimeValues(boolean convertToJavaTimeValues) {
		this.convertToJavaTimeValues = convertToJavaTimeValues;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		String s = "";

		s += "\n\tDriver class name:" + this.getDriverClassName() + "";
		s += "\n\tInitial size:" + this.getInitialSize() + "";
		s += "\n\tdMax active:" + this.getMaxActive() + "";
		s += "\n\tMax idle:" + this.getMaxIdle() + "";
		s += "\n\tValidation query:" + this.getValidationQuery() + "";
		s += "\n\tURL:" + this.getUrl() + "";
		s += "\n\tUser name:" + this.getUserName() + "";
		s += "\n\tUser password:" + "SECRET" + "";
		s += "\n\tverbose:" + this.isVerbose() + "";
		s += "\n\tSchema:" + this.getSchema() + "";
		s += "\n\tConvert to Java time values:" + this.isConvertToJavaTimeValues() + "";

		s += "\n";

		return s;
	}

	public DataSourceProperties clone() {

		DataSourceProperties other = new DataSourceProperties();

		other.setDriverClassName(this.getDriverClassName());
		other.setInitialSize(this.getInitialSize());
		other.setMaxActive(this.getMaxActive());
		other.setMaxIdle(this.getMaxIdle());
		other.setValidationQuery(this.getValidationQuery());
		other.setUrl(this.getUrl());
		other.setUserName(this.getUserName());
		other.setUserPassword(this.getUserPassword());
		other.setVerbose(this.isVerbose());
		other.setSchema(this.getSchema());
		other.setConvertToJavaTimeValues(this.isConvertToJavaTimeValues());

		// -------------------------------------------------------------------

		return other;

		// -------------------------------------------------------------------
	}

} // END CLASS -----------------------------------------------------------------