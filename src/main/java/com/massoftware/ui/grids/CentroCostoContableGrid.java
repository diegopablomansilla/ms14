package com.massoftware.ui.grids;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.b.service.CentroCostoContableFilterQ1;
import com.massoftware.b.service.CentroCostoContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.ui.GridCustom;
import com.massoftware.ui.NotificationError;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;


public class CentroCostoContableGrid extends GridCustom<CentroCostoContable> {

	// ---------------------------------------------------------------------------------------------------------------------------

	private CentroCostoContableFilterQ1 filter;
	private CentroCostoContableService service;

	private Integer lastCount;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableGrid(CentroCostoContableService service, CentroCostoContableFilterQ1 filter) {
		super(CentroCostoContable.class, false);
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

		addColumn(CentroCostoContable::getId, "id").setKey("id").setSortProperty("1").setHeader("ID").setVisible(false);

//		addColumn(CentroCostoContable::toString, "toString").setKey("toString").setSortProperty("2")
//				.setHeader("Centro de costo").setVisible(false);

		// --------------------------------------------------------------------------------------------------
		
		addColumn(CentroCostoContable::getNumero, "numero").setKey("numero").setResizable(true).setSortProperty("2").setHeader("Nº cc");		
		addColumn(CentroCostoContable::getAbreviatura, "abreviatura").setKey("abreviatura").setResizable(true).setSortProperty("4").setHeader("Abreviatura");
		addColumn(CentroCostoContable::getNombre, "nombre").setKey("nombre").setResizable(true).setSortProperty("3").setHeader("Nombre");
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

	protected List<CentroCostoContable> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {

			if (orderBy == null) {
				orderBy = 2;
				orderByDesc = true;
			}

			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<CentroCostoContable> items = service.find(filter);

//			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
//					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo buscar los ítems !!");
		}

		return new ArrayList<CentroCostoContable>();
	}
	
	protected boolean removeItemFromService(CentroCostoContable item) {

		try {
			service.deleteById(item.getId());

			Notification notification = new Notification("Centro de costo " + item + " borrado con éxito.", 1000,
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