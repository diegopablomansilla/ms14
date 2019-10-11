package com.massoftware.c.persist.dao.sorm;

import com.massoftware.c.persist.dao.ds.info.Statement;

class StmBuilderDelete extends AbstractStmBuilder {
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public StmBuilderDelete() {
		super();
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public Statement build(Identifiable obj, String schema) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("DELETE: Se esperaba un objeto no nulo.");
		}

//		if (obj instanceof Identifiable == false) {
//			throw new IllegalArgumentException(
//					"DELETE: Se esperaba un objeto con tipo " + Identifiable.class.getSimpleName());
//		}

		return build(obj.getId(), obj.getClass(), schema);

	}

	@SuppressWarnings("rawtypes")
	public Statement build(String id, Class mappingClass, String schema) throws Exception {

		if (id == null) {
			throw new IllegalArgumentException("DELETE: Se esperaba un id no nulo.");
		}

		id = id.trim();

		if (id.isEmpty()) {
			throw new IllegalArgumentException("DELETE: Se esperaba un id no vacio.");
		}

		if (mappingClass == null) {
			throw new IllegalArgumentException("DELETE: Se esperaba una objeto Class (para el mapeo) no nulo.");
		}

		// if (isPersistent(mappingClass) == false) {
		// throw new IllegalArgumentException(
		// "DELETE: Se esperaba un objeto Class anotado con " +
		// PersistentMapping.class.getCanonicalName());
		// }

		Statement statement = new Statement();

		statement.addArg(id);

		statement.setSql("DELETE FROM " + schema + "." + mappingClass.getSimpleName() + " WHERE id = ?");

		return statement;

	}

	@SuppressWarnings("rawtypes")
	public Statement build(Class mappingClass, String schema) throws Exception {

		if (mappingClass == null) {
			throw new IllegalArgumentException("DELETE: Se esperaba una objeto Class (para el mapeo) no nulo.");
		}

		// if (isPersistent(mappingClass) == false) {
		// throw new IllegalArgumentException(
		// "DELETE: Se esperaba un objeto Class anotado con " +
		// PersistentMapping.class.getCanonicalName());
		// }

		Statement statement = new Statement();

		statement.setSql("DELETE FROM " + schema + "." + mappingClass.getSimpleName());

		return statement;

	}

} // END CLASS -----------------------------------------------------------------