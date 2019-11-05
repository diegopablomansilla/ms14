package com.massoftware.c.persist.dao.sorm;

import java.sql.SQLException;
import java.util.List;

import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.DDLException;
import com.massoftware.c.persist.dao.ds.ex.DeleteException;
import com.massoftware.c.persist.dao.ds.ex.InsertException;
import com.massoftware.c.persist.dao.ds.ex.UpdateException;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;

public class DeleteDAO {

	// ---------------------------------------------------------------------------------------------------------------------------

	private StmBuilderDelete builderStm;

	// ---------------------------------------------------------------------------------------------------------------------------

	public DeleteDAO() {
		this.builderStm = new StmBuilderDelete();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	public boolean deleteAllObjects(ConnectionWrapper connection, Class mappingClass)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException {
		Statement statement = builderStm.build(mappingClass,
				connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema());
		connection.delete(statement.getSql());

		return true;
	}

	public boolean deleteObject(ConnectionWrapper connection, Identifiable obj)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException, Exception {
		return delete(connection, builderStm.build(obj,
				connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema()));
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteObjectById(ConnectionWrapper connection, String id, Class mappingClass)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException, Exception {
		return delete(connection, builderStm.build(id, mappingClass,
				connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema()));
	}

	public boolean[] deleteObjects(ConnectionWrapper connection, List<Identifiable> objs)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException, Exception {

		if (objs == null) {
			throw new IllegalArgumentException("DELETE: Se esperaba una lista de objetos no nulo.");
		}

		if (objs.size() == 0) {
			throw new IllegalArgumentException("DELETE: Se esperaba una lista objetos no vacia.");
		}

		boolean[] r = new boolean[objs.size()];

		for (int i = 0; i < objs.size(); i++) {

			if (objs.get(i) == null) {
				throw new IllegalArgumentException("DELETE: Se esperaba una lista id's, con id's no nulos.");
			}

			r[i] = deleteObject(connection, objs.get(i));
		}

		return r;

	}

	@SuppressWarnings("rawtypes")
	public boolean[] deleteObjectsById(ConnectionWrapper connection, List<String> ids, Class mappingClass)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException, Exception {

		if (ids == null) {
			throw new IllegalArgumentException("DELETE: Se esperaba una lista de id's no nulo.");
		}

		if (ids.size() == 0) {
			throw new IllegalArgumentException("DELETE: Se esperaba una lista id's no vacia.");
		}

		boolean[] r = new boolean[ids.size()];

		for (int i = 0; i < ids.size(); i++) {

			if (ids.get(i) == null) {
				throw new IllegalArgumentException("DELETE: Se esperaba una lista id's, con id's no nulos.");
			}

			r[i] = deleteObjectById(connection, ids.get(i), mappingClass);
		}

		return r;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private boolean delete(ConnectionWrapper connection, Statement statement)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException {

		Result result = connection.delete(statement.getSql(), statement.getArgs());

		if (result.getRowCount() == 0) {
			throw new IllegalStateException(
					"DELETE: No se esperaba que la sentencia no eliminara en la base de datos.");
		} else if (result.getRowCount() > 1) {
			throw new IllegalStateException(
					"DELETE: No se esperaba que la sentencia eliminara a mas de un registro en la base de datos. Registros: "
							+ result.getRowCount());
		}

		return true;

	}

} // END CLASS -----------------------------------------------------------------