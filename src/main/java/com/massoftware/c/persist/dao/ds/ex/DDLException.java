package com.massoftware.c.persist.dao.ds.ex;

import java.sql.SQLException;

import com.massoftware.c.persist.dao.ds.info.ConnectionInfo;
import com.massoftware.c.persist.dao.ds.info.Statement;

public class DDLException extends AbstractSQLExceptionWrapperConnection {

	private static final String OPERATION_TYPE_DDL = "DDL";
	private static final String TITLE_DDL = "Lenguaje de Definición de Datos ";
	private static final String SUBJECT_DDL = "CREATE | ALTER | DROP";

	public DDLException(SQLException sqlException, Statement statement, ConnectionInfo connectionInfo) {
		super(sqlException, OPERATION_TYPE_DDL, TITLE_DDL, SUBJECT_DDL, statement, connectionInfo);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8031219644209426597L;

} // END CLASS -----------------------------------------------------------------
