package com.massoftware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.a.model.CostoVenta;
import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.CuentaContableEstado;
import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.a.model.SeguridadModulo;
import com.massoftware.a.model.SeguridadPuerta;
import com.massoftware.a.model.TipoPuntoEquilibrio;
import com.massoftware.b.service.CentroCostoContableFilterQ1;
import com.massoftware.b.service.CostoVentaFilterQ1;
import com.massoftware.b.service.CuentaContableEstadoFilterQ1;
import com.massoftware.b.service.CuentaContableFilterQ1;
import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.b.service.PuntoEquilibrioFilterQ1;
import com.massoftware.b.service.SeguridadModuloFilterQ1;
import com.massoftware.b.service.SeguridadPuertaFilterQ1;
import com.massoftware.b.service.TipoPuntoEquilibrioFilterQ1;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBase;
import com.massoftware.c.persist.DataBases;
import com.massoftware.c.persist.dao.ds.ex.GetConnectionException;
import com.massoftware.c.persist.dao.ds.ex.InsertException;

public class Populate extends UtilPopulate {

	private static List<SeguridadModulo> itemsSeguridadModulo;
	private static List<SeguridadPuerta> itemsSeguridadPuerta;

	private static List<EjercicioContable> itemsEjercicioContable;

	private static List<TipoPuntoEquilibrio> itemsTipoPuntoEquilibrio;
	private static List<CostoVenta> itemsCostoVenta;
	private static List<CuentaContableEstado> itemsCuentaContableEstado;
	private static List<CentroCostoContable> itemsCentroCostoContable;
	private static List<PuntoEquilibrio> itemsPuntoEquilibrio;
	private static List<CuentaContable> itemsCuentaContable;

	public static void main(String[] args) throws GetConnectionException, Exception {

		String pathHomeDS = "D:\\dev\\source\\ms14\\files\\db\\ds";
		String pathHomeTemplatesSQL = "D:\\dev\\source\\ms14\\files\\db\\src_templates";
		String dataBaseKey = "massoftware";

		try {

			DataBases.setup(true, pathHomeDS, pathHomeTemplatesSQL);

			// --------------------------------------------------------------------

			populate(dataBaseKey);

			// --------------------------------------------------------------------

//			EjercicioContableFilterQ1 ejercicioContableFilterQ1 = new EjercicioContableFilterQ1();
//			f.setNumeroFrom(2);
//			f.setNumeroTo(9);
//			f.setOffset(1);
//			f.setLimit(10);

//			EjercicioContableService ejercicioContableService = new EjercicioContableService(dataBaseKey);
//
//			List<EjercicioContable> ejercicioContableList = ejercicioContableService.find(ejercicioContableFilterQ1);
//
//			System.out.println(ejercicioContableList);
//
//			long ejercicioContableCount = ejercicioContableService.count(ejercicioContableFilterQ1);
//
//			System.out.println(ejercicioContableCount);

			// --------------------------------------------------------------------

//			PuntoEquilibrioFilterQ1 puntoEquilibrioFilterQ1 = new PuntoEquilibrioFilterQ1();
////			f.setNumeroFrom(2);
////			f.setNumeroTo(9);
////			f.setOffset(1);
////			f.setLimit(10);
//
//			PuntoEquilibrioService puntoEquilibrioService = new PuntoEquilibrioService(dataBaseKey);
//
//			List<PuntoEquilibrio> puntoEquilibrioList = puntoEquilibrioService.find(puntoEquilibrioFilterQ1);
//
//			System.out.println(puntoEquilibrioList);
//
//			long puntoEquilibrioServiceCount = puntoEquilibrioService.count(puntoEquilibrioFilterQ1);
//
//			System.out.println(puntoEquilibrioServiceCount);

		} catch (Exception500 e) {

			System.err.println(e);

			e.getException().printStackTrace();

		} catch (Exception e) {

			System.err.println(e);

			e.printStackTrace();
		}

	}

	private static void populate(String dataBaseKey) throws Exception {
		DataBase dataBase = null;

		try {

			// --------------------------------------------------------------------

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			dataBase.beginTransaction();

			// --------------------------------------------------------------------

			dataBase.pp();

			schema();

			// --------------------------------------------------------------------

			itemsSeguridadModulo = new ArrayList<SeguridadModulo>();
			itemsSeguridadPuerta = new ArrayList<SeguridadPuerta>();
			itemsTipoPuntoEquilibrio = new ArrayList<TipoPuntoEquilibrio>();
			itemsCostoVenta = new ArrayList<CostoVenta>();
			itemsCuentaContableEstado = new ArrayList<CuentaContableEstado>();
			itemsEjercicioContable = new ArrayList<EjercicioContable>();
			itemsCentroCostoContable = new ArrayList<CentroCostoContable>();
			itemsPuntoEquilibrio = new ArrayList<PuntoEquilibrio>();
			itemsCuentaContable = new ArrayList<CuentaContable>();

			// --------------------------------------------------------------------

			System.out.println("SeguridadModulo = " + dataBase.count(new SeguridadModuloFilterQ1()));
			System.out.println("SeguridadPuerta = " + dataBase.count(new SeguridadPuertaFilterQ1()));
			System.out.println("TipoPuntoEquilibrio = " + dataBase.count(new TipoPuntoEquilibrioFilterQ1()));
			System.out.println("CostoVenta = " + dataBase.count(new CostoVentaFilterQ1()));
			System.out.println("CuentaContableEstado = " + dataBase.count(new CuentaContableEstadoFilterQ1()));
			System.out.println("EjercicioContable = " + dataBase.count(new EjercicioContableFilterQ1()));
			System.out.println("CentroCostoContable = " + dataBase.count(new CentroCostoContableFilterQ1()));
			System.out.println("PuntoEquilibrio = " + dataBase.count(new PuntoEquilibrioFilterQ1()));
			System.out.println("CuentaContable = " + dataBase.count(new CuentaContableFilterQ1()));

			// --------------------------------------------------------------------

			populateSeguridadModulo(dataBase);

			populateTipoPuntoEquilibrio(dataBase);
			populateCuentaContableEstado(dataBase);
			populateCostoVenta(dataBase);
			populateEjercicioContable(dataBase);
			populateCuentaContable(dataBase);

			// --------------------------------------------------------------------

			System.out.println("// --------------------------------------------------------------------");

			System.out.println("SeguridadModulo = " + dataBase.count(new SeguridadModuloFilterQ1()));
			System.out.println("SeguridadPuerta = " + dataBase.count(new SeguridadPuertaFilterQ1()));
			System.out.println("TipoPuntoEquilibrio = " + dataBase.count(new TipoPuntoEquilibrioFilterQ1()));
			System.out.println("CuentaContableEstado = " + dataBase.count(new CuentaContableEstadoFilterQ1()));
			System.out.println("CostoVenta = " + dataBase.count(new CostoVentaFilterQ1()));
			System.out.println("EjercicioContable = " + dataBase.count(new EjercicioContableFilterQ1()));
			System.out.println("CentroCostoContable = " + dataBase.count(new CentroCostoContableFilterQ1()));
			System.out.println("PuntoEquilibrio = " + dataBase.count(new PuntoEquilibrioFilterQ1()));
			System.out.println("CuentaContable = " + dataBase.count(new CuentaContableFilterQ1()));

			// --------------------------------------------------------------------

			dataBase.commitTransaction();

			// --------------------------------------------------------------------

		} catch (Exception500 e) {

			System.err.println(e);

			e.getException().printStackTrace();

		} catch (Exception e) {

			System.err.println(e);

			e.printStackTrace();
		} finally {
			try {
				dataBase.rollBackTransaction();
				dataBase.disconnect();
			} catch (Exception e) {
				throw new Exception500(e);
			}
		}

	}

	private static void populateSeguridadModulo(DataBase dataBase) throws Exception {

		for (int i = 1; i <= 30; i++) {

			SeguridadModulo seguridadModulo = new SeguridadModulo();

			seguridadModulo.setNumero(i);
			seguridadModulo.setNombre("SeguridadModulo" + i);

			dataBase.insertObject(seguridadModulo);

			itemsSeguridadModulo.add(seguridadModulo);

			populateSeguridadPuerta(dataBase, seguridadModulo);

		}

	}

	private static void populateSeguridadPuerta(DataBase dataBase, SeguridadModulo seguridadModulo) throws Exception {

		for (int i = 1; i <= 30; i++) {

			SeguridadPuerta seguridadPuerta = new SeguridadPuerta();

			seguridadPuerta.setNumero(i);
			seguridadPuerta.setNombre("SeguridadPuerta" + i);
			seguridadPuerta.setEquate("SeguridadPuerta" + i);
			seguridadPuerta.setSeguridadModulo(seguridadModulo);

			dataBase.insertObject(seguridadPuerta);

			itemsSeguridadPuerta.add(seguridadPuerta);

		}

	}

	private static void populateTipoPuntoEquilibrio(DataBase dataBase) throws Exception {

		for (int i = 1; i <= 30; i++) {

			TipoPuntoEquilibrio tipoPuntoEquilibrio = new TipoPuntoEquilibrio();

			tipoPuntoEquilibrio.setNumero(i);
			tipoPuntoEquilibrio.setNombre("TipoPuntoEquilibrio" + i);

			dataBase.insertObject(tipoPuntoEquilibrio);

			itemsTipoPuntoEquilibrio.add(tipoPuntoEquilibrio);

		}

	}

	private static void populateCostoVenta(DataBase dataBase) throws Exception {

		for (int i = 1; i <= 4; i++) {

			CostoVenta costoVenta = new CostoVenta();

			costoVenta.setNumero(i);
			if (i == 1) {
				costoVenta.setNombre("No participa");
			} else if (i == 2) {
				costoVenta.setNombre("Stock");
			} else if (i == 3) {
				costoVenta.setNombre("Compras");
			} else if (i == 4) {
				costoVenta.setNombre("Gastos");
			}

			dataBase.insertObject(costoVenta);

			itemsCostoVenta.add(costoVenta);

		}
	}

	private static void populateCuentaContableEstado(DataBase dataBase) throws Exception {

		for (int i = 1; i <= 2; i++) {
			CuentaContableEstado cuentaContableEstado = new CuentaContableEstado();

			cuentaContableEstado.setNumero(i);

			if (i == 1) {
				cuentaContableEstado.setNombre("Cuenta fuera de uso");
			} else {
				cuentaContableEstado.setNombre("Cuenta en uso");
			}

			dataBase.insertObject(cuentaContableEstado);

			itemsCuentaContableEstado.add(cuentaContableEstado);
		}

	}

	private static void populateEjercicioContable(DataBase dataBase) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		for (int i = 2002; i < 2019; i++) {

			EjercicioContable ejercicioContable = new EjercicioContable();

			ejercicioContable.setNumero(i);
			ejercicioContable.setApertura(LocalDate.parse("01/01/" + i, formatter));
			ejercicioContable.setCierre(LocalDate.parse("31/12/" + i, formatter));
			ejercicioContable.setCerrado(true);
			ejercicioContable.setCerradoModulos(true);
			ejercicioContable.setComentario(i + "");

			dataBase.insertObject(ejercicioContable);

			populateCentroCostoContable(dataBase, ejercicioContable);
			populatePuntoEquilibrio(dataBase, ejercicioContable);

			itemsEjercicioContable.add(ejercicioContable);

		}

	}

	private static void populateCentroCostoContable(DataBase dataBase, EjercicioContable ejercicioContable)
			throws Exception {

		for (int i = 1; i <= 250; i++) {

			CentroCostoContable centroCostoContable = new CentroCostoContable();

			centroCostoContable.setNumero(i);
			centroCostoContable.setNombre("CentroCostoContable" + i);
			centroCostoContable.setAbreviatura("CC" + i);
			centroCostoContable.setEjercicioContable(ejercicioContable);

			dataBase.insertObject(centroCostoContable);

			itemsCentroCostoContable.add(centroCostoContable);

		}

	}

	private static void populatePuntoEquilibrio(DataBase dataBase, EjercicioContable ejercicioContable)
			throws Exception {

		for (int i = 1; i <= 250; i++) {

			PuntoEquilibrio puntoEquilibrio = new PuntoEquilibrio();
			puntoEquilibrio.setNumero(i);
			puntoEquilibrio.setNombre("PuntoEquilibrio" + i);
			puntoEquilibrio.setTipoPuntoEquilibrio(
					itemsTipoPuntoEquilibrio.get(getIntegerRandom(0, itemsTipoPuntoEquilibrio.size() - 1)));
			puntoEquilibrio.setEjercicioContable(ejercicioContable);

			dataBase.insertObject(puntoEquilibrio);

			itemsPuntoEquilibrio.add(puntoEquilibrio);

		}

	}

	private static void populateCuentaContable(DataBase dataBase) throws Exception {

		String filePath = "D:\\dev\\source\\ms14\\files\\db\\pp\\migracion\\cuentas_contables - copia.csv";

		// -------------------------------------------------------------------

		String line;
		String source = "";

//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		URL url = classLoader.getResource(filePath);
		URL url = new URL("file:\\" + filePath);
		String path = url.toString().substring(6, url.toString().length());

		FileReader f = new FileReader(path);
		BufferedReader b = new BufferedReader(f);

		int c = 0;

		while ((line = b.readLine()) != null) {
			String[] fields = line.trim().split(";");

			for (int i = 0; i < fields.length; i++) {
				if (fields[i] != null) {
					fields[i] = fields[i].trim();
				}

				if (fields[i].trim().length() == 0) {
					fields[i] = null;
				}

				if (fields[i] != null && fields[i].equalsIgnoreCase("null")) {
					fields[i] = null;
				}

			}

//			System.out.println(fields.length + " ---- " + Arrays.toString(fields));

			CuentaContable cuentaContable = new CuentaContable();

			cuentaContable.setCodigo(fields[0]); // 0

			// ------------------------------------

			cuentaContable.setNombre(fields[1] + "_" + c); // 1

			// ------------------------------------

			for (EjercicioContable ejercicioContable : itemsEjercicioContable) {
				if (ejercicioContable.getNumero().equals(Integer.valueOf(fields[2].trim()))) {
					cuentaContable.setEjercicioContable(ejercicioContable); // 2
					break;
				}
			}

			cuentaContable.setIntegra(fields[3]); // 3
			// ------------------------------------
			cuentaContable.setCuentaJerarquia(fields[4]); // 4
			// ------------------------------------
			cuentaContable.setImputable(fields[5].trim().equalsIgnoreCase("S")); // 5
			// ------------------------------------
			cuentaContable.setAjustaPorInflacion(fields[6].trim().equalsIgnoreCase("S")); // 6

			// ------------------------------------

			for (CuentaContableEstado cuentaContableEstado : itemsCuentaContableEstado) {
				if (cuentaContableEstado.getNumero().equals(Integer.valueOf(fields[7].trim()) + 1)) {
					cuentaContable.setCuentaContableEstado(cuentaContableEstado); // 7
					break;
				}
			}

			// ------------------------------------

			cuentaContable.setCuentaConApropiacion(fields[8].trim().equalsIgnoreCase("S")); // 8

			// ------------------------------------

			List<CentroCostoContable> itemsCentroCostoContableTemp = new ArrayList<CentroCostoContable>();

			for (CentroCostoContable centroCostoContable : itemsCentroCostoContable) {

				if (centroCostoContable.getEjercicioContable().getNumero()
						.equals(cuentaContable.getEjercicioContable().getNumero())) {

					itemsCentroCostoContableTemp.add(centroCostoContable);

				}
			}

			cuentaContable.setCentroCostoContable(
					itemsCentroCostoContableTemp.get(getIntegerRandom(0, itemsCentroCostoContableTemp.size() - 1))); // 9

			// ------------------------------------

			cuentaContable.setCuentaAgrupadora(fields[10]); // 10

			// ------------------------------------

			cuentaContable.setPorcentaje(fields[11] == null ? null : Double.valueOf(fields[11].trim())); // 11

			// ------------------------------------

			List<PuntoEquilibrio> itemsPuntoEquilibrioTemp = new ArrayList<PuntoEquilibrio>();

			for (PuntoEquilibrio puntoEquilibrio : itemsPuntoEquilibrio) {

				if (puntoEquilibrio.getEjercicioContable().getNumero()
						.equals(cuentaContable.getEjercicioContable().getNumero())) {

					itemsPuntoEquilibrioTemp.add(puntoEquilibrio); // 12

				}
			}

			// ------------------------------------

			cuentaContable.setPuntoEquilibrio(
					itemsPuntoEquilibrioTemp.get(getIntegerRandom(0, itemsPuntoEquilibrioTemp.size() - 1))); // 13

			// ------------------------------------

			for (CostoVenta costoVenta : itemsCostoVenta) {
				if (costoVenta.getNumero().equals(Integer.valueOf(fields[13].trim()))) {
					cuentaContable.setCostoVenta(costoVenta); // 14
					break;
				}
			}
//			cuentaContable.setCostoVenta(itemsCostoVenta.get(getIntegerRandom(0, itemsCostoVenta.size() - 1)));			

			// ------------------------------------

			cuentaContable
					.setSeguridadPuerta(itemsSeguridadPuerta.get(getIntegerRandom(0, itemsSeguridadPuerta.size() - 1)));

			// ------------------------------------

//			String[] fields2 = new String[15];
//
//			fields2[0] = cuentaContable.getCodigo();
//			fields2[1] = cuentaContable.getNombre();
//			fields2[2] = cuentaContable.getEjercicioContable().getNumero() + "";
//			fields2[3] = cuentaContable.getIntegra();
//			fields2[4] = cuentaContable.getCuentaJerarquia();
//			fields2[5] = cuentaContable.getImputable() ? "S" : "N";
//			fields2[6] = cuentaContable.getAjustaPorInflacion() ? "S" : "N";
//			if (cuentaContable.getCuentaContableEstado() != null) {
//				fields2[7] = cuentaContable.getCuentaContableEstado().getNumero() + "";
//			}
//			fields2[8] = cuentaContable.getCuentaConApropiacion() ? "1" : "0";
////			fields2[9] = cuentaContable.getCentroCostoContable().getNumero() + "";
//			fields2[10] = cuentaContable.getCuentaAgrupadora();
//			fields2[11] = cuentaContable.getPorcentaje() + "";
////			fields2[12] = cuentaContable.getPuntoEquilibrio().getNumero() + "";
//			fields2[13] = cuentaContable.getCostoVenta().getNumero() + "";
////			fields2[14] = cuentaContable.getSeguridadPuerta().getNumero() + "";

//			System.out.println(fields.length + " ---- " + Arrays.toString(fields2));
//
//			System.out.println();

			if (cuentaContable.getIntegra() != null && cuentaContable.getCuentaContableEstado() != null) {

				dataBase.insertObject(cuentaContable);

				itemsCuentaContable.add(cuentaContable);

			}

			c++;

		}
		b.close();

		// -------------------------------------------------------------------

//
//		for (int i = 1; i <= 250; i++) {
//
//			CuentaContable cuentaContable = new CuentaContable();
//
//			cuentaContable.setCodigo("CuentaContable" + i);
//			cuentaContable.setNombre("CuentaContable" + i);
//			cuentaContable.setEjercicioContable(ejercicioContable);
//			
//			cuentaContable.setIntegra("");
//			cuentaContable.setCuentaJerarquia("");
//			
//			cuentaContable.setImputable(new Random().nextBoolean());
//			cuentaContable.setAjustaPorInflacion(new Random().nextBoolean());
//			cuentaContable.setCuentaContableEstado(
//					itemsCuentaContableEstado.get(getIntegerRandom(0, itemsCuentaContableEstado.size() - 1)));
//			cuentaContable.setCuentaConApropiacion(new Random().nextBoolean());
//			cuentaContable.setCentroCostoContable(
//					itemsCentroCostoContable.get(getIntegerRandom(0, itemsCentroCostoContable.size() - 1)));
//			cuentaContable.setCuentaAgrupadora("CuentaContable" + i);
//			cuentaContable.setPorcentaje(getDoubleRandom(1d, 100d, false));
//			cuentaContable
//					.setPuntoEquilibrio(itemsPuntoEquilibrio.get(getIntegerRandom(0, itemsPuntoEquilibrio.size() - 1)));
//			cuentaContable.setCostoVenta(itemsCostoVenta.get(getIntegerRandom(0, itemsCostoVenta.size() - 1)));
//
//			SeguridadModulo saeguridadModulo = itemsSeguridadModulo
//					.get(getIntegerRandom(0, itemsSeguridadModulo.size() - 1));
//			List<SeguridadPuerta> itemsSeguridadPuerta = saeguridadModulo.getSeguridadPuertaItems();
//
//			cuentaContable
//					.setSeguridadPuerta(itemsSeguridadPuerta.get(getIntegerRandom(0, itemsSeguridadPuerta.size() - 1)));
//
//			dataBase.insertObject(cuentaContable);
//
//		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public static void schema() throws IOException {
//		String pathSchemaSpyJar = "D:\\dev\\source\\massoftware_front\\postgresql\\schemaSpy\\schemaSpy_5.0.0.jar";		
//		String postgreSQLJar = "D:\\dev\\source\\massoftware_front\\postgresql\\schemaSpy\\postgresql-9.4.1212.jar";
		String pathSchemaSpyJar = "D:\\dev\\source\\ms14\\files\\schemaspy\\schemaSpy_5.0.0.jar";
		String postgreSQLJar = "D:\\dev\\source\\ms14\\files\\schemaspy\\postgresql-9.4.1212.jar";
		String pathGV = "D:\\programas\\ATT\\Graphviz";
		String pathSchemaFolderOut = "D:\\dev\\source\\ms14\\files\\db\\pp\\schema";

//		File folder = new File(pathSchemaFolderOut);
//		folder.mkdirs();
//		
//		File[] files = folder.listFiles();
//
//		for (File file : files) {
//			
//			boolean b = file.delete();
//			
//			System.out.println(b ? "[OK] " : "[ERROR] " + file);
//		}

		Runtime runTime = Runtime.getRuntime();

		String directorioDeEjecutable = "java -jar " + pathSchemaSpyJar
				+ " -t pgsql -s massoftware -db massoftware -u postgres -host localhost -o " + pathSchemaFolderOut
				+ " -dp " + postgreSQLJar + " -gv " + pathGV;

		System.out.println(directorioDeEjecutable);

//		runTime.exec(directorioDeEjecutable);

//		Process process = runTime.exec(directorioDeEjecutable);
//
//		// Se obtiene el stream de salida del programa
//		InputStream is = process.getInputStream();
//
//		/* Se prepara un bufferedReader para poder leer la salida más comodamente. */
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//		// Se lee la primera linea
//		String aux = br.readLine();
//
//		// Mientras se haya leido alguna linea
//		while (aux != null) {
//			// Se escribe la linea en pantalla
//			System.out.println(aux);
//
//			// y se lee la siguiente.
//			aux = br.readLine();
//		}
	}

} // END CLASS -----------------------------------------------------------------