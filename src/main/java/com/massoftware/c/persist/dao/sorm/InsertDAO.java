package com.massoftware.c.persist.dao.sorm;

import java.util.List;

import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;

public class InsertDAO {

	// ---------------------------------------------------------------------------------------------------------------------------

	private StmBuilderInsert builderStmInsert;

	// ---------------------------------------------------------------------------------------------------------------------------

	public InsertDAO() {
		builderStmInsert = new StmBuilderInsert();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean insertObject(ConnectionWrapper connection, Identifiable obj) throws Exception {
		return insertObject(connection, builderStmInsert
				.build(connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema(), obj));
	}

	@SuppressWarnings("rawtypes")
	public boolean insertObject(ConnectionWrapper connection, Identifiable obj, Class mappingClass) throws Exception {
		return insertObject(connection,
				builderStmInsert.build(
						connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema(), obj,
						mappingClass));
	}

	public boolean[] insertObjects(ConnectionWrapper connection, List<Identifiable> objs) throws Exception {

		if (objs == null) {
			throw new IllegalArgumentException("UPDATE: Se esperaba una lista de objetos no nulo.");
		}

		if (objs.size() == 0) {
			throw new IllegalArgumentException("UPDATE: Se esperaba una lista objetos no vacia.");
		}

		boolean[] r = new boolean[objs.size()];

		for (int i = 0; i < objs.size(); i++) {

			if (objs.get(i) == null) {
				throw new IllegalArgumentException("INSERT: Se esperaba una lista objetos, con objetos no nulos.");
			}

			r[i] = insertObject(connection, objs.get(i));
		}

		return r;

	}

	@SuppressWarnings("rawtypes")
	public boolean[] insertObjects(ConnectionWrapper connection, List<Identifiable> objs, Class mappingClass)
			throws Exception {

		if (objs == null) {
			throw new IllegalArgumentException("INSERT: Se esperaba una lista de objetos no nulo.");
		}

		if (objs.size() == 0) {
			throw new IllegalArgumentException("INSERT: Se esperaba una lista objetos no vacia.");
		}

		boolean[] r = new boolean[objs.size()];

		for (int i = 0; i < objs.size(); i++) {

			if (objs.get(i) == null) {
				throw new IllegalArgumentException("INSERT: Se esperaba una lista objetos, con objetos no nulos.");
			}

			r[i] = insertObject(connection, objs.get(i), mappingClass);
		}

		return r;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private boolean insertObject(ConnectionWrapper connection, Statement statement) throws Exception {

		Result result = connection.insert(statement.getSql(), statement.getArgs());

		if (result.getRowCount() != 1) {
			throw new IllegalStateException(
					"INSERT: No se esperaba que la sentencia no insertara en la base de datos.");
		}

		return true;
	}

} // END CLASS -----------------------------------------------------------------
