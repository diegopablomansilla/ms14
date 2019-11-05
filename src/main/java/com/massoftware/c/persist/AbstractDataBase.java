package com.massoftware.c.persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.c.persist.dao.PPDAO;
import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.BeginException;
import com.massoftware.c.persist.dao.ds.ex.CloseException;
import com.massoftware.c.persist.dao.ds.ex.CommitException;
import com.massoftware.c.persist.dao.ds.ex.DDLException;
import com.massoftware.c.persist.dao.ds.ex.DeleteException;
import com.massoftware.c.persist.dao.ds.ex.InsertException;
import com.massoftware.c.persist.dao.ds.ex.RollBackException;
import com.massoftware.c.persist.dao.ds.ex.UpdateException;
import com.massoftware.c.persist.dao.ds.info.ConnectionInfo;
import com.massoftware.c.persist.dao.sorm.DeleteDAO;
import com.massoftware.c.persist.dao.sorm.Identifiable;
import com.massoftware.c.persist.dao.sorm.InsertDAO;
import com.massoftware.c.persist.dao.sorm.UpdateDAO;
import com.massoftware.c.persist.dao.util.SourceSQL;

public abstract class AbstractDataBase {

	// ---------------------------------------------------------------------------------------------------------------------------

	protected SourceSQL sourceSQL;
	protected ConnectionWrapper connection;

	// ---------------------------------------------------------------------------------------------------------------------------

	private PPDAO ppDAO;
	private UpdateDAO updateDAO;
	private InsertDAO insertDAO;
	private DeleteDAO deleteDAO;

	// ---------------------------------------------------------------------------------------------------------------------------

	protected AbstractDataBase(SourceSQL sourceSQL, ConnectionWrapper connection) {
		super();

		this.sourceSQL = sourceSQL;
		this.connection = connection;

		ppDAO = new PPDAO();

		updateDAO = new UpdateDAO();
		insertDAO = new InsertDAO();
		deleteDAO = new DeleteDAO();

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void disconnect() throws CloseException {
		this.connection.closeConnection();
	}

	public ConnectionInfo getConnectionInfo() {
		return connection.getConnectionInfo();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void beginTransaction() throws BeginException {
		this.connection.beginTransaction();
	}

	public void commitTransaction() throws CommitException {
		this.connection.commitTransaction();
	}

	public void rollBackTransaction() throws RollBackException {
		this.connection.rollBackTransaction();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void pp() throws Exception {
		ppDAO.pp(connection);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean insertObject(Object obj) throws Exception {
		if (obj instanceof Identifiable == false) {
			throw new IllegalArgumentException(
					"INSERT: Se esperaba un objeto tipo " + Identifiable.class.getSimpleName());
		}
		return insertDAO.insertObject(connection, (Identifiable) obj);
	}

	@SuppressWarnings("rawtypes")
	public boolean insertObject(Object obj, Class mappingClass) throws Exception {
		if (obj instanceof Identifiable == false) {
			throw new IllegalArgumentException(
					"INSERT: Se esperaba un objeto tipo " + Identifiable.class.getSimpleName());
		}
		return insertDAO.insertObject(connection, (Identifiable) obj, mappingClass);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean[] insertObjects(List objs) throws Exception {
		return insertDAO.insertObjects(connection, objs);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean[] insertObjects(List objs, Class mappingClass) throws Exception {
		return insertDAO.insertObjects(connection, objs, mappingClass);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean updateObject(Object obj) throws Exception {
		if (obj instanceof Identifiable == false) {
			throw new IllegalArgumentException(
					"UPDATE: Se esperaba un objeto tipo " + Identifiable.class.getSimpleName());
		}
		return updateDAO.updateObject(connection, (Identifiable) obj);
	}

	@SuppressWarnings("rawtypes")
	public boolean updateObject(Object obj, Class mappingClass) throws Exception {
		if (obj instanceof Identifiable == false) {
			throw new IllegalArgumentException(
					"UPDATE: Se esperaba un objeto tipo " + Identifiable.class.getSimpleName());
		}
		return updateDAO.updateObject(connection, (Identifiable) obj, mappingClass);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean[] updateObjects(List objs) throws Exception {
		return updateDAO.updateObjects(connection, objs);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean[] updateObjects(List objs, Class mappingClass) throws Exception {
		return updateDAO.updateObjects(connection, objs, mappingClass);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean deleteObject(Object obj) throws Exception {
		if (obj instanceof Identifiable == false) {
			throw new IllegalArgumentException(
					"DELETE: Se esperaba un objeto tipo " + Identifiable.class.getSimpleName());
		}
		return deleteDAO.deleteObject(connection, (Identifiable) obj);
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteObjectById(String id, Class mappingClass)
			throws InsertException, UpdateException, DeleteException, DDLException, SQLException, Exception {
		return deleteDAO.deleteObjectById(connection, id, mappingClass);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean[] deleteObjects(List objs) throws Exception {
		return deleteDAO.deleteObjects(connection, objs);
	}

	@SuppressWarnings({ "rawtypes" })
	public boolean[] deleteObjectsById(List<String> ids, Class mappingClass) throws Exception {
		return deleteDAO.deleteObjectsById(connection, ids, mappingClass);
	}

	@SuppressWarnings("rawtypes")
	public boolean deleteAllObjects(Class mappingClass) throws Exception {
		return deleteDAO.deleteAllObjects(connection, mappingClass);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	@SuppressWarnings("rawtypes")
	public List<String> utilExtractsIds(List objs) {

		if (objs == null) {
			throw new IllegalArgumentException("Se esperaba una lista de objetos no nulo.");
		}

		if (objs.size() == 0) {
			throw new IllegalArgumentException("Se esperaba una lista objetos no vacia.");
		}

		List<String> ids = new ArrayList<String>();

		for (Object obj : objs) {

			if (obj == null) {
				throw new IllegalArgumentException("Se esperaba una lista objetos con objetos no nulos.");
			}

			if (obj != null && obj instanceof Identifiable && ((Identifiable) obj).getId() != null
					&& ((Identifiable) obj).getId().trim().isEmpty() == false) {
				ids.add(((Identifiable) obj).getId());
			}
		}

		return ids;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	// fill rigthLevel
	// mejorar el isList
	// implementar DML por atributos
	// mejorar el batch en dsw

	// save

	// findById

	// todo
	// repository CRUD

	// sacar Identifiable, buscar un getId y setId con String solito
	// agregarle wehere a los fill
	// hacer un mapperorder

} // END CLASS -----------------------------------------------------------------