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

	public static void setup() {

		String pathHomeDS = "D:\\dev\\source\\ms14\\files\\db\\ds";
		String pathHomeTemplatesSQL = "D:\\dev\\source\\ms14\\files\\db\\src_templates";		

		setup(true, pathHomeDS, pathHomeTemplatesSQL);
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

		if (instanceDataBases == null) {
			throw new IllegalArgumentException("instanceDataBases is null.");
		}

		if (instanceDataBases.getDataSources() == null) {
			throw new IllegalArgumentException("DataSources is null.");
		}

		if (instanceDataBases.getDataSources().get(key) == null) {
			throw new IllegalArgumentException("key is null.");
		}

		return new DataBase(instanceDataBases.getSourceSQL(),
				instanceDataBases.getDataSources().get(key).getConnection());
	}

} // END CLASS -----------------------------------------------------------------