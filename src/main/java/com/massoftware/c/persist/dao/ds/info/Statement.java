package com.massoftware.c.persist.dao.ds.info;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class Statement implements Result {

	// ---------------------------------------------------------------------------------------------------------------------------

	private boolean executed = false;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private String sql;
	private Object[] args;
	private Long rowCount;
	private Object[][] table;
	private Integer columnCount;
	private String dataBase;
	private String connection;
	private String number;

	// ---------------------------------------------------------------------------------------------------------------------------

	public Statement() {
		super();
	}

	public Statement(String sql) {
		super();
		this.sql = sql;
	}

	public Statement(String sql, Object[] args) {
		this.sql = sql;

		if (args == null) {
			args = new Object[0];
		}

		this.args = args;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String getSql() {
		return sql;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Long getRowCount() {
		if (this.getTable() != null) {
			return (long) this.getTable().length;
		}
		return rowCount;
	}

	public Object[][] getTable() {
		return table;
	}

	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}

	public void setTable(Object[][] table) {
		this.table = table;
	}

	public Integer getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(Integer columnCount) {
		this.columnCount = columnCount;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Object[] getArgs() {
		if (args == null) {
			args = new Object[0];
		}
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public boolean addArg(Object newArg) {

		if (newArg == null) {
			return false;
		}

		if (args == null) {
			args = new Object[0];
		}

		Object[] args = new Object[this.args.length + 1];

		for (int i = 0; i < this.args.length; i++) {
			args[i] = this.args[i];
		}

		args[args.length - 1] = newArg;
		this.args = args;

		return true;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Duration getDuration() {
		if (startTime != null && endTime != null) {
			return Duration.between(startTime, endTime);
		}
		return null;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		String sepStart = "================================= SQL START =======================================";
		String sepEnd = "================================= SQL END   =======================================";
		String sep = "-----------------------------------------------------------------------------------";

		String s = "\n";

		s += "\n" + sepStart;

		s += "\n" + "[..] (" + getNumber() + ") " + "Data base: " + this.getDataBase() + ", Connection: "
				+ this.getConnection();
		s += "\n" + "Start time: " + this.getStartTime();
		s += "\n" + sep;
		s += "\n" + this.getSql();
		s += "\n" + sep;
		s += "\n" + "Args: " + Arrays.toString(args);
		s += "\n" + "Row count: " + this.getRowCount() + ", Column count: " + this.getColumnCount();
		s += "\n" + sep;

		s += "\n" + "End time: " + this.getEndTime() + ", Duration: " + this.getDuration();
		s += "\n[" + (this.isExecuted() ? "OK" : "ERROR") + "] (" + getNumber() + ") " + "Data base: "
				+ this.getDataBase() + ", Connection: " + this.getConnection();
		s += "\n" + sepEnd;

		return s;
	}

	public String toStringStart() {
		String sepStart = "================================= SQL START =======================================";
		String sep = "-----------------------------------------------------------------------------------";

		String s = "\n";

		s += "\n" + sepStart;

		s += "\n" + "[..] (" + getNumber() + ") " + "Data base: " + this.getDataBase() + ", Connection: "
				+ this.getConnection();
		s += "\n" + "Start time: " + this.getStartTime();
		s += "\n" + sep;
		s += "\n" + this.getSql();
		s += "\n" + sep;
		s += "\n" + "Args: " + Arrays.toString(args);

		return s;
	}

	public String toStringEnd() {

		String sepEnd = "================================= SQL END   =======================================";
		String sep = "-----------------------------------------------------------------------------------";

		String s = "";

		s += "\n" + "Row count: " + this.getRowCount() + ", Column count: " + this.getColumnCount();
		s += "\n" + sep;
		s += "\n" + "End time: " + this.getEndTime() + ", Duration: " + this.getDuration();
		s += "\n[" + (this.isExecuted() ? "OK" : "ERROR") + "] (" + getNumber() + ") " + "Data base: "
				+ this.getDataBase() + ", Connection: " + this.getConnection();
		s += "\n" + sepEnd;

		return s;
	}

	public String toStringTable() {
		String s = "\n\n";

		if (this.getTable() == null || this.getColumnCount() == null || this.getColumnCount() <= 0) {
			return "";
		}

		int[] columnsLength = new int[this.getColumnCount()];

		for (Object[] row : this.getTable()) {
			for (int j = 0; j < this.getColumnCount(); j++) {
				if (row[j] != null && columnsLength[j] < row[j].toString().length()) {
					columnsLength[j] = row[j].toString().length();
				}
			}
		}

		s += "\n" + "Table: ";

		s += "\n";

		for (int j = 0; j < this.getColumnCount(); j++) {
			String value = "" + j;

			if (value.length() < columnsLength[j]) {

				int chars = columnsLength[j] - value.length();

				for (int c = 0; c < chars; c++) {
					value += " ";
				}

			}

			s += "\t" + value;

		}

		s += "\n";

		for (int j = 0; j < this.getColumnCount(); j++) {
			String value = "";

			if (value.length() < columnsLength[j]) {

				int chars = columnsLength[j] - value.length();

				for (int c = 0; c < chars; c++) {
					value += "_";
				}

			} else {
				value += "_";
			}

			s += "\t" + value;

		}

//			s += "\n\t" + Arrays.toString(row);

		for (Object[] row : this.getTable()) {

			s += "\n";

			for (int j = 0; j < this.getColumnCount(); j++) {
				String value = "";

				if (row[j] != null) {
					value = row[j].toString();
				}

				if (value.length() < columnsLength[j]) {

					int chars = columnsLength[j] - value.length();

					for (int c = 0; c < chars; c++) {
						value += " ";
					}

				}

				s += "\t" + value;

			}

//			s += "\n\t" + Arrays.toString(row);
		}

		return s;
	}

} // END CLASS -----------------------------------------------------------------