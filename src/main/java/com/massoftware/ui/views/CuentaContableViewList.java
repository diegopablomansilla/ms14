package com.massoftware.ui.views;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.b.service.CuentaContableService;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.FormDialog;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.MainView;
import com.massoftware.ui.forms.CuentaContableFilterForm;
import com.massoftware.ui.forms.CuentaContableFormCard;
import com.massoftware.ui.grids.CuentaContableGrid;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Cuenta contable")
//@Route("CuentaContable")
@Route(value = "CuentaContable", layout = MainView.class)
@CssImport("styles/views/CuentaContable/CuentaContable-mdv.css")
public class CuentaContableViewList extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private CuentaContableService service;

	// ---------------------------------------------------------------------------------------------------------------------------

	private VerticalLayout listView;	

	private CuentaContableFilterForm filterForm;
	private CuentaContableGrid grid;
	private CuentaContableFormCard formCard;	

	private Div editorDivCard;
	private SplitLayout splitLayout;	

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableViewList() {

		this.setId("CuentaContable-mdv");
		this.setHeightFull();
//		this.setPadding(false);
//		this.setMargin(false);
		this.setSpacing(false);

		initService();
		initListView();

//		filterForm.cuentaContableEstado.setValue(true);
		filterForm.search();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initService() {
		DataBases.setup();
		service = new CuentaContableService(GlobalProperties.getDataBaseKey());
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

		filterForm = new CuentaContableFilterForm() {

			private static final long serialVersionUID = 1797632226724653961L;

			public void searchData() {
				if (splitLayout.getSecondaryComponent() != null) {
//					formCard.load(new CuentaContable());
					splitLayout.addToSecondary(new Div());

				}
				grid.refreshAll();
			}
			
			protected void newItem() {
				
				openFormDialog(new CuentaContable());
			}

		};

		listView.add(filterForm);		
	}

	private void initGrid() {

		grid = new CuentaContableGrid(service, filterForm.getFilter()) {

			protected void open(CuentaContable item) {
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
//				formCard.load(event.getValue());	
				formCard.search(event.getValue().getId());
				splitLayout.addToSecondary(editorDivCard);
				formCard.resetFormCC();
				
			} else {
//				formCard.load(new CuentaContable());
				splitLayout.addToSecondary(new Div());
			}

		});

		grid.focus();

	}

	private void initFormCard() {
		
		formCard = new CuentaContableFormCard(service) {

			protected void open(CuentaContable item) {
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
			
			protected boolean delete(CuentaContable item) {
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

	private void openFormDialog(CuentaContable item) {

		CuentaContableFormCard form = new CuentaContableFormCard(service, false);				
		
//		form.search(item.getId());
		FormDialog formDialog = new FormDialog();
		formDialog.setTitle("Cuenta contable");
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