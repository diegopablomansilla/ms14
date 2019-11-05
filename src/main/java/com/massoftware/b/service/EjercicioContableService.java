package com.massoftware.b.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBase;
import com.massoftware.c.persist.DataBases;
import com.massoftware.c.persist.dao.ds.ex.BeginException;
import com.massoftware.c.persist.dao.ds.ex.CommitException;
import com.massoftware.c.persist.dao.ds.ex.GetConnectionException;
import com.massoftware.c.persist.dao.ds.ex.RollBackException;

public class EjercicioContableService {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String dataBaseKey;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableService(String dataBaseKey) {
		super();
		Objects.requireNonNull(dataBaseKey, "dataBaseKey is null!!");
		this.dataBaseKey = dataBaseKey;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(EjercicioContableFilterQ1 filter) throws Exception500 {

		DataBase dataBase = null;

		try {

			Objects.requireNonNull(filter, "filter is null!!");

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.count(filter);

		} catch (Exception e) {
			throw new Exception500(e);
		} finally {
			try {
				if (dataBase != null) {
					dataBase.disconnect();
				}
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContable findById(String id) throws Exception500 {
		try {

			Objects.requireNonNull(id, "id is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		EjercicioContableFilterQ1 filter = new EjercicioContableFilterQ1();
		filter.setId(id);

		List<EjercicioContable> items = find(filter);

		if (items.size() == 1) {
			return items.get(0);
		} else if (items.size() > 1) {
			try {
				throw new IllegalStateException("La consulta retorno " + items.size() + ". Se esperaba un solo item.");
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

		return null;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public List<EjercicioContable> find(EjercicioContableFilterQ1 filter) throws Exception500 {

		DataBase dataBase = null;

		try {

			Objects.requireNonNull(filter, "filter is null!!");

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.find(filter);

		} catch (Exception e) {
			throw new Exception500(e);
		} finally {
			try {
				if (dataBase != null) {
					dataBase.disconnect();
				}
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean deleteById(String id) throws Exception500 {

		DataBase dataBase = null;

		try {

			Objects.requireNonNull(id, "id is null!!");

			id = id.trim();

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			dataBase.beginTransaction();

			// ---------------------------------------------------------------------------------------------------------------------------

			boolean b = dataBase.deleteObjectById(id, EjercicioContable.class);
			if (b == false) {
				throw new IllegalStateException(
						"No se pudo borrar el " + EjercicioContable.class.getCanonicalName() + " " + id);
			}

			// ---------------------------------------------------------------------------------------------------------------------------

			dataBase.commitTransaction();

		} catch (GetConnectionException e) {
			throw new Exception500(e);
		} catch (BeginException e) {
			throw new Exception500(e);
		} catch (CommitException e) {
			throw new Exception500(e);
		} catch (Exception e) {
			try {
				dataBase.rollBackTransaction();
			} catch (RollBackException e1) {
				throw new Exception500(e1);
			}
			throw new Exception500(e);
		} finally {
			try {
				if (dataBase != null) {
					dataBase.disconnect();
				}
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

		return true;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContable update(EjercicioContable obj) throws Exception500 {

		try {
			Objects.requireNonNull(obj, "obj is null!!");
			Objects.requireNonNull(obj.getId(), "id is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			dataBase.beginTransaction();

			// ---------------------------------------------------------------------------------------------------------------------------

			boolean b = dataBase.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException(
						"No se pudo actualizar el " + EjercicioContable.class.getCanonicalName() + " " + obj.getId());
			}

			// ---------------------------------------------------------------------------------------------------------------------------

			dataBase.commitTransaction();

		} catch (GetConnectionException e) {
			throw new Exception500(e);
		} catch (BeginException e) {
			throw new Exception500(e);
		} catch (CommitException e) {
			throw new Exception500(e);
		} catch (Exception e) {
			try {
				dataBase.rollBackTransaction();
			} catch (RollBackException e1) {
				throw new Exception500(e1);
			}
			throw new Exception500(e);
		} finally {
			try {
				if (dataBase != null) {
					dataBase.disconnect();
				}
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

		return obj;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContable save(EjercicioContable obj) throws Exception500 {
		try {
			Objects.requireNonNull(obj, "obj is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}
		
		if(obj.getId() == null) {
			return insert(obj);
		} 
		
		return update(obj);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContable insert(EjercicioContable obj) throws Exception500 {

		try {
			Objects.requireNonNull(obj, "obj is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		obj.setId(UUID.randomUUID().toString());

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			dataBase.beginTransaction();

			// ---------------------------------------------------------------------------------------------------------------------------

			boolean b = dataBase.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException(
						"No se pudo crear el " + EjercicioContable.class.getCanonicalName() + " " + obj.getId());
			}

			// ---------------------------------------------------------------------------------------------------------------------------

			dataBase.commitTransaction();

		} catch (GetConnectionException e) {
			throw new Exception500(e);
		} catch (BeginException e) {
			throw new Exception500(e);
		} catch (CommitException e) {
			throw new Exception500(e);
		} catch (Exception e) {
			try {
				dataBase.rollBackTransaction();
			} catch (RollBackException e1) {
				throw new Exception500(e1);
			}
			throw new Exception500(e);
		} finally {
			try {
				if (dataBase != null) {
					dataBase.disconnect();
				}
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

		return obj;

	}

} // END CLASS -----------------------------------------------------------------