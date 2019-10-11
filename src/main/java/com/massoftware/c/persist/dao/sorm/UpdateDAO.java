package com.massoftware.c.persist.dao.sorm;

import java.util.List;

import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.info.Result;
import com.massoftware.c.persist.dao.ds.info.Statement;

public class UpdateDAO {
	
	// ---------------------------------------------------------------------------------------------------------------------------

	private StmBuilderUpdate builderStmUpdate;
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public UpdateDAO() {
		builderStmUpdate = new StmBuilderUpdate();
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean updateObject(ConnectionWrapper connection, Identifiable obj) throws Exception {
		return updateObject(connection, builderStmUpdate
				.build(connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema(), obj));
	}

	@SuppressWarnings("rawtypes")
	public boolean updateObject(ConnectionWrapper connection, Identifiable obj, Class mappingClass) throws Exception {
		return updateObject(connection,
				builderStmUpdate.build(
						connection.getConnectionInfo().getDataSourceInfo().getDataSourceProperties().getSchema(), obj,
						mappingClass));
	}

	public boolean[] updateObjects(ConnectionWrapper connection, List<Identifiable> objs) throws Exception {

		if (objs == null) {
			throw new IllegalArgumentException("UPDATE: Se esperaba una lista de objetos no nulo.");
		}

		if (objs.size() == 0) {
			throw new IllegalArgumentException("UPDATE: Se esperaba una lista objetos no vacia.");
		}

		boolean[] r = new boolean[objs.size()];

		for (int i = 0; i < objs.size(); i++) {

			if (objs.get(i) == null) {
				throw new IllegalArgumentException("UPDATE: Se esperaba una lista objetos, con objetos no nulos.");
			}

			r[i] = updateObject(connection, objs.get(i));
		}

		return r;

	}

	@SuppressWarnings("rawtypes")
	public boolean[] updateObjects(ConnectionWrapper connection, List<Identifiable> objs, Class mappingClass)
			throws Exception {

		if (objs == null) {
			throw new IllegalArgumentException("UPDATE: Se esperaba una lista de objetos no nulo.");
		}

		if (objs.size() == 0) {
			throw new IllegalArgumentException("UPDATE: Se esperaba una lista objetos no vacia.");
		}

		boolean[] r = new boolean[objs.size()];

		for (int i = 0; i < objs.size(); i++) {

			if (objs.get(i) == null) {
				throw new IllegalArgumentException("UPDATE: Se esperaba una lista objetos, con objetos no nulos.");
			}

			r[i] = updateObject(connection, objs.get(i), mappingClass);
		}

		return r;

	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	private boolean updateObject(ConnectionWrapper connection, Statement statement) throws Exception {

		Result result = connection.update(statement.getSql(), statement.getArgs());

		if (result.getRowCount() == 0) {
			throw new IllegalStateException(
					"UPDATE: No se esperaba que la sentencia no actualizara en la base de datos.");
		} else if (result.getRowCount() > 1) {
			throw new IllegalStateException(
					"UPDATE: No se esperaba que la sentencia actualizara a mas de un registro en la base de datos. Registros: "
							+ result.getRowCount());
		}

		return true;

	}

} // END CLASS -----------------------------------------------------------------
