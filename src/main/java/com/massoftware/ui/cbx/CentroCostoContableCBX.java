package com.massoftware.ui.cbx;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.b.service.CentroCostoContableFilterQ1;
import com.massoftware.b.service.CentroCostoContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.cbx.util.ComboBoxCustom;
import com.massoftware.ui.selectlist.CentroCostoContableSelectList;
import com.massoftware.ui.util.FormDialog;
import com.massoftware.ui.util.NotificationError;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;

public class CentroCostoContableCBX extends ComboBoxCustom<CentroCostoContable> {

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableFilterQ1 filter;
	private CentroCostoContableService service;

	private Integer lastCount;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableCBX() {
		this.filter = new CentroCostoContableFilterQ1();
		this.service = new CentroCostoContableService(GlobalProperties.getDataBaseKey());
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer getLastCount() {
		return lastCount;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected Integer countFromService(String filterText) {

		try {

			if (filterText != null) {
				filterText = filterText.trim();
			}

			try {
				filter.setNombre(null);
				filter.setNumeroFrom(Integer.valueOf(filterText));
				filter.setNumeroTo(filter.getNumeroFrom());
			} catch (Exception x) {
				filter.setNombre(filterText);
				filter.setNumeroFrom(null);
				filter.setNumeroTo(filter.getNumeroFrom());
			}

			lastCount = service.count(filter);
			return lastCount;
		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo contar la cantidad ítems !!");
		}

		return 0;
	}

	protected List<CentroCostoContable> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc,
			String filterText) {

		try {

			if (orderBy == null) {
				orderBy = 2;
				orderByDesc = true;
			}

			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			if (filterText != null) {
				filterText = filterText.trim();
			}

			try {
				filter.setNombre(null);
				filter.setNumeroFrom(Integer.valueOf(filterText));
				filter.setNumeroTo(filter.getNumeroFrom());
			} catch (Exception x) {
				filter.setNombre(filterText);
				filter.setNumeroFrom(null);
				filter.setNumeroTo(filter.getNumeroFrom());
			}

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

			Notification notification = new Notification("Punto equilibrio " + item + " borrado con éxito.", 1000,
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

	protected void openFormDialog() {

		CentroCostoContableSelectList listView = new CentroCostoContableSelectList();

//			form.search(item.getId());
		FormDialog formDialog = new FormDialog();
		formDialog.setTitle("Seleccionar " + this.getLabel());
		formDialog.setContent(listView);
		formDialog.confirm.setText("Seleccionar");
		formDialog.addConfirmationListener(buttonClickEvent -> {

			CentroCostoContable item = listView.grid.asSingleSelect().getValue();
			if (item != null) {
				this.setValue(item);
				formDialog.close();
			}
		});
		formDialog.setSizeFull();
//			Page page = this.getUI().get().getPage();

		formDialog.open();

	}

	// --------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177350093300330440L;

} // END CLASS -----------------------------------------------------------------