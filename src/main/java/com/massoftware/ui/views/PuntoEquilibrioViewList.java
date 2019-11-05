package com.massoftware.ui.views;

import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.b.service.PuntoEquilibrioService;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.MainView;
import com.massoftware.ui.forms.PuntoEquilibrioFilterForm;
import com.massoftware.ui.forms.PuntoEquilibrioFormCard;
import com.massoftware.ui.grids.PuntoEquilibrioGrid;
import com.massoftware.ui.util.FormDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Punto equilibrio")
//@Route("PuntoEquilibrio")
@Route(value = "PuntoEquilibrio", layout = MainView.class)
@CssImport("styles/views/PuntoEquilibrio/PuntoEquilibrio-mdv.css")
public class PuntoEquilibrioViewList extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private PuntoEquilibrioService service;

	// ---------------------------------------------------------------------------------------------------------------------------

	private VerticalLayout listView;	

	private PuntoEquilibrioFilterForm filterForm;
	private PuntoEquilibrioGrid grid;
	private PuntoEquilibrioFormCard formCard;	

	private Div editorDivCard;
	private SplitLayout splitLayout;	

	// ---------------------------------------------------------------------------------------------------------------------------

	public PuntoEquilibrioViewList() {

		this.setId("PuntoEquilibrio-mdv");
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
		service = new PuntoEquilibrioService(GlobalProperties.getDataBaseKey());
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

		filterForm = new PuntoEquilibrioFilterForm() {

			private static final long serialVersionUID = 1797632226724653961L;

			public void searchData() {
				if (splitLayout.getSecondaryComponent() != null) {
//					formCard.load(new PuntoEquilibrio());
					splitLayout.addToSecondary(new Div());

				}
				grid.refreshAll();
			}
			
			protected void newItem() {
				
				PuntoEquilibrio newItem = new PuntoEquilibrio();
				newItem.setEjercicioContable(getFilter().getEjercicioContable());

				openFormDialog(newItem);
			}

		};

		listView.add(filterForm);
	}

	private void initGrid() {

		grid = new PuntoEquilibrioGrid(service, filterForm.getFilter()) {

			protected void open(PuntoEquilibrio item) {
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
//				formCard.load(new PuntoEquilibrio());
				splitLayout.addToSecondary(new Div());
			}

		});

		grid.focus();

	}

	private void initFormCard() {
		
		formCard = new PuntoEquilibrioFormCard(service) {

			protected void open(PuntoEquilibrio item) {
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
			
			protected boolean delete(PuntoEquilibrio item) {
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

	private void openFormDialog(PuntoEquilibrio item) {

		PuntoEquilibrioFormCard form = new PuntoEquilibrioFormCard(service, false);				
		
//		form.search(item.getId());
		FormDialog formDialog = new FormDialog();
		formDialog.setTitle("Punto equilibrio");
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
		
//		form.focusControl();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -7865021065577903474L;

} // END CLASS -----------------------------------------------------------------