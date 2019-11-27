package com.massoftware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.massoftware.a.model.AsientoContableModulo;
import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.a.model.CostoVenta;
import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.EjercicioContable;
import com.massoftware.a.model.Empresa;
import com.massoftware.a.model.MinutaContable;
import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.a.model.SeguridadModulo;
import com.massoftware.a.model.SeguridadPuerta;
import com.massoftware.a.model.TipoPuntoEquilibrio;
import com.massoftware.b.service.AsientoContableModuloFilterQ1;
import com.massoftware.b.service.CentroCostoContableFilterQ1;
import com.massoftware.b.service.CostoVentaFilterQ1;
import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.b.service.EmpresaFilterQ1;
import com.massoftware.b.service.MinutaContableFilterQ1;
import com.massoftware.b.service.PuntoEquilibrioFilterQ1;
import com.massoftware.b.service.SeguridadModuloFilterQ1;
import com.massoftware.b.service.SeguridadPuertaFilterQ1;
import com.massoftware.b.service.TipoPuntoEquilibrioFilterQ1;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ1;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBase;
import com.massoftware.c.persist.DataBases;
import com.massoftware.c.persist.dao.ds.ex.GetConnectionException;

public class Populate extends UtilPopulate {

	private static List<SeguridadModulo> itemsSeguridadModulo;
	private static List<SeguridadPuerta> itemsSeguridadPuerta;

	private static List<EjercicioContable> itemsEjercicioContable;

	private static List<TipoPuntoEquilibrio> itemsTipoPuntoEquilibrio;
	private static List<CostoVenta> itemsCostoVenta;
//	private static List<CuentaContableEstado> itemsCuentaContableEstado;
	private static Empresa empresa;
	private static List<CentroCostoContable> itemsCentroCostoContable;
	private static List<PuntoEquilibrio> itemsPuntoEquilibrio;
	private static List<CuentaContable> itemsCuentaContable;
	private static List<MinutaContable> itemsMinutaContable;
	private static List<AsientoContableModulo> itemsAsientoContableModulo;

	public static void main(String[] args) throws GetConnectionException, Exception {

		String pathHomeDS = "D:\\dev\\source\\ms14\\files\\db\\ds";
		String pathHomeTemplatesSQL = "D:\\dev\\source\\ms14\\files\\db\\src_templates";
		String dataBaseKey = "massoftware";

		try {

			DataBases.setup(true, pathHomeDS, pathHomeTemplatesSQL);

			// --------------------------------------------------------------------

			itemsSeguridadModulo = new ArrayList<SeguridadModulo>();
			itemsSeguridadPuerta = new ArrayList<SeguridadPuerta>();
			itemsTipoPuntoEquilibrio = new ArrayList<TipoPuntoEquilibrio>();
			itemsCostoVenta = new ArrayList<CostoVenta>();
//				itemsCuentaContableEstado = new ArrayList<CuentaContableEstado>();
			itemsEjercicioContable = new ArrayList<EjercicioContable>();
			itemsCentroCostoContable = new ArrayList<CentroCostoContable>();
			itemsPuntoEquilibrio = new ArrayList<PuntoEquilibrio>();
			itemsCuentaContable = new ArrayList<CuentaContable>();
			itemsMinutaContable = new ArrayList<MinutaContable>();
			itemsAsientoContableModulo = new ArrayList<AsientoContableModulo>();

			// --------------------------------------------------------------------

			step(dataBaseKey, 0);
			step(dataBaseKey, 1);
			step(dataBaseKey, 2);
			step(dataBaseKey, 3);
			step(dataBaseKey, 4);
			step(dataBaseKey, 1000);

			// --------------------------------------------------------------------

			// --------------------------------------------------------------------

		} catch (Exception500 e) {

			System.err.println(e);

			e.getException().printStackTrace();

		} catch (Exception e) {

			System.err.println(e);

			e.printStackTrace();
		}

	}

	private static void step(String dataBaseKey, int step) throws Exception {

		DataBase dataBase = null;

		try {

			// --------------------------------------------------------------------

			dataBase = DataBases.connectToDataBase(dataBaseKey);

			dataBase.beginTransaction();

			// --------------------------------------------------------------------

			if (step == 0) {

				dataBase.pp();

				schema();

			} else if (step == 1) {

				System.out.println("SeguridadModulo = " + dataBase.count(new SeguridadModuloFilterQ1()));
				System.out.println("SeguridadPuerta = " + dataBase.count(new SeguridadPuertaFilterQ1()));
				System.out.println("TipoPuntoEquilibrio = " + dataBase.count(new TipoPuntoEquilibrioFilterQ1()));
				System.out.println("CostoVenta = " + dataBase.count(new CostoVentaFilterQ1()));
//					System.out.println("CuentaContableEstado = " + dataBase.count(new CuentaContableEstadoFilterQ1()));
				System.out.println("EjercicioContable = " + dataBase.count(new EjercicioContableFilterQ1()));
				System.out.println("Empresa = " + dataBase.count(new EmpresaFilterQ1()));
				System.out.println("CentroCostoContable = " + dataBase.count(new CentroCostoContableFilterQ1()));
				System.out.println("PuntoEquilibrio = " + dataBase.count(new PuntoEquilibrioFilterQ1()));
				System.out.println("CuentaContable = " + dataBase.count(new CuentaContableFilterQ1()));
				System.out.println("MinutaContable = " + dataBase.count(new MinutaContableFilterQ1()));
				System.out.println("AsientoContableModulo = " + dataBase.count(new AsientoContableModuloFilterQ1()));

			} else if (step == 2) {

				populateSeguridadModulo(dataBase);
				populateTipoPuntoEquilibrio(dataBase);
//				populateCuentaContableEstado(dataBase);
				populateCostoVenta(dataBase);

			} else if (step == 3) {

				populateEjercicioContable(dataBase);

			} else if (step == 4) {

				populateMinutaContable(dataBase);
				populateAsientoContableModulo(dataBase);

			} else {

				System.out.println("// --------------------------------------------------------------------");

				System.out.println("SeguridadModulo = " + dataBase.count(new SeguridadModuloFilterQ1()));
				System.out.println("SeguridadPuerta = " + dataBase.count(new SeguridadPuertaFilterQ1()));
				System.out.println("TipoPuntoEquilibrio = " + dataBase.count(new TipoPuntoEquilibrioFilterQ1()));
//					System.out.println("CuentaContableEstado = " + dataBase.count(new CuentaContableEstadoFilterQ1()));
				System.out.println("CostoVenta = " + dataBase.count(new CostoVentaFilterQ1()));
				System.out.println("EjercicioContable = " + dataBase.count(new EjercicioContableFilterQ1()));
				System.out.println("Empresa = " + dataBase.count(new EmpresaFilterQ1()));
				System.out.println("CentroCostoContable = " + dataBase.count(new CentroCostoContableFilterQ1()));
				System.out.println("PuntoEquilibrio = " + dataBase.count(new PuntoEquilibrioFilterQ1()));
				System.out.println("CuentaContable = " + dataBase.count(new CuentaContableFilterQ1()));
				System.out.println("MinutaContable = " + dataBase.count(new MinutaContableFilterQ1()));
				System.out.println("AsientoContableModulo = " + dataBase.count(new AsientoContableModuloFilterQ1()));
			}

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

		for (int i = 1; i <= 6; i++) {

			TipoPuntoEquilibrio tipoPuntoEquilibrio = new TipoPuntoEquilibrio();

			tipoPuntoEquilibrio.setNumero(i);

			if (i == 1) {
				tipoPuntoEquilibrio.setNombre("Individual");
			} else if (i == 2) {
				tipoPuntoEquilibrio.setNombre("Costo de ventas");
			} else if (i == 3) {
				tipoPuntoEquilibrio.setNombre("Utilidad bruta");
			} else if (i == 4) {
				tipoPuntoEquilibrio.setNombre("Resultados por sección");
			} else if (i == 5) {
				tipoPuntoEquilibrio.setNombre("Resultados operativos");
			} else if (i == 6) {
				tipoPuntoEquilibrio.setNombre("Resultados del período");
			}

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

	private static void populateMinutaContable(DataBase dataBase) throws Exception {

		for (int i = 0; i < 9; i++) {

			MinutaContable minutaContable = new MinutaContable();

			minutaContable.setNumero(i);
			if (i == 0) {
				minutaContable.setNombre("Sin definir");
			} else if (i == 1) {
				minutaContable.setNombre("Venta");
			} else if (i == 2) {
				minutaContable.setNombre("Stock");
			} else if (i == 3) {
				minutaContable.setNombre("Fondos");
			} else if (i == 4) {
				minutaContable.setNombre("Compras");
			} else if (i == 5) {
				minutaContable.setNombre("Contabilidad");
			} else if (i == 6) {
				minutaContable.setNombre("Sueldos");
			} else if (i == 7) {
				minutaContable.setNumero(98);
				minutaContable.setNombre("Ajustes");
			} else if (i == 8) {
				minutaContable.setNumero(99);
				minutaContable.setNombre("Otros");
			}

			dataBase.insertObject(minutaContable);

			itemsMinutaContable.add(minutaContable);

		}
	}

	private static void populateAsientoContableModulo(DataBase dataBase) throws Exception {

		for (int i = 0; i < 4; i++) {

			if (i == 2) {
				continue;
			}

			AsientoContableModulo asientoContableModulo = new AsientoContableModulo();

			asientoContableModulo.setNumero(i);
			if (i == 0) {
				asientoContableModulo.setNombre("Conta");
			} else if (i == 1) {
				asientoContableModulo.setNombre("Vta");
			} else if (i == 2) {
//				asientoContableModulo.setNombre("Stock");
			} else if (i == 3) {
				asientoContableModulo.setNombre("Fdo.");
			} else if (i == 3) {
				asientoContableModulo.setNombre("Cpra.");
			}

			dataBase.insertObject(asientoContableModulo);

			itemsAsientoContableModulo.add(asientoContableModulo);

		}
	}

//	private static void populateCuentaContableEstado(DataBase dataBase) throws Exception {
//
//		for (int i = 0; i < 2; i++) {
//			
//			CuentaContableEstado cuentaContableEstado = new CuentaContableEstado();
//
//			cuentaContableEstado.setNumero(i);
//
//			if (i == 0) {
//				cuentaContableEstado.setNombre("Cuenta fuera de uso");
//			} else {
//				cuentaContableEstado.setNombre("Cuenta en uso");
//			}
//
//			dataBase.insertObject(cuentaContableEstado);
//
//			itemsCuentaContableEstado.add(cuentaContableEstado);
//		}
//
//	}

	private static void populateEjercicioContable(DataBase dataBase) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		for (int i = 2002; i < 2019; i++) {

			EjercicioContable ejercicioContable = new EjercicioContable();

			ejercicioContable.setNumero(i);
			ejercicioContable.setApertura(LocalDate.parse("01/01/" + i, formatter));
			ejercicioContable.setCierre(LocalDate.parse("31/12/" + i, formatter));
			ejercicioContable.setCerrado(i < 2019);
			ejercicioContable.setCerradoModulos(true);
			ejercicioContable.setComentario(i + "");

			dataBase.insertObject(ejercicioContable);

			if (i == 2002) {
				populateEmpresa(dataBase, ejercicioContable);
			}
			populateCentroCostoContable(dataBase, ejercicioContable);
			populatePuntoEquilibrio(dataBase, ejercicioContable);
			populateCuentaContable(dataBase, ejercicioContable);

			itemsEjercicioContable.add(ejercicioContable);

		}

	}

	private static void populateEmpresa(DataBase dataBase, EjercicioContable ejercicioContable) throws Exception {

		for (int i = 1; i <= 1; i++) {

			empresa = new Empresa();

			empresa.setEjercicioContable(ejercicioContable);

			dataBase.insertObject(empresa);

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

	private static void populateCuentaContable(DataBase dataBase, EjercicioContable ejercicioContable)
			throws Exception {

//		cuentaContable.setCuentaJerarquia(i + ".00.00.00.00.00");

		int limitMin = 10;
		int limitTop = 90;
		int limit = limitTop;

		int contadorCuentas = 0;

		for (int a = 1; a <= 6; a++) {
			contadorCuentas++;
			String cuentaJerarquia = a + "0000000000";
			CuentaContable cuentaContableA = buildCuentaContable(ejercicioContable, contadorCuentas, null,
					cuentaJerarquia);
			dataBase.insertObject(cuentaContableA);
			itemsCuentaContable.add(cuentaContableA);

			limit = getIntegerRandom(limitMin, limitTop);
			
			for (int b = 10; b <= limit; b = b + 10) {

				contadorCuentas++;
				cuentaJerarquia = cuentaContableA.getCuentaJerarquia().substring(0, 1) + b + "00000000";
				CuentaContable cuentaContableB = buildCuentaContable(ejercicioContable, contadorCuentas,
						cuentaContableA, cuentaJerarquia);
				dataBase.insertObject(cuentaContableB);
				itemsCuentaContable.add(cuentaContableB);
				
				limit = getIntegerRandom(limitMin, limitTop);

				for (int c = 10; c <= limit; c = c + 10) {

					contadorCuentas++;
					cuentaJerarquia = cuentaContableB.getCuentaJerarquia().substring(0, 3) + c + "000000";
					CuentaContable cuentaContableC = buildCuentaContable(ejercicioContable, contadorCuentas,
							cuentaContableB, cuentaJerarquia);
					dataBase.insertObject(cuentaContableC);
					itemsCuentaContable.add(cuentaContableC);
					
					limit = getIntegerRandom(limitMin, limitTop);

					for (int d = 10; d <= limit; d = d + 10) {

						contadorCuentas++;
						cuentaJerarquia = cuentaContableC.getCuentaJerarquia().substring(0, 5) + d + "0000";
						CuentaContable cuentaContableD = buildCuentaContable(ejercicioContable, contadorCuentas,
								cuentaContableC, cuentaJerarquia);
						dataBase.insertObject(cuentaContableD);
						itemsCuentaContable.add(cuentaContableD);
						
						limit = getIntegerRandom(limitMin, limitTop);

						for (int e = 10; e <= limit; e = e + 10) {

							contadorCuentas++;
							cuentaJerarquia = cuentaContableD.getCuentaJerarquia().substring(0, 7) + e + "00";
							CuentaContable cuentaContableE = buildCuentaContable(ejercicioContable, contadorCuentas,
									cuentaContableD, cuentaJerarquia);
							dataBase.insertObject(cuentaContableE);
							itemsCuentaContable.add(cuentaContableE);

							for (int f = 1; f <= 9; f++) {

								contadorCuentas++;
								cuentaJerarquia = cuentaContableE.getCuentaJerarquia().substring(0, 9) + "0" + f + "";
								CuentaContable cuentaContableF = buildCuentaContable(ejercicioContable, contadorCuentas,
										cuentaContableE, cuentaJerarquia);
								dataBase.insertObject(cuentaContableF);
								itemsCuentaContable.add(cuentaContableF);
							}

							for (int f = 10; f <= 99; f++) {

								contadorCuentas++;
								cuentaJerarquia = cuentaContableE.getCuentaJerarquia().substring(0, 9) + f + "";
								CuentaContable cuentaContableF = buildCuentaContable(ejercicioContable, contadorCuentas,
										cuentaContableE, cuentaJerarquia);
								dataBase.insertObject(cuentaContableF);
								itemsCuentaContable.add(cuentaContableF);
							}

						}

					}

				}

			}

		}

	}

	private static CuentaContable buildCuentaContable(EjercicioContable ejercicioContable, int c,
			CuentaContable integra, String cuentaJerarquia) {

		CuentaContable cuentaContable = new CuentaContable();

		cuentaContable.setCodigo("CC" + c);
		cuentaContable.setNombre("CuentaContable" + c);
		cuentaContable.setEjercicioContable(ejercicioContable);
		cuentaContable.setIntegra(integra);
		cuentaContable.setCuentaJerarquia(cuentaJerarquia);
		cuentaContable.setImputable(new Random().nextBoolean());
		cuentaContable.setAjustaPorInflacion(new Random().nextBoolean());
		cuentaContable.setCuentaContableEstado(new Random().nextBoolean());
		cuentaContable.setCuentaConApropiacion(new Random().nextBoolean());

		List<CentroCostoContable> itemsCentroCostoContableTemp = new ArrayList<CentroCostoContable>();
		for (CentroCostoContable centroCostoContable : itemsCentroCostoContable) {
			if (centroCostoContable.getEjercicioContable().getNumero()
					.equals(cuentaContable.getEjercicioContable().getNumero())) {
				itemsCentroCostoContableTemp.add(centroCostoContable);
			}
		}
		cuentaContable.setCentroCostoContable(new Random().nextBoolean() ? null
				: itemsCentroCostoContableTemp.get(getIntegerRandom(0, itemsCentroCostoContableTemp.size() - 1)));

		cuentaContable.setCuentaAgrupadora(new Random().nextBoolean() ? null : "CuentaContable" + c);
		cuentaContable.setPorcentaje(getDoubleRandom(0.0, 100.0, false));

		List<PuntoEquilibrio> itemsPuntoEquilibrioTemp = new ArrayList<PuntoEquilibrio>();
		for (PuntoEquilibrio puntoEquilibrio : itemsPuntoEquilibrio) {
			if (puntoEquilibrio.getEjercicioContable().getNumero()
					.equals(cuentaContable.getEjercicioContable().getNumero())) {
				itemsPuntoEquilibrioTemp.add(puntoEquilibrio);
			}
		}
		cuentaContable.setPuntoEquilibrio(new Random().nextBoolean() ? null
				: itemsPuntoEquilibrioTemp.get(getIntegerRandom(0, itemsPuntoEquilibrioTemp.size() - 1)));

		cuentaContable.setCostoVenta(new Random().nextBoolean() ? null
				: itemsCostoVenta.get(getIntegerRandom(0, itemsCostoVenta.size() - 1)));
		cuentaContable.setSeguridadPuerta(new Random().nextBoolean() ? null
				: itemsSeguridadPuerta.get(getIntegerRandom(0, itemsSeguridadPuerta.size() - 1)));

		return cuentaContable;
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