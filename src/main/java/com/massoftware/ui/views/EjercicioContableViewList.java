package com.massoftware.ui.views;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.b.service.EjercicioContableService;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.FormDialog;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.MainView;
import com.massoftware.ui.forms.EjercicioContableFilterForm;
import com.massoftware.ui.forms.EjercicioContableFormCard;
import com.massoftware.ui.grids.EjerciciosContablesGrid;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Ejercicios")
//@Route("EjerciciosContables")
@Route(value = "EjerciciosContables", layout = MainView.class)
@CssImport("styles/views/ejercicio-contable/ejercicio-contable-mdv.css")
public class EjercicioContableViewList extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private EjercicioContableService service;

	// ---------------------------------------------------------------------------------------------------------------------------

	private VerticalLayout listView;

	private EjercicioContableFilterForm filterForm;
	private EjerciciosContablesGrid grid;
	private EjercicioContableFormCard formCard;

	private Div editorDivCard;
	private SplitLayout splitLayout;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableViewList() throws Exception {

		this.setId("ejercicio-contable-mdv");
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
		service = new EjercicioContableService(GlobalProperties.getDataBaseKey());
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

		filterForm = new EjercicioContableFilterForm() {

			private static final long serialVersionUID = 1797632226724653961L;

			public void searchData() {
				if (splitLayout.getSecondaryComponent() != null) {
//					formCard.load(new EjercicioContable());
					splitLayout.addToSecondary(new Div());

				}
				grid.refreshAll();
			}

			protected void newItem() {

				openFormDialog(new EjercicioContable());
			}

		};

		listView.add(filterForm);
	}

	private void initGrid() {

		grid = new EjerciciosContablesGrid(service, filterForm.getFilter()) {

			protected void open(EjercicioContable item) {
//				openFormDialog(item);
			}

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
//				formCard.load(event.getValue());	
//				formCard.search(event.getValue().getId());
//				event.getValue().setNumero(null);
				formCard.load(event.getValue());
				splitLayout.addToSecondary(editorDivCard);
			} else {
//				formCard.load(new EjercicioContable());
				splitLayout.addToSecondary(new Div());
			}

		});

		grid.focus();

	}

	private void initFormCard() {

		formCard = new EjercicioContableFormCard(service) {

			protected void open(EjercicioContable item) {
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

			protected boolean delete(EjercicioContable item) {
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

	private void openFormDialog(EjercicioContable item) {

		EjercicioContableFormCard form = new EjercicioContableFormCard(service, false);

//		form.search(item.getId());
		FormDialog formDialog = new FormDialog();
		formDialog.setTitle("Ejercicio contable");
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