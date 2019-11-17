package com.massoftware.ui.selectlist;

import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.b.service.PuntoEquilibrioService;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.FormDialog;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.forms.PuntoEquilibrioFilterForm;
import com.massoftware.ui.forms.PuntoEquilibrioFormCard;
import com.massoftware.ui.grids.PuntoEquilibrioGrid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

//@PageTitle("Punto equilibrio")
//@Route("PuntoEquilibrio")
//@Route(value = "PuntoEquilibrio", layout = MainView.class)
public class PuntoEquilibrioSelectList extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private PuntoEquilibrioService service;

	// ---------------------------------------------------------------------------------------------------------------------------

	private VerticalLayout listView;

	private PuntoEquilibrioFilterForm filterForm;
	public PuntoEquilibrioGrid grid;

	// ---------------------------------------------------------------------------------------------------------------------------

	public PuntoEquilibrioSelectList() {

		this.setHeightFull();
//		this.setPadding(false);
//		this.setMargin(false);
//		this.setSpacing(false);

		initService();
		initListView();

		filterForm.search();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initService() {
		DataBases.setup();
		service = new PuntoEquilibrioService(GlobalProperties.getDataBaseKey());
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

		filterForm = new PuntoEquilibrioFilterForm() {

			private static final long serialVersionUID = 1797632226724653961L;

			public void searchData() {
				grid.refreshAll();
			}

			protected void newItem() {

				PuntoEquilibrio newItem = new PuntoEquilibrio();
//				newItem.setEjercicioContable(getFilter().getEjercicioContable());

				openFormDialog(newItem);
			}

		};

		listView.add(filterForm);
	}

	private void initGrid() {

		grid = new PuntoEquilibrioGrid(service, filterForm.getFilter()) {

			protected void open(PuntoEquilibrio item) {
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

	private void openFormDialog(PuntoEquilibrio item) {

		PuntoEquilibrioFormCard form = new PuntoEquilibrioFormCard(service, false);

//		form.search(item.getId());
		FormDialog formDialog = new FormDialog();
		formDialog.setTitle("Punto equilibrio");
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