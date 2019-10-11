package com.massoftware.c.persist.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import com.massoftware.c.persist.dao.ds.ConnectionWrapper;
import com.massoftware.c.persist.dao.ds.ex.DDLException;
import com.massoftware.c.persist.dao.ds.ex.DeleteException;
import com.massoftware.c.persist.dao.ds.ex.InsertException;
import com.massoftware.c.persist.dao.ds.ex.UpdateException;
import com.massoftware.c.persist.dao.ds.info.Statement;
import com.massoftware.c.persist.dao.util.AbstractDAO;

public class PPDAO extends AbstractDAO {

	// ---------------------------------------------------------------------------------------------------------------------------

	public PPDAO() {
		super();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void pp(ConnectionWrapper connection)
			throws SQLException, IOException, InsertException, UpdateException, DeleteException, DDLException {

		String pathSQLTable = "D:\\dev\\source\\ms14\\files\\db\\pp\\pp.sql";

		String sql = loadFile(pathSQLTable);

		connection.execute(0, new Statement(sql));

		pathSQLTable = "D:\\dev\\source\\ms14\\files\\db\\pp\\pp_create_tables.sql";

		sql = loadFile(pathSQLTable);

		connection.execute(0, new Statement(sql));

	}

	private String loadFile(String filePath) throws IOException {

		String linea;
		String source = "";

//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		URL url = classLoader.getResource(filePath);
		URL url = new URL("file:\\" + filePath);
		String path = url.toString().substring(6, url.toString().length());

		FileReader f = new FileReader(path);
		BufferedReader b = new BufferedReader(f);
		while ((linea = b.readLine()) != null) {
			source += "\n" + linea;
			// System.out.println(linea);
		}
		b.close();

//		source = source.trim();

		return source;
	}

} // END CLASS -----------------------------------------------------------------