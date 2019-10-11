package com.massoftware.c.persist.dao.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SourceSQL {

	// ---------------------------------------------------------------------------------------------------------------------------

	private String path;
	private Map<String, String> sources = new HashMap<String, String>();

	// ---------------------------------------------------------------------------------------------------------------------------

	public SourceSQL(String path) {
		this.path = path;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private synchronized Map<String, String> getSources() {
		return sources;
	}

	private synchronized String getPath() {
		return path;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public synchronized String get(String key) {

		if (getSources().containsKey(key) == false) {

			try {
				loadQuery(key);
			} catch (IOException e) {
				new IllegalArgumentException(
						"Se intento levantar un template file sql que no existe. Por favor verifique qye " + key
								+ ".sql se encuentre en " + getPath());
			} catch (URISyntaxException e) {
				new IllegalArgumentException(
						"Se intento levantar un template file sql que no existe. Por favor verifique qye " + key
								+ ".sql se encuentre en " + getPath());
			} catch (Exception e) {
				throw e;
			}
		}

		if (getSources().containsKey(key) == false) {
			new IllegalArgumentException("Se intento pedir un template file sql que no existe.");
		}

		return getSources().get(key);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private synchronized void loadQuery(String key) throws IOException, URISyntaxException {
		File folder = new File(getPath());
		File[] files = folder.listFiles();

		for (File file : files) {

			if (file.getName().equals(key + ".sql")) {

//				Path path = Paths.get(getClass().getClassLoader().getResource(this.path).toURI());
				Path path = Paths.get(file.getAbsolutePath());
				StringBuilder content = new StringBuilder();

				try (Stream<String> lines = Files.lines(path)) {
					lines.forEach(line -> content.append(line).append("\n"));
				} catch (IOException e) {
					throw e;
				}

				getSources().put(file.getName().replace(".sql", ""), content.toString());
			}

		}
	}

} // END CLASS -----------------------------------------------------------------