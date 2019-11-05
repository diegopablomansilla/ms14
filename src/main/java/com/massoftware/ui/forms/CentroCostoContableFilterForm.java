package com.massoftware.ui.forms;

import com.massoftware.b.service.CentroCostoContableFilterQ1;
import com.massoftware.b.service.EmpresaService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.massoftware.ui.util.NotificationError;
import com.massoftware.ui.util.UIUtils;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CentroCostoContableFilterForm extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------
	
	private EmpresaService empresaService;

	// ---------------------------------------------------------------------------------------------------------------------------

	private CentroCostoContableFilterQ1 lastFilter;
//	private CentroCostoContableFilterQ1 filter;
	private Binder<CentroCostoContableFilterQ1> binder;

	// ---------------------------------------------------------------------------------------------------------------------------

//	private TextField fts;

	private HorizontalLayout row1;
	private HorizontalLayout row2;

	private H3 ejercicioContable;
	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField nombre;
	private TextField abreviatura;

	private Button newButton;
	private Button findButton;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableFilterForm() {

		initBinder();
		initFilterRows();
		initService();

		binder.setBean(new CentroCostoContableFilterQ1());
		findEjercicioFromService();
		
		nombre.focus();

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public CentroCostoContableFilterQ1 getFilter() {
		return binder.getBean();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initService() {
		DataBases.setup();
		empresaService = new EmpresaService(GlobalProperties.getDataBaseKey());
	}

	private void initBinder() {
//		filter = new CentroCostoContableFilterQ1();
//		lastFilter = filter; 
		binder = new Binder<>(CentroCostoContableFilterQ1.class);
	}

	private void initFilterRows() {

		row1 = new HorizontalLayout();
		row2 = new HorizontalLayout();

		this.add(row1, row2);

		// Controls ------------------------

//		initFTS();

		ejercicioContable = new H3();
		initNumeroFrom();
		initNumeroTo();
		initNombre();
		initAbreviatura();

		// -------------------------------------------------------------------

//		Span s = new Span();
//		s.setWidthFull();

		// Button New ítem
		newButton = new Button();
		UIUtils.setTooltip("Nuevo", newButton);
		newButton.setIcon(VaadinIcon.PLUS.create());
		newButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		newButton.addClickListener(event -> {
			newItem();
		});

		// Button Search ítem's
		findButton = new Button();
		UIUtils.setTooltip("Buscar", findButton);
		findButton.setIcon(VaadinIcon.SEARCH.create());
		findButton.addClickListener(event -> {
			search();
		});

		// Layout ------------------------

		this.setWidthFull();
		this.setSpacing(false);
		this.setMargin(false);
		this.setPadding(false);

		row1.setWidthFull();
//		row1.setSpacing(true);
		row1.setMargin(false);
		row1.setPadding(false);
		row1.add(ejercicioContable);
		row1.setAlignItems(Alignment.CENTER);

		row2.setWidthFull();
//		row2.setSpacing(true);
		row2.setMargin(false);
		row2.setPadding(false);
		row2.add(numeroFrom, numeroTo, abreviatura, nombre, findButton, newButton);
		row2.setAlignItems(Alignment.CENTER);

		// -------------------------------------------------------------------
	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	private void initFTS() {
//
//		// Full Text Search
//
//		fts = new TextField();
//		fts.setPlaceholder("Buscar...");
//		fts.setPrefixComponent(VaadinIcon.SEARCH.create());
//		fts.setClearButtonVisible(true);
//		fts.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
//
//		// --------------------------------------------
//
//		binder.forField(fts).bind(CentroCostoContableFilterQ1::getFts, CentroCostoContableFilterQ1::setFts);
//
//		// --------------------------------------------
//
//		fts.addKeyPressListener(Key.ENTER, event -> {
//			search();
//		});
//		fts.addValueChangeListener(event -> {
//			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
//				search();
//			}
//		});
//		fts.addBlurListener(event -> {
//			search();
//		});
//	}

	private void initNumeroFrom() {

		// Nº cc desde

		numeroFrom = new NumberField();
		numeroFrom.setPlaceholder("Nº cc desde");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
//		numeroFrom.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(numeroFrom)
//				.asRequired(numeroFrom.getLabel() + " es requerido.")		
				.withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= " + 1)
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						"El valor tiene que ser <= " + Integer.MAX_VALUE)
				.bind(CentroCostoContableFilterQ1::getNumeroFrom, CentroCostoContableFilterQ1::setNumeroFrom);

		// --------------------------------------------

		numeroFrom.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		numeroFrom.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		numeroFrom.addBlurListener(event -> {
			search();
		});
	}

	private void initNumeroTo() {

		// Nº cc hasta

		numeroTo = new NumberField();
		numeroTo.setPlaceholder("Nº cc hasta");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
//		numeroTo.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(numeroTo)
//				.asRequired(numeroTo.getLabel() + " es requerido.")		
				.withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= " + 1)
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						"El valor tiene que ser <= " + Integer.MAX_VALUE)
				.bind(CentroCostoContableFilterQ1::getNumeroTo, CentroCostoContableFilterQ1::setNumeroTo);

		// --------------------------------------------

		numeroTo.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		numeroTo.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		numeroTo.addBlurListener(event -> {
			search();
		});
	}

	private void initNombre() {

		// Nombre

		nombre = new TextField();
		nombre.setPlaceholder("Nombre");
		nombre.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombre.setClearButtonVisible(true);
		nombre.setWidthFull();
//		nombre.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(nombre)
//				.asRequired(nombre.getLabel() + " es requerido.")		
				.bind(CentroCostoContableFilterQ1::getNombre, CentroCostoContableFilterQ1::setNombre);

		// --------------------------------------------

		nombre.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		nombre.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		nombre.addBlurListener(event -> {
			search();
		});
	}

	private void initAbreviatura() {

		// Abreviatura

		abreviatura = new TextField();
		abreviatura.setPlaceholder("Abreviatura");
		abreviatura.setPrefixComponent(VaadinIcon.SEARCH.create());
		abreviatura.setClearButtonVisible(true);
//		abreviatura.setWidthFull();
//		abreviatura.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(abreviatura)
//				.asRequired(abreviatura.getLabel() + " es requerido.")		
				.bind(CentroCostoContableFilterQ1::getAbreviatura, CentroCostoContableFilterQ1::setAbreviatura);

		// --------------------------------------------

		abreviatura.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		abreviatura.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		abreviatura.addBlurListener(event -> {
			search();
		});
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void search() {

		binder.validate();

		if (this.binder.getBean().equals(this.lastFilter) == false) {
			this.lastFilter = (CentroCostoContableFilterQ1) this.binder.getBean().clone();
			if (binder.isValid()) {
				searchData();
			} else {
				Notification notification = new Notification("Uno o mas valores del filtro son incorrectos.", 1000,
						Position.BOTTOM_START);
				notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
				notification.open();
			}
//			if (binder.validate().isOk()) {
//				searchData();
//			} else {
//				Notification notification = new Notification("Uno o mas valores del filtro son incorrectos.", 1000,
//						Position.BOTTOM_START);
//				notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
//				notification.open();
//			}
		}
	}

	protected void searchData() {
//		grid.refreshAll();
	}

	protected void newItem() {
	}

	// --------------------------------------------------------------------------------------------------

	protected void findEjercicioFromService() {

		try {

			binder.getBean().setEjercicioContable(empresaService.find().getEjercicioContable());
			ejercicioContable.setText("Ejercicio contable " + binder.getBean().getEjercicioContable().getNumero());

		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo buscar los ítems !!");
		}

	}

	// --------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 5868954652393992267L;

} // END CLASS -----------------------------------------------------------------