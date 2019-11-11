package com.massoftware.ui.selectlist;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.b.service.CentroCostoContableService;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.forms.CentroCostoContableFilterForm;
import com.massoftware.ui.forms.CentroCostoContableFormCard;
import com.massoftware.ui.grids.CentroCostoContableGrid;
import com.massoftware.ui.util.FormDialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

//@PageTitle("Centro de costo")
//@Route("CentroCostoContable")
//@Route(value = "CentroCostoContable", layout = MainView.class)
public class CentroCostoContableSelectList extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private CentroCostoContableService service;

	// ---------------------------------------------------------------------------------------------------------------------------

	private VerticalLayout listView;

	private CentroCostoContableFilterForm filterForm;
	public CentroCostoContableGrid grid;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableSelectList() {

		this.setHeightFull();
//		this.setPadding(false);
//		this.setMargin(false);
		this.setSpacing(false);

		initService();
		initListView();

		filterForm.search();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initService() {
		DataBases.setup();
		service = new CentroCostoContableService(GlobalProperties.getDataBaseKey());
	}

	private void initListView() {

		listView = new VerticalLayout();
		listView.setHeightFull();
		listView.setPadding(false);
		listView.setMargin(false);
		listView.setSpacing(false);

		initFormFilter();

		initGrid();

		add(listView);
	}

	private void initFormFilter() {

		filterForm = new CentroCostoContableFilterForm() {

			private static final long serialVersionUID = 1797632226724653961L;

			public void searchData() {
				grid.refreshAll();
			}

			protected void newItem() {

				CentroCostoContable newItem = new CentroCostoContable();
				newItem.setEjercicioContable(getFilter().getEjercicioContable());

				openFormDialog(newItem);
			}

		};

		listView.add(filterForm);
	}

	private void initGrid() {

		grid = new CentroCostoContableGrid(service, filterForm.getFilter()) {

			protected void open(CentroCostoContable item) {
				openFormDialog(item);
			}

			/**
			 * 
			 */
			private static final long serialVersionUID = 4427741862102211289L;

		};
		
		listView.add(grid);

		grid.asSingleSelect().addValueChangeListener(event -> {

			if (event.getValue() != null) {

			} else {

			}

		});
		
		grid.showToolBarColumn = true;
		grid.addColumnToolBar();

		grid.focus();

	}

	private void openFormDialog(CentroCostoContable item) {

		CentroCostoContableFormCard form = new CentroCostoContableFormCard(service, false);

//		form.search(item.getId());
		FormDialog formDialog = new FormDialog();
		formDialog.setTitle("Centro de costo");
		formDialog.setContent(form);
		formDialog.addConfirmationListener(buttonClickEvent -> {
			boolean b = form.save();
			if (b) {
				grid.refreshAll();
				formDialog.close();
			}
		});
		formDialog.setSizeFull();
//		Page page = this.getUI().get().getPage();

		formDialog.open();

		form.load(item);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -7865021065577903474L;

} // END CLASS -----------------------------------------------------------------