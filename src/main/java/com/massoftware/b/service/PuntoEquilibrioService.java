package com.massoftware.b.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBase;
import com.massoftware.c.persist.DataBases;
import com.massoftware.c.persist.dao.ds.ex.BeginException;
import com.massoftware.c.persist.dao.ds.ex.CommitException;
import com.massoftware.c.persist.dao.ds.ex.GetConnectionException;
import com.massoftware.c.persist.dao.ds.ex.RollBackException;

public class PuntoEquilibrioService {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String dataBaseKey;

	// ---------------------------------------------------------------------------------------------------------------------------

	public PuntoEquilibrioService(String dataBaseKey) {
		super();
		Objects.requireNonNull(dataBaseKey, "dataBaseKey is null!!");	
		this.dataBaseKey = dataBaseKey;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(PuntoEquilibrioFilterQ1 filter) throws Exception500 {
	
		try {
			Objects.requireNonNull(filter, "filter is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		DataBase dataBase = null;

		try {						

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

	public PuntoEquilibrio findById(String id) throws Exception500 {
		try {

			Objects.requireNonNull(id, "id is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		PuntoEquilibrioFilterQ1 filter = new PuntoEquilibrioFilterQ1();
		filter.setId(id);

		List<PuntoEquilibrio> items = find(filter);

		if (items.size() == 1) {
			return items.get(0);
		} else if (items.size() > 1) {
			try {
				throw new IllegalStateException(
						"La consulta retorno " + items.size() + ". Se esperaba un solo item.");
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

		return null;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<PuntoEquilibrio> find(PuntoEquilibrioFilterQ1 filter) throws Exception500 {
	
		try {
			Objects.requireNonNull(filter, "filter is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		DataBase dataBase = null;

		try {					

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
	
		try {
			Objects.requireNonNull(id, "id is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}		

		DataBase dataBase = null;

		try {					
			
			id = id.trim();

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			dataBase.beginTransaction();

			// ---------------------------------------------------------------------------------------------------------------------------

			boolean b = dataBase.deleteObjectById(id, PuntoEquilibrio.class);
			if (b == false) {
				throw new IllegalStateException(
						"No se pudo borrar el " + PuntoEquilibrio.class.getCanonicalName() + " " + id);
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

	public PuntoEquilibrio update(PuntoEquilibrio obj) throws Exception500 {
	
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
						"No se pudo actualizar el " + PuntoEquilibrio.class.getCanonicalName() + " " + obj.getId());
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

	public PuntoEquilibrio save(PuntoEquilibrio obj) throws Exception500 {
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

	public PuntoEquilibrio insert(PuntoEquilibrio obj) throws Exception500 {
	
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
						"No se pudo actualizar el " + PuntoEquilibrio.class.getCanonicalName() + " " + obj.getId());
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