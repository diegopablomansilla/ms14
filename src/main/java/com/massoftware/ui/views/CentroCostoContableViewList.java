package com.massoftware.ui.views;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.b.service.CentroCostoContableService;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.MainView;
import com.massoftware.ui.forms.CentroCostoContableFilterForm;
import com.massoftware.ui.forms.CentroCostoContableFormCard;
import com.massoftware.ui.grids.CentroCostoContableGrid;
import com.massoftware.ui.util.FormDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Centro de costo")
//@Route("CentroCostoContable")
@Route(value = "CentroCostoContable", layout = MainView.class)
@CssImport("styles/views/CentroCostoContable/CentroCostoContable-mdv.css")
public class CentroCostoContableViewList extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private CentroCostoContableService service;

	// ---------------------------------------------------------------------------------------------------------------------------

	private VerticalLayout listView;

	private CentroCostoContableFilterForm filterForm;
	private CentroCostoContableGrid grid;
	private CentroCostoContableFormCard formCard;

	private Div editorDivCard;
	private SplitLayout splitLayout;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableViewList() {

		this.setId("CentroCostoContable-mdv");
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

		splitLayout = new SplitLayout();
		splitLayout.setSizeFull();
		listView.add(splitLayout);

		initGrid();
		initFormCard();

		add(listView);
	}

	private void initFormFilter() {

		filterForm = new CentroCostoContableFilterForm() {

			private static final long serialVersionUID = 1797632226724653961L;

			public void searchData() {
				if (splitLayout.getSecondaryComponent() != null) {
//					formCard.load(new CentroCostoContable());
					splitLayout.addToSecondary(new Div());

				}
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
//				openFormDialog(item);
			}

			/**
			 * 
			 */
			private static final long serialVersionUID = 4427741862102211289L;

		};
		grid.setWidthFull();
		grid.setHeightFull();

		Div wrapper = new Div();

		wrapper.setId("wrapper");
		wrapper.setWidthFull();
		wrapper.setHeightFull();

		splitLayout.addToPrimary(wrapper);

		wrapper.add(grid);

		grid.asSingleSelect().addValueChangeListener(event -> {

			if (event.getValue() != null) {
				formCard.load(event.getValue());
//				formCard.search(event.getValue().getId());
				splitLayout.addToSecondary(editorDivCard);
			} else {
//				formCard.load(new CentroCostoContable());
				splitLayout.addToSecondary(new Div());
			}

		});

		grid.focus();

	}

	private void initFormCard() {

		formCard = new CentroCostoContableFormCard(service) {

			protected void open(CentroCostoContable item) {
				openFormDialog(item);
			}

			public boolean save() {
				boolean b = super.save();
				if (b) {
					splitLayout.addToSecondary(new Div());
					grid.refreshAll();
				}

				return b;
			}

			protected boolean delete(CentroCostoContable item) {
				boolean b = super.delete(item);
				if (b) {
					splitLayout.addToSecondary(new Div());
					grid.refreshAll();
				}

				return b;
			}

			/**
			 * 
			 */
			private static final long serialVersionUID = 4427741862102211289L;

		};

		editorDivCard = new Div();
		editorDivCard.setId("editor-layout");

		splitLayout.addToSecondary(editorDivCard);

		editorDivCard.add(formCard);
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
				splitLayout.addToSecondary(new Div());
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