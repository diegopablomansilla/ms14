package com.massoftware.b.service;

import java.util.List;

import com.massoftware.a.model.TipoSucursal;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBase;
import com.massoftware.c.persist.DataBases;

public class TipoSucursalService {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String dataBaseKey;

	// ---------------------------------------------------------------------------------------------------------------------------

	public TipoSucursalService(String dataBaseKey) {
		super();
		this.dataBaseKey = dataBaseKey;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Long count(TipoSucursalFilterQ1 filter) throws Exception500 {

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.count(filter);

		} catch (Exception e) {
			throw new Exception500(e);
		} finally {
			try {
				dataBase.disconnect();
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

	}

	public List<TipoSucursal> find(TipoSucursalFilterQ1 filter) throws Exception500 {

		DataBase dataBase = null;

		try {

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			return dataBase.find(filter);

		} catch (Exception e) {
			throw new Exception500(e);
		} finally {
			try {
				dataBase.disconnect();
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

	}

} // END CLASS -----------------------------------------------------------------