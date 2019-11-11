package com.massoftware.c.persist.dao.ds.info;

import java.util.ArrayList;
import java.util.List;

public class ConnectionInfo {

	// ---------------------------------------------------------------------------------------------------------------------------

	private DataSourceInfo dataSourceInfo;
	private List<Statement> statements = new ArrayList<Statement>();

	// ---------------------------------------------------------------------------------------------------------------------------

	public ConnectionInfo(DataSourceInfo dataSourceInfo) {
		super();
		this.dataSourceInfo = dataSourceInfo;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public DataSourceInfo getDataSourceInfo() {
		return dataSourceInfo;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public boolean addStatement(Statement e) {

		if (dataSourceInfo.getDataSourceProperties().getStackStatementSize() > -1
				&& statements.size() >= dataSourceInfo.getDataSourceProperties().getStackStatementSize()) {
			statements = new ArrayList<Statement>();
		}

		e.setNumber(statements.size() + 1 + "");
		return statements.add(e);

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public String toString() {
		String s = "";

		if (dataSourceInfo != null) {
			s += dataSourceInfo.toString();
		}

//		s += "\n\n\t" + "Connection info statements history:\n";
//		if (statements != null) {
//			for(Statement stm : statements) {
//				s += stm.toString();
//			}
//		}

		return s;
	}

} // END CLASS -----------------------------------------------------------------