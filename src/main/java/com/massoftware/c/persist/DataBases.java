package com.massoftware.c.persist;

import com.massoftware.c.persist.dao.ds.DataSources;
import com.massoftware.c.persist.dao.ds.ex.GetConnectionException;
import com.massoftware.c.persist.dao.util.SourceSQL;

public class DataBases {

	// ---------------------------------------------------------------------------------------------------------------------------

	private DataSources dataSources;
	private SourceSQL sourceSQL;

	private static DataBases instanceDataBases;

	// ---------------------------------------------------------------------------------------------------------------------------

	private DataBases(boolean verbose, String pathHomeDS, String pathHomeTemplatesSQL) {

		dataSources = new DataSources(verbose, pathHomeDS);
		sourceSQL = new SourceSQL(pathHomeTemplatesSQL);		
	}

	public static void setup(boolean verbose, String pathHomeDS, String pathHomeTemplatesSQL) {

		instanceDataBases = new DataBases(verbose, pathHomeDS, pathHomeTemplatesSQL);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private synchronized DataSources getDataSources() {
		return dataSources;
	}

	private synchronized SourceSQL getSourceSQL() {
		return sourceSQL;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public static synchronized DataBase connectToDataBase(String key) throws GetConnectionException, Exception {
		return new DataBase(instanceDataBases.getSourceSQL(),
				instanceDataBases.getDataSources().get(key).getConnection());
	}

} // END CLASS -----------------------------------------------------------------