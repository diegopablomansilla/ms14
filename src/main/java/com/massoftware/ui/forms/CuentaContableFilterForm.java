package com.massoftware.ui.forms;

import com.massoftware.b.service.EmpresaService;
import com.massoftware.b.service.cuentacontable.CuentaContableFilterQ1;
//import com.massoftware.b.service.PuntoEquilibrioFilterQ1;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.GlobalProperties;
import com.massoftware.ui.NotificationError;
import com.massoftware.ui.UIUtils;
import com.massoftware.ui.cbx.CentroCostoContableCBX;
import com.massoftware.ui.cbx.CentroCostoContableCBXH;
import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
//import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
//import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CuentaContableFilterForm extends VerticalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private EmpresaService empresaService;

	// ---------------------------------------------------------------------------------------------------------------------------

	private CuentaContableFilterQ1 lastFilter;
	// private CuentaContableFilterQ1 filter;
	private Binder<CuentaContableFilterQ1> binder;

	// ---------------------------------------------------------------------------------------------------------------------------

//	private TextField fts;

	private HorizontalLayout row1;
	private HorizontalLayout row2;

	private H4 ejercicioContable;

	private TextField codigo;
	private TextField nombre;
	private TextField cuentaJerarquia;
//	private Checkbox imputable;
//	private Checkbox ajustaPorInflacion;
//	public Checkbox cuentaContableEstado;
//	private Checkbox cuentaConApropiacion;
	private TextField cuentaAgrupadora;
//	private NumberField porcentajeFrom;
//	private NumberField porcentajeTo;

	private CentroCostoContableCBXH centroCostoContable;

	private Button newButton;
	private Button findButton;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableFilterForm() {

		initBinder();
		initFilterRows();

		initService();

		binder.setBean(new CuentaContableFilterQ1());
		findEjercicioFromService();

		centroCostoContable.cbx.filter.setEjercicioContable(binder.getBean().getEjercicioContable());

		nombre.focus();

//		binder.getBean().setCuentaContableEstado(true);
//		cuentaContableEstado.setValue(true);

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableFilterQ1 getFilter() {
		return binder.getBean();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initService() {
		DataBases.setup();
		empresaService = new EmpresaService(GlobalProperties.getDataBaseKey());
	}

	private void initBinder() {
//		filter = new CuentaContableFilterQ1();
		binder = new Binder<>(CuentaContableFilterQ1.class);
	}

	private void initFilterRows() {

		row1 = new HorizontalLayout();
		row2 = new HorizontalLayout();

		this.add(row1, row2);

		// Controls ------------------------

//		initFTS();

		ejercicioContable = new H4();

		initCodigo();
		initNombre();
		initCuentaJerarquia();
//		initImputable();
//		initAjustaPorInflacion();
//		initCuentaContableEstado();
//		initCuentaConApropiacion();
		initCuentaAgrupadora();
//		initPorcentajeFrom();
//		initPorcentajeTo();
		initCentroCostoContable();

		// -------------------------------------------------------------------

		Span s = new Span();
		s.setWidthFull();

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
		row2.add(cuentaJerarquia, codigo, nombre, cuentaAgrupadora, centroCostoContable, /*cuentaContableEstado,*/
				findButton, newButton);
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
//		binder.forField(fts).bind(CuentaContableFilterQ1::getFts, CuentaContableFilterQ1::setFts);
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

	private void initCodigo() {

		// Cuenta contable

		codigo = new TextField();
		codigo.setPlaceholder("Cuenta contable");
		codigo.setPrefixComponent(VaadinIcon.SEARCH.create());
		codigo.setClearButtonVisible(true);
//		codigo.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(codigo)
//				.asRequired(codigo.getLabel() + " es requerido.")		
				.bind(CuentaContableFilterQ1::getCodigo, CuentaContableFilterQ1::setCodigo);

		// --------------------------------------------

		codigo.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		codigo.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		codigo.addBlurListener(event -> {
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
				.bind(CuentaContableFilterQ1::getNombre, CuentaContableFilterQ1::setNombre);

		// --------------------------------------------

		nombre.addKeyPressListener(Key.ENTER, event -> {
			binder.validate();
			search();
		});
		nombre.addValueChangeListener(event -> {
			binder.validate();
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		nombre.addBlurListener(event -> {
			binder.validate();
			search();
		});
	}

	private void initCuentaJerarquia() {

		// Cuenta de jerarquia

		cuentaJerarquia = new TextField();
		cuentaJerarquia.setPlaceholder("Jerarquia");
		cuentaJerarquia.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaJerarquia.setClearButtonVisible(true);
//		cuentaJerarquia.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(cuentaJerarquia)
//				.asRequired(cuentaJerarquia.getPlaceholder() + " es requerido.")		
				.bind(CuentaContableFilterQ1::getCuentaJerarquia, CuentaContableFilterQ1::setCuentaJerarquia);

		// --------------------------------------------

		cuentaJerarquia.addKeyPressListener(Key.ENTER, event -> {
			binder.validate();
			search();
		});
		cuentaJerarquia.addValueChangeListener(event -> {
			binder.validate();
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		cuentaJerarquia.addBlurListener(event -> {
			binder.validate();
			search();
		});
	}

//	private void initImputable() {
//
//		// Imputable
//
//		imputable = new Checkbox();
//		imputable.setLabel("Imputable");
////		imputable.setHeightFull();
//		imputable.setWidthFull();
//
//		// --------------------------------------------
//
//		binder.forField(imputable).bind(CuentaContableFilterQ1::getImputable, CuentaContableFilterQ1::setImputable);
//
//		// --------------------------------------------
//
//		imputable.addValueChangeListener(event -> {
//			search();
//		});
//		imputable.addBlurListener(event -> {
//			search();
//		});
//	}

//	private void initAjustaPorInflacion() {
//
//		// Ajusta por inflación
//
//		ajustaPorInflacion = new Checkbox();
//		ajustaPorInflacion.setLabel("Ajusta por inflación");
////		ajustaPorInflacion.setHeightFull();
//		ajustaPorInflacion.setWidthFull();
//
//		// --------------------------------------------
//
//		binder.forField(ajustaPorInflacion).bind(CuentaContableFilterQ1::getAjustaPorInflacion,
//				CuentaContableFilterQ1::setAjustaPorInflacion);
//
//		// --------------------------------------------
//
//		ajustaPorInflacion.addValueChangeListener(event -> {
//			search();
//		});
//		ajustaPorInflacion.addBlurListener(event -> {
//			search();
//		});
//	}

//	private void initCuentaContableEstado() {
//
//		// Estado
//
//		cuentaContableEstado = new Checkbox();
//		cuentaContableEstado.setLabel("Estado");
////		cuentaContableEstado.setHeightFull();
//		cuentaContableEstado.setWidthFull();
////		cuentaContableEstado.setIndeterminate(true);
//
//		// --------------------------------------------
//
//		binder.forField(cuentaContableEstado).bind(CuentaContableFilterQ1::getCuentaContableEstado,
//				CuentaContableFilterQ1::setCuentaContableEstado);
//
//		// --------------------------------------------
//
//		cuentaContableEstado.addValueChangeListener(event -> {
//			search();
//			if (event.getValue() == true) {
//				cuentaContableEstado.setLabel("1. Cuentas en uso");
//			} else {
//				cuentaContableEstado.setLabel("0. Cuentas fuera de uso");
//			}
//		});
//		cuentaContableEstado.addBlurListener(event -> {
//			search();
//		});
//
//		// --------------------------------------------
//
//		if (cuentaContableEstado.getValue() == true) {
//			cuentaContableEstado.setLabel("1. Cuentas en uso");
//		} else {
//			cuentaContableEstado.setLabel("0. Cuentas fuera de uso");
//		}
//	}

//	private void initCuentaConApropiacion() {
//
//		// Cuenta con apropiación
//
//		cuentaConApropiacion = new Checkbox();
//		cuentaConApropiacion.setLabel("Cuenta con apropiación");
////		cuentaConApropiacion.setHeightFull();
//		cuentaConApropiacion.setWidthFull();
//
//		// --------------------------------------------
//
//		binder.forField(cuentaConApropiacion).bind(CuentaContableFilterQ1::getCuentaConApropiacion,
//				CuentaContableFilterQ1::setCuentaConApropiacion);
//
//		// --------------------------------------------
//
//		cuentaConApropiacion.addValueChangeListener(event -> {
//			search();
//		});
//		cuentaConApropiacion.addBlurListener(event -> {
//			search();
//		});
//	}

	private void initCuentaAgrupadora() {

		// Cuenta agrupadora

		cuentaAgrupadora = new TextField();
		cuentaAgrupadora.setPlaceholder("Cuenta agrupadora");
		cuentaAgrupadora.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaAgrupadora.setClearButtonVisible(true);
//		cuentaAgrupadora.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(cuentaAgrupadora)
//				.asRequired(cuentaAgrupadora.getLabel() + " es requerido.")		
				.bind(CuentaContableFilterQ1::getCuentaAgrupadora, CuentaContableFilterQ1::setCuentaAgrupadora);

		// --------------------------------------------

		cuentaAgrupadora.addKeyPressListener(Key.ENTER, event -> {
			binder.validate();
			search();
		});
		cuentaAgrupadora.addValueChangeListener(event -> {
			binder.validate();
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		cuentaAgrupadora.addBlurListener(event -> {
			binder.validate();
			search();
		});
	}

//	private void initPorcentajeFrom() {
//
//		// Porcentaje desde
//
//		porcentajeFrom = new NumberField();
//		porcentajeFrom.setPlaceholder("Porcentaje desde");
//		porcentajeFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
//		porcentajeFrom.setClearButtonVisible(true);
////		porcentajeFrom.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);
//
//		// --------------------------------------------
//
//		binder.forField(porcentajeFrom)
////				.asRequired(porcentajeFrom.getLabel() + " es requerido.")				
////				.withConverter(new DoubleToLongConverter())
//				.withValidator(value -> (value != null) ? value >= 0.0 : true, "El valor tiene que ser >= " + 0.0)
//				.withValidator(value -> (value != null) ? value <= 999.99 : true, "El valor tiene que ser <= " + 999.99)
//				.bind(CuentaContableFilterQ1::getPorcentajeFrom, CuentaContableFilterQ1::setPorcentajeFrom);
//
//		// --------------------------------------------
//
//		porcentajeFrom.addKeyPressListener(Key.ENTER, event -> {
//			search();
//		});
//		porcentajeFrom.addValueChangeListener(event -> {
//			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
//				search();
//			}
//		});
//		porcentajeFrom.addBlurListener(event -> {
//			search();
//		});
//	}

//	private void initPorcentajeTo() {
//
//		// Porcentaje hasta
//
//		porcentajeTo = new NumberField();
//		porcentajeTo.setPlaceholder("Porcentaje hasta");
//		porcentajeTo.setPrefixComponent(VaadinIcon.SEARCH.create());
//		porcentajeTo.setClearButtonVisible(true);
////		porcentajeTo.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);
//
//		// --------------------------------------------
//
//		binder.forField(porcentajeTo)
////				.asRequired(porcentajeTo.getLabel() + " es requerido.")				
////				.withConverter(new DoubleToLongConverter())
//				.withValidator(value -> (value != null) ? value >= 0.0 : true, "El valor tiene que ser >= " + 0.0)
//				.withValidator(value -> (value != null) ? value <= 999.99 : true, "El valor tiene que ser <= " + 999.99)
//				.bind(CuentaContableFilterQ1::getPorcentajeTo, CuentaContableFilterQ1::setPorcentajeTo);
//
//		// --------------------------------------------
//
//		porcentajeTo.addKeyPressListener(Key.ENTER, event -> {
//			search();
//		});
//		porcentajeTo.addValueChangeListener(event -> {
//			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
//				search();
//			}
//		});
//		porcentajeTo.addBlurListener(event -> {
//			search();
//		});
//	}

//	public CentroCostoContableCBX initCentroCostoContable() {
//
//		// Centro costo contable
//
//		centroCostoContable = new CentroCostoContableCBX();
//
////		centroCostoContable.setLabel("Centro costo contable");
//		centroCostoContable.setPlaceholder("Centro costo contable");
//		centroCostoContable.setWidthFull();
//		centroCostoContable.setClearButtonVisible(true);
////		centroCostoContable.setItemLabelGenerator(PuntoEquilibrio::getNombre);
//
//		// --------------------------------------------
//
//		binder.forField(centroCostoContable)
////				.asRequired(centroCostoContable.getLabel() + " es requerido.")
//				.bind(CuentaContableFilterQ1::getCentroCostoContable, CuentaContableFilterQ1::setCentroCostoContable);
//
//		// --------------------------------------------
//		
//		centroCostoContable.addValueChangeListener(event -> {
//			if (event.getValue() != null && event.getValue().toString().trim().length() > 0) {
//				search();
//			}
//		});
//		centroCostoContable.addBlurListener(event -> {
//			search();
//		});
//
//		// --------------------------------------------
//
//		return centroCostoContable;
//	}
	
	public void initCentroCostoContable() {

		// Centro costo contable

		CentroCostoContableCBX cbx = new CentroCostoContableCBX();

//		cbx.setLabel("Centro costo contable");
		cbx.setPlaceholder("Centro costo contable");
		cbx.setWidthFull();
		cbx.setClearButtonVisible(true);
//		cbx.setItemLabelGenerator(CuentaContable::getNombre);

		// --------------------------------------------

		binder.forField(cbx)
//				.asRequired(cbx.getLabel() + " es requerido.")
				.bind(CuentaContableFilterQ1::getCentroCostoContable, CuentaContableFilterQ1::setCentroCostoContable);

		// --------------------------------------------
		
		cbx.addValueChangeListener(event -> {
			binder.validate();
			if (event.getValue() != null && event.getValue().toString().trim().length() > 0) {
				search();
			}
		});
		cbx.addBlurListener(event -> {
			binder.validate();
			search();
		});

		// --------------------------------------------
		
		centroCostoContable = new CentroCostoContableCBXH(cbx);
		
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void search() {

		binder.validate();

		if (this.binder.getBean().equals(this.lastFilter) == false) {
			this.lastFilter = (CuentaContableFilterQ1) this.binder.getBean().clone();
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