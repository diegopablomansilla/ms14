package com.massoftware.ui.grids;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.CuentaJerarquia;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ1;
import com.massoftware.b.service.cuentacontable.CuentaContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.ui.GridCustom;
import com.massoftware.ui.NotificationError;
import com.massoftware.ui.UIUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class CuentaContableGrid extends GridCustom<CuentaContable> {

	// ---------------------------------------------------------------------------------------------------------------------------

	private CuentaContableFilterQ1 filter;
	private CuentaContableService service;

	private Integer lastCount;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableGrid(CuentaContableService service, CuentaContableFilterQ1 filter) {
		super(CuentaContable.class, false);
		this.filter = filter;
		this.service = service;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer getLastCount() {
		return lastCount;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected void addColumns() {

		// --------------------------------------------------------------------------------------------------

		addColumn(CuentaContable::getId, "id").setKey("id").setSortProperty("1").setHeader("ID").setVisible(false);

//		addColumn(CuentaContable::toString, "toString").setKey("toString").setSortProperty("2")
//				.setHeader("Cuenta contable").setVisible(false);

		// --------------------------------------------------------------------------------------------------

//		addColumn(CuentaContable::getCuentaJerarquia, "cuentaJerarquia").setKey("cuentaJerarquia").setResizable(true)
//				.setSortProperty("6").setHeader("Cuenta de jerarquia");
		addColumn(new ComponentRenderer<>(this::createRendererCuentaJerarquia)).setKey("cuentaJerarquia")
				.setResizable(true).setSortProperty("6").setHeader("Cuenta de jerarquia");

		addColumn(new ComponentRenderer<>(cuentaContable -> {
			return new H5(cuentaContable.getCodigo() + "");
		})).setKey("codigo").setResizable(true).setSortProperty("2").setHeader("Cuenta contable");
//		addColumn(CuentaContable::getCodigo, "codigo").setKey("codigo").setResizable(true).setSortProperty("2")
//				.setHeader("Cuenta contable");

		addColumn(CuentaContable::getNombre, "nombre").setKey("nombre").setResizable(true).setSortProperty("3")
				.setHeader("Nombre");

//		addColumn(CuentaContable::getEjercicioContable, "ejercicioContable").setKey("ejercicioContable").setResizable(true).setSortProperty("4").setHeader("Ejercicio");
//		addColumn(CuentaContable::getIntegra, "integra").setKey("integra").setResizable(true).setSortProperty("5").setHeader("Integra");

//		addColumn(new ComponentRenderer<>(this::createRendererImputable)).setKey("imputable").setResizable(true).setSortProperty("7").setHeader("Imputable");
//		addColumn(new ComponentRenderer<>(this::createRendererAjustaPorInflacion)).setKey("ajustaPorInflacion").setResizable(true).setSortProperty("8").setHeader("Ajusta por inflación");

//		addColumn(new ComponentRenderer<>(this::createRendererCuentaConApropiacion)).setKey("cuentaConApropiacion").setResizable(true).setSortProperty("10").setHeader("Cuenta con apropiación");
		addColumn(CuentaContable::getCentroCostoContable, "centroCostoContable").setKey("centroCostoContable")
				.setResizable(true).setSortProperty("11").setHeader("Centro costo contable");
		addColumn(CuentaContable::getCuentaAgrupadora, "cuentaAgrupadora").setKey("cuentaAgrupadora").setResizable(true)
				.setSortProperty("12").setHeader("Cuenta agrupadora");

//		addColumn(CuentaContable::getPorcentaje, "porcentaje").setKey("porcentaje").setResizable(true)
//				.setSortProperty("13").setHeader("Porcentaje");
//		addColumn(new NumberRenderer<>(CuentaContable::getPorcentaje, "% %(,.2f", Locale.US, "% 0.00"))
//				.setKey("porcentaje").setResizable(true).setSortProperty("13").setHeader("Porcentaje");
		addColumn(new ComponentRenderer<>(this::createRendererPorcenaje)).setKey("porcentaje").setResizable(true)
				.setSortProperty("13").setHeader("Porcentaje");

//		addColumn(CuentaContable::getPuntoEquilibrio, "puntoEquilibrio").setKey("puntoEquilibrio").setResizable(true).setSortProperty("14").setHeader("Punto de equilibrio");
//		addColumn(CuentaContable::getCostoVenta, "costoVenta").setKey("costoVenta").setResizable(true).setSortProperty("15").setHeader("Costo de venta");
//		addColumn(CuentaContable::getSeguridadPuerta, "seguridadPuerta").setKey("seguridadPuerta").setResizable(true).setSortProperty("16").setHeader("Puerta");

		addColumn(new ComponentRenderer<>(this::createRendererCuentaContableEstado)).setKey("cuentaContableEstado")
				.setResizable(true).setSortProperty("9").setHeader("1. En uso");

	}

//	private Component createRendererImputable(CuentaContable item) {
//		return (item.getImputable() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
//				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
//	}

//	private Component createRendererAjustaPorInflacion(CuentaContable item) {
//		return (item.getAjustaPorInflacion() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
//				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
//	}

	private Component createRendererCuentaContableEstado(CuentaContable item) {
		return (item.getCuentaContableEstado() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
	}

//	private Component createRendererCuentaConApropiacion(CuentaContable item) {
//		return (item.getCuentaConApropiacion() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
//				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
//	}

	private Component createRendererPorcenaje(CuentaContable item) {
		String formatted = "";

		if (item.getPorcentaje() != null) {

			NumberFormat nf = DecimalFormat.getInstance(Locale.US);
			DecimalFormat decimalFormatter = (DecimalFormat) nf;
			decimalFormatter.applyPattern("#.##");
			formatted = decimalFormatter.format(item.getPorcentaje()) + " %";
		}

		return new Label(formatted);
	}

	private Component createRendererCuentaJerarquia(CuentaContable item) {
//		HorizontalLayout mascaraHijo = new HorizontalLayout();
//		mascaraHijo.setPadding(false);
//		mascaraHijo.setMargin(false);
//		mascaraHijo.setSpacing(false);
//
//		H5 s0Jerarquia = new H5("_");
//		H5 s1Jerarquia = new H5("__");
//		H5 s2Jerarquia = new H5("__");
//		H5 s3Jerarquia = new H5("__");
//		H5 s4Jerarquia = new H5("__");
//		H5 s5Jerarquia = new H5("__");
//		
//		
//		setColorJerarquia(item.getCuentaJerarquia(), s0Jerarquia, s1Jerarquia, s2Jerarquia, s3Jerarquia, s4Jerarquia,
//				s5Jerarquia);
//		
//		mascaraHijo.add(s0Jerarquia, new H5("."), s1Jerarquia, new H5("."), s2Jerarquia, new H5("."), s3Jerarquia,
//				new H5("."), s4Jerarquia, new H5("."), s5Jerarquia);


//		return mascaraHijo;
		return new H5(CuentaJerarquia.formtatCC(item.getCuentaJerarquia()));
	}

//	private void setColorJerarquia(String cuentaJerarquiaString, H5 s0Jerarquia, H5 s1Jerarquia, H5 s2Jerarquia,
//			H5 s3Jerarquia, H5 s4Jerarquia, H5 s5Jerarquia) {
//
//		CuentaJerarquia cj = new CuentaJerarquia(cuentaJerarquiaString, null);
//		System.out.println(cuentaJerarquiaString);
//
//		setColorOk(s0Jerarquia);
//		setColorOk(s1Jerarquia);
//		setColorOk(s2Jerarquia);
//		setColorOk(s3Jerarquia);
//		setColorOk(s4Jerarquia);
//		setColorOk(s5Jerarquia);
//
//		if (cj.p0 == null || cj.p0NumberError || cj.p0ValueError || cj.isLengthMayor11Error) { // en las rayitas
//			setColorRed(s0Jerarquia);
//		} else {
//			setColorOk(s0Jerarquia);
//		}
//
//		if (cj.p1 == null || cj.p1NumberError || cj.p1ValueError || cj.isLengthMayor11Error) { // en las rayitas
//			setColorRed(s1Jerarquia);
//		} else {
//			setColorOk(s1Jerarquia);
//		}
//
//		if (cj.p2 == null || cj.p2NumberError || cj.p2ValueError || cj.isLengthMayor11Error) { // en las rayitas
//			setColorRed(s2Jerarquia);
//		} else {
//			setColorOk(s2Jerarquia);
//		}
//
//		if (cj.p3 == null || cj.p3NumberError || cj.p3ValueError || cj.isLengthMayor11Error) { // en las rayitas
//			setColorRed(s3Jerarquia);
//		} else {
//			setColorOk(s3Jerarquia);
//		}
//
//		if (cj.p4 == null || cj.p4NumberError || cj.p4ValueError || cj.isLengthMayor11Error) { // en las rayitas
//			setColorRed(s4Jerarquia);
//		} else {
//			setColorOk(s4Jerarquia);
//		}
//
//		if (cj.p5 == null || cj.p5NumberError || cj.p5ValueError || cj.isLengthMayor11Error) { // en las rayitas
//			setColorRed(s5Jerarquia);
//		} else {
//			setColorOk(s5Jerarquia);
//		}
//
//		if (cj.isError() == false) {
//
//			if (cj.p5ValueSufix) {
//				setColorOk(s5Jerarquia);
//			} else {
//				setColorGrey(s5Jerarquia);
//			}
//
//			if (cj.p4ValueSufix) {
//				setColorOk(s4Jerarquia);
//				setColorOk(s5Jerarquia);
//			} else {
//				setColorGrey(s4Jerarquia);
//			}
//
//			if (cj.p3ValueSufix) {
//				setColorOk(s3Jerarquia);
//				setColorOk(s4Jerarquia);
//				setColorOk(s5Jerarquia);
//			} else {
//				setColorGrey(s3Jerarquia);
//			}
//
//			if (cj.p2ValueSufix) {
//				setColorOk(s2Jerarquia);
//				setColorOk(s3Jerarquia);
//				setColorOk(s4Jerarquia);
//				setColorOk(s5Jerarquia);
//			} else {
//				setColorGrey(s2Jerarquia);
//			}
//
//			if (cj.p1ValueSufix) {
//				setColorOk(s1Jerarquia);
//				setColorOk(s2Jerarquia);
//				setColorOk(s3Jerarquia);
//				setColorOk(s4Jerarquia);
//				setColorOk(s5Jerarquia);
//			} else {
//				setColorGrey(s1Jerarquia);
//			}
//
//			if (cj.p0ValueSufix) {
//				setColorOk(s0Jerarquia);
//				setColorOk(s1Jerarquia);
//				setColorOk(s2Jerarquia);
//				setColorOk(s3Jerarquia);
//				setColorOk(s4Jerarquia);
//				setColorOk(s5Jerarquia);
//			} else {
//				setColorGrey(s0Jerarquia);
//			}
//
//		}
//	}
//
//	private void setColorRed(H5 h) {
//		h.getStyle().set("color", "#f44336");
//	}
//
//	private void setColorGrey(H5 h) {
//		h.getStyle().set("color", "#9e9e9e");
//	}
//
//	private void setColorOk(H5 h) {
//		h.getStyle().set("color", "#000000");
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected Integer countFromService() {

		try {
			lastCount = service.count(filter);
			return lastCount;
		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo contar la cantidad ítems !!");
		}

		return 0;
	}

	protected List<CuentaContable> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {

			if (orderBy == null) {
				orderBy = 6;
				orderByDesc = false;
			}

			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<CuentaContable> items = service.find(filter);

//			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
//					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo buscar los ítems !!");
		}

		return new ArrayList<CuentaContable>();
	}

	protected boolean removeItemFromService(CuentaContable item) {

		try {
			service.deleteById(item.getId());

			Notification notification = new Notification("Cuenta contable " + item + " borrado con éxito.", 1000,
					Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
			notification.open();

			return true;

		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo borrar el ítem !!");
		}

		return false;
	}

	// --------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177350093300330440L;

} // END CLASS -----------------------------------------------------------------