package com.massoftware.ui.grids;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.b.service.EjercicioContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.ui.GridCustom;
import com.massoftware.ui.NotificationError;
import com.massoftware.ui.UIUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LocalDateRenderer;

public class EjerciciosContablesGrid extends GridCustom<EjercicioContable> {

	// ---------------------------------------------------------------------------------------------------------------------------

	private EjercicioContableFilterQ1 filter;
	private EjercicioContableService service;

	private Integer lastCount;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjerciciosContablesGrid(EjercicioContableService service, EjercicioContableFilterQ1 filter) {
		super(EjercicioContable.class, false);
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

		addColumn(EjercicioContable::getId, "id").setKey("id").setSortProperty("1").setHeader("ID").setVisible(false);

//		addColumn(EjercicioContable::toString, "toString").setKey("toString").setSortProperty("2")
//				.setHeader("Ejercicio").setVisible(false);

		// --------------------------------------------------------------------------------------------------

		addColumn(new ComponentRenderer<>(ejercicioContable -> {
			return new H5(ejercicioContable.getNumero() + "");
		})).setKey("numero").setResizable(true).setSortProperty("2").setHeader("Nº ejercicio");

//		addColumn(EjercicioContable::getNumero, "numero").setKey("numero").setResizable(true).setSortProperty("2").setHeader("Nº ejercicio");

//		addColumn(EjercicioContable::getApertura, "apertura").setKey("apertura").setResizable(true).setSortProperty("3")
//				.setHeader("Apertura");

		addColumn(new LocalDateRenderer<>(EjercicioContable::getApertura, "dd-MMM-yy", new Locale("es")))
				.setKey("apertura").setResizable(true).setSortProperty("3").setHeader("Apertura");

//		addColumn(EjercicioContable::getCierre, "cierre").setKey("cierre").setResizable(true).setSortProperty("4")
//		.setHeader("Cierre");

		addColumn(new LocalDateRenderer<>(EjercicioContable::getCierre, "dd-MMM-yy", new Locale("es"))).setKey("cierre")
				.setResizable(true).setSortProperty("4").setHeader("Cierre");

		addColumn(new ComponentRenderer<>(this::createRendererCerrado)).setKey("cerrado").setResizable(true)
				.setSortProperty("5").setHeader("Ejercicio cerrado");

		addColumn(new ComponentRenderer<>(this::createRendererCerradoModulos)).setKey("cerradoModulos")
				.setResizable(true).setSortProperty("6").setHeader("Módulos cerrados");

	}

	private Component createRendererCerrado(EjercicioContable item) {
		return (item.getCerrado() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
	}

	private Component createRendererCerradoModulos(EjercicioContable item) {
		return (item.getCerradoModulos() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
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

	protected List<EjercicioContable> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {

			if (orderBy == null) {
				orderBy = 2;
				orderByDesc = true;
			}

			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<EjercicioContable> items = service.find(filter);

//			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
//					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo buscar los ítems !!");
		}

		return new ArrayList<EjercicioContable>();
	}

	protected boolean removeItemFromService(EjercicioContable item) {

		boolean r = false;

		try {
			r = service.deleteById(item.getId());
		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo borrar el ítem !!");			
		}

		Notification notification = new Notification("Ejercicio " + item.getNumero() + " guardado con éxito.", 1000,
				Position.BOTTOM_END);
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		notification.open();

		return r;
	}

	// --------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177350093300330440L;

} // END CLASS -----------------------------------------------------------------