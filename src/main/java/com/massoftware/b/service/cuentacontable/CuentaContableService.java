package com.massoftware.b.service.cuentacontable;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.CuentaJerarquia;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBase;
import com.massoftware.c.persist.DataBases;
import com.massoftware.c.persist.dao.ds.ex.BeginException;
import com.massoftware.c.persist.dao.ds.ex.CommitException;
import com.massoftware.c.persist.dao.ds.ex.GetConnectionException;
import com.massoftware.c.persist.dao.ds.ex.RollBackException;

public class CuentaContableService {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String dataBaseKey;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableService(String dataBaseKey) {
		super();
		Objects.requireNonNull(dataBaseKey, "dataBaseKey is null!!");
		this.dataBaseKey = dataBaseKey;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(CuentaContableFilterQ1 filter) throws Exception500 {

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

	public boolean exists(CuentaContableFilterQ4 filter) throws Exception500 {

		try {
			Objects.requireNonNull(filter, "filter is null!!");
			Objects.requireNonNull(filter.getEjercicioContable(), "filter ejercicioContable is null!!");
			Objects.requireNonNull(filter.getEjercicioContable().getId(), "filter ejercicioContable.id is null!!");
			Objects.requireNonNull(filter.getCodigo(), "filter codigo is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.exists(filter);

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

	public boolean exists(CuentaContableFilterQ5 filter) throws Exception500 {

		try {
			Objects.requireNonNull(filter, "filter is null!!");
			Objects.requireNonNull(filter.getEjercicioContable(), "filter ejercicioContable is null!!");
			Objects.requireNonNull(filter.getEjercicioContable().getId(), "filter ejercicioContable.id is null!!");
			Objects.requireNonNull(filter.getNombre(), "filter nombre is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.exists(filter);

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

	public boolean exists(CuentaContableFilterQ6 filter) throws Exception500 {

		try {
			Objects.requireNonNull(filter, "filter is null!!");
			Objects.requireNonNull(filter.getEjercicioContable(), "filter ejercicioContable is null!!");
			Objects.requireNonNull(filter.getEjercicioContable().getId(), "filter ejercicioContable.id is null!!");
//			Objects.requireNonNull(filter.getIntegra(), "filter Integra is null!!");
//			Objects.requireNonNull(filter.getIntegra().getId(), "filter integra.id is null!!");
			Objects.requireNonNull(filter.getCuentaJerarquia(), "filter cuentaJerarquia is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.exists(filter);

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

	public CuentaContable findOne(CuentaContableFilterQ3 filter) throws Exception500 {
		try {

			Objects.requireNonNull(filter, "filter is null!!");
			Objects.requireNonNull(filter.getEjercicioContable(), "ejercicioContable is null!!");
			Objects.requireNonNull(filter.getEjercicioContable().getId(), "ejercicioContable.id is null!!");
			Objects.requireNonNull(filter.getCuentaJerarquia(), "cuentaJerarquia is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		List<CuentaContable> items = find(filter);

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

	public CuentaContable findById(String id) throws Exception500 {
		try {

			Objects.requireNonNull(id, "id is null!!");
		} catch (Exception e) {
			throw new Exception500(e);
		}

		CuentaContableFilterQ2 filter = new CuentaContableFilterQ2();
		filter.setId(id);

		List<CuentaContable> items = find(filter);

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

	private List<CuentaContable> find(CuentaContableFilterQ3 filter) throws Exception500 {

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
			e.printStackTrace();
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

	private List<CuentaContable> find(CuentaContableFilterQ2 filter) throws Exception500 {

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
			e.printStackTrace();
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

	public List<CuentaContable> find(CuentaContableFilterQ1 filter) throws Exception500 {

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

			boolean b = dataBase.deleteObjectById(id, CuentaContable.class);
			if (b == false) {
				throw new IllegalStateException(
						"No se pudo borrar el " + CuentaContable.class.getCanonicalName() + " " + id);
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

	private CuentaContable update(CuentaContable obj) throws Exception500 {

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
						"No se pudo actualizar el " + CuentaContable.class.getCanonicalName() + " " + obj.getId());
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

	private CuentaContable insert(CuentaContable obj) throws Exception500 {

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
						"No se pudo actualizar el " + CuentaContable.class.getCanonicalName() + " " + obj.getId());
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

	public CuentaContable save(CuentaContable obj) throws Exception500, CuentaContableSaveCodigoExistsEx,
			CuentaContableSaveNombreExistsEx, CuentaContableSaveCuentaJerarquiaExistsEx,
			CuentaContableSaveIntegraNotExistsEx, CuentaContableSaveCuentaJerarquiaIsNullEx,
			CuentaContableSaveCuentaJerarquiaIsEmptyEx, CuentaContableSaveCuentaJerarquiaIsLengthMinor11ErrorEx,
			CuentaContableSaveCuentaJerarquiaIsLengthMayor11ErrorEx,
			CuentaContableSaveCuentaJerarquiaIsCharsNotNumberErrorEx, CuentaContableSaveCuentaJerarquiaIsValueErrorEx,
			CuentaContableSaveCuentaJerarquiaIsIntegraEqualsErrorEx, CuentaContableSaveCodigoIsNullEx,
			CuentaContableSaveNombreIsNullEx, CuentaContableSaveCodigoIsLengthMayor11ErrorEx,
			CuentaContableSaveNombreIsLengthMayor50ErrorEx, CuentaContableSaveEjercicioContableIsNullEx,
			CuentaContableSaveIsNullEx {

		// ----------------------------------------------------------------------
		// Validar nulos, largos, maximos, formatos, unique, etc.

		// ------------

		if (obj == null) {
			throw new CuentaContableSaveIsNullEx(obj);
		}

		if (obj.getEjercicioContable() == null) {
			throw new CuentaContableSaveEjercicioContableIsNullEx(obj);
		}

		if (obj.getEjercicioContable().getId() == null) {
			throw new CuentaContableSaveEjercicioContableIsNullEx(obj);
		}

		// ------------

		CuentaJerarquia cj = new CuentaJerarquia(obj.getCuentaJerarquia(),
				(obj.getIntegra() != null ? obj.getIntegra().getCuentaJerarquia() : null));

		if (cj.isError()) {
			// exeption por cada error

			if (cj.isNullError) {
				throw new CuentaContableSaveCuentaJerarquiaIsNullEx(obj);
			}

			if (cj.isEmptyError) {
				throw new CuentaContableSaveCuentaJerarquiaIsEmptyEx(obj);
			}

			if (cj.isLengthMinor11Error) {
				throw new CuentaContableSaveCuentaJerarquiaIsLengthMinor11ErrorEx(obj);
			}

			if (cj.isLengthMayor11Error) {
				throw new CuentaContableSaveCuentaJerarquiaIsLengthMayor11ErrorEx(obj);
			}

			if (cj.isCharsNotNumberError) {
				throw new CuentaContableSaveCuentaJerarquiaIsCharsNotNumberErrorEx(obj);
			}

			if (cj.isValueError) {
				throw new CuentaContableSaveCuentaJerarquiaIsValueErrorEx(obj);
			}

			if (cj.isIntegraEqualsError) {
				throw new CuentaContableSaveCuentaJerarquiaIsIntegraEqualsErrorEx(obj, cj);
			}
		}

		if (obj.getIntegra() == null && cj.integraCompute.equals("00000000000") == false) {

			CuentaContableFilterQ3 filter = new CuentaContableFilterQ3();
			filter.setEjercicioContable(obj.getEjercicioContable());
			filter.setCuentaJerarquia(cj.integraCompute);
			CuentaContable cuentaContableIntegra = findOne(filter);
			if (cuentaContableIntegra == null) {
				// exception la cuenta integra no existe
				throw new CuentaContableSaveIntegraNotExistsEx(obj);
			}
		}

		CuentaContableFilterQ6 filterCuentaJerarquia = new CuentaContableFilterQ6();
		filterCuentaJerarquia.setId(obj.getId());
		filterCuentaJerarquia.setEjercicioContable(obj.getEjercicioContable());
		filterCuentaJerarquia.setIntegra(obj.getIntegra());
		filterCuentaJerarquia.setCuentaJerarquia(obj.getCuentaJerarquia());
		if (exists(filterCuentaJerarquia) == false) {
			// exception la cuentaJerarquia ya existe
			throw new CuentaContableSaveCuentaJerarquiaExistsEx(obj);
		}

		// ------------

		if (obj.getCodigo() == null) {
			throw new CuentaContableSaveCodigoIsNullEx(obj);
		}

		if (obj.getCodigo().length() > 11) {
			throw new CuentaContableSaveCodigoIsLengthMayor11ErrorEx(obj);
		}

		CuentaContableFilterQ4 filterCodigoExists = new CuentaContableFilterQ4();
		filterCodigoExists.setId(obj.getId());
		filterCodigoExists.setEjercicioContable(obj.getEjercicioContable());
		filterCodigoExists.setCodigo(obj.getCodigo());
		if (exists(filterCodigoExists) == false) {
			// exception el codigo ya existe
			throw new CuentaContableSaveCodigoExistsEx(obj);
		}

		// ------------

		if (obj.getNombre() == null) {
			throw new CuentaContableSaveNombreIsNullEx(obj);
		}

		if (obj.getNombre().length() > 50) {
			throw new CuentaContableSaveNombreIsLengthMayor50ErrorEx(obj);
		}

		CuentaContableFilterQ5 filterNombreExistis = new CuentaContableFilterQ5();
		filterNombreExistis.setId(obj.getId());
		filterNombreExistis.setEjercicioContable(obj.getEjercicioContable());
		filterNombreExistis.setNombre(obj.getNombre());
		if (exists(filterNombreExistis) == false) {
			// exception el nombre ya existe
			throw new CuentaContableSaveNombreExistsEx(obj);
		}

		// ------------

		if (obj.getId() == null) {
			return insert(obj);
		}

		return update(obj);
	}

} // END CLASS -----------------------------------------------------------------