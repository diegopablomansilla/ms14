package com.massoftware.c.persist.dao.ds;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import com.massoftware.c.persist.dao.ds.ex.LoadPropertiesDataSourceException;
import com.massoftware.c.persist.dao.ds.info.DataSourceProperties;
import com.massoftware.c.persist.dao.ds.util.Printer;
import com.massoftware.c.persist.dao.ds.util.PrinterImpl;

public class DataSources {

	// ---------------------------------------------------------------------------------------------------------------------------

	private final String MSG_1 = "\n[..] Leyendo archivo de propiedades ${path}";
	private final String MSG_2 = "${content}\n[OK] Lectura de archivo de propiedades ${path}";
	private final String MSG_3 = "\n[ERROR] Lectura de archivo de propiedades ${path}";

	// ---------------------------------------------------------------------------------------------------------------------------

	private boolean verbose;
	private String pathHome = "";
	private Printer printer;
	private Map<String, DataSourceWrapper> dataSourceMap = new HashMap<String, DataSourceWrapper>();

	// ---------------------------------------------------------------------------------------------------------------------------

	public DataSources(boolean verbose, String pathHome) {
		this.printer = new PrinterImpl();
		this.verbose = verbose;
		this.pathHome = pathHome;
	}

	
	public DataSources(boolean verbose, String pathHome, Printer printer) {
		if (printer == null) {
			this.printer = new PrinterImpl();
		} else {
			this.printer = printer;
		}
		this.verbose = verbose;
		this.pathHome = pathHome;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public synchronized DataSourceWrapper get(String key) throws Exception {
		return this.getDataSource(key);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private synchronized DataSourceWrapper getDataSource(String key) throws Exception {

		if (dataSourceMap.containsKey(key) == false) {

			dataSourceMap.put(key, buildDataSource(key));

		}

		return dataSourceMap.get(key);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private DataSourceWrapper buildDataSource(String key) throws Exception {

		// -------------------------------------------------------------------

		Properties properties = loadProperties(key);

		// -------------------------------------------------------------------

		String path = "jdbc.";

		DataSourceProperties dataSourceProperties = new DataSourceProperties();

		dataSourceProperties.setDriverClassName(properties.getProperty(path + "driverClassName"));
		dataSourceProperties.setUrl(properties.getProperty(path + "url"));
		dataSourceProperties.setUserName(properties.getProperty(path + "userName"));
		dataSourceProperties.setUserPassword(properties.getProperty(path + "userPassword"));
		dataSourceProperties.setInitialSize(new Integer(properties.getProperty(path + "initialSize")));
		dataSourceProperties.setMaxActive(new Integer(properties.getProperty(path + "maxActive")));
		dataSourceProperties.setMaxIdle((new Integer(properties.getProperty(path + "maxIdle"))));
		dataSourceProperties.setValidationQuery(properties.getProperty(path + "validationQuery"));
		dataSourceProperties.setVerbose((new Boolean(properties.getProperty(path + "verbose"))));
		dataSourceProperties.setSchema(properties.getProperty(path + "schema"));
		dataSourceProperties.setConvertToJavaTimeValues((new Boolean(properties.getProperty(path + "convertToJavaTimeValues"))));

		// -------------------------------------------------------------------

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(dataSourceProperties.getDriverClassName());
		ds.setUrl(dataSourceProperties.getUrl());
		ds.setUsername(dataSourceProperties.getUserName());
		ds.setPassword(dataSourceProperties.getUserPassword());
		ds.setInitialSize(dataSourceProperties.getInitialSize());
		ds.setMaxActive(dataSourceProperties.getMaxActive());
		ds.setMaxIdle(dataSourceProperties.getMaxIdle());
		ds.setValidationQuery(dataSourceProperties.getValidationQuery());

		// -------------------------------------------------------------------

		return new DataSourceWrapper(key, printer.clone(), ds, dataSourceProperties);

		// -------------------------------------------------------------------

	}

	private Properties loadProperties(String key) throws LoadPropertiesDataSourceException {

		String path = pathHome + File.separatorChar + key + "_jdbc.properties";

		Properties properties = new Properties();
		InputStream input = null;

		try {

			print(MSG_1.replace("${path}", path));

//			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//			input = classLoader.getResourceAsStream(path);

			input = new FileInputStream(path);
			properties.load(input);

			print(MSG_2.replace("${path}", path).replace("${content}", printProperties(properties)));

		} catch (IOException ex) {
			
			print(MSG_3.replace("${path}", path));			
			
			throw new LoadPropertiesDataSourceException(ex, key, path);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					
					print(MSG_3.replace("${path}", path));			
					
					throw new LoadPropertiesDataSourceException(e, key, path);
				}
			}
		}

		return properties;

	}

	private String printProperties(Properties properties) {
		String s = "";

		for (Enumeration<Object> e = properties.keys(); e.hasMoreElements();) {
			Object obj = e.nextElement();
			s += "\n\t" + obj + ":" + properties.getProperty(obj.toString());
		}

		s = s.substring(0, s.length() - 1);

		s += "\n";

		return s;
	}

	private void print(String s) {
		if (this.verbose) {
			this.printer.print(s);
		}
	}

} // END CLASS -----------------------------------------------------------------