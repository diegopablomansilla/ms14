package com.massoftware.ui.grids;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.b.service.CuentaContableFilterQ1;
import com.massoftware.b.service.CuentaContableService;
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

//		String formatted = "";
//
//		if (item.getCuentaJerarquia() != null && item.getCuentaJerarquia().length() == 11) {
//
//			for (int i = 0; i < 11; i++) {
//
//				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
//					formatted += ".";
//				}
//				formatted += item.getCuentaJerarquia().charAt(i);
//
////				if (i == 0) {
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 1) {
////					formatted += ".";
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 2) {
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 3) {
////					formatted += ".";
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 4) {
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 5) {
////					formatted += ".";
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 6) {
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 7) {
////					formatted += ".";
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 8) {
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 9) {
////					formatted += ".";
////					formatted += item.getCuentaJerarquia().charAt(i);
////				} else if (i == 10) {
////					formatted += item.getCuentaJerarquia().charAt(i);
////				}
//			}
//
//		} else if (item.getCuentaJerarquia() != null && item.getCuentaJerarquia().length() != 11) {
//
//			return new H5(item.getCuentaJerarquia());
//		}

		return new H5(UIUtils.formtatCC(item.getCuentaJerarquia()));
	}

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