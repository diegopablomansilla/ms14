package com.massoftware.ui.forms;

import java.util.Optional;
import java.util.stream.Collectors;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.b.service.CuentaContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.dao.ds.ex.DeleteForeignKeyViolationException;
import com.massoftware.ui.ConfirmationDialog;
import com.massoftware.ui.NotificationError;
import com.massoftware.ui.UIUtils;
import com.massoftware.ui.cbx.CentroCostoContableCBXH;
import com.massoftware.ui.cbx.CostoVentaCBX;
import com.massoftware.ui.cbx.PuntoEquilibrioCBXH;
import com.massoftware.ui.cbx.SeguridadPuertaCBX;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
//import com.massoftware.ui.cbx.EjercicioContableCBX;
//import com.massoftware.ui.cbx.IntegraCBX;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;

public class CuentaContableFormCard extends Div {

	// ---------------------------------------------------------------------------------------------------------------------------

	private H3 title;
	private Button buttonOpen;

	// ---------------------------------------------------------------------------------------------------------------------------

	private CuentaContableService service;

	// Binder
	private Binder<CuentaContable> binder;

	// Control's
	private FormLayout formGeneral;
	private FormLayout formCC;
	private FormLayout formSeguridad;
	private HorizontalLayout actions;
	private HorizontalLayout actions2;
	private Button saveButton;
	private Button deleteButton;

	private boolean header;

	private H5 mascaraPadrePrefix;
	private H5 mascaraPadreSufix;
	private H5 mascaraHijoPrefix;
	private H5 mascaraHioSufix;

	private TextField codigo;
	private TextField nombre;
//	private EjercicioContableCBX ejercicioContable;
//	private IntegraCBX integra;	
	private TextField cuentaJerarquia;
	private Checkbox imputable;
	private Checkbox ajustaPorInflacion;
	private Checkbox cuentaContableEstado;
	private Checkbox cuentaConApropiacion;
	private CentroCostoContableCBXH centroCostoContable;
	private TextField cuentaAgrupadora;
	private NumberField porcentaje;
	private PuntoEquilibrioCBXH puntoEquilibrio;
	private CostoVentaCBX costoVenta;
	private SeguridadPuertaCBX seguridadPuerta;

	private Accordion accordion;
	private AccordionPanel ccPanel;

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaContableFormCard(CuentaContableService service) {
		this.header = true;
		init(service);
	}

	public CuentaContableFormCard(CuentaContableService service, boolean header) {
		this.header = header;
		init(service);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void init(CuentaContableService service) {
		this.service = service;
		initBinder();
		if (header) {
			createHeader();
		}
		initForm();
		this.setHeightFull();

//		resetFormCC();

		if (cuentaContableEstado.getValue() == true) {
			cuentaContableEstado.setLabel("1. Cuentas en uso");
		} else {
			cuentaContableEstado.setLabel("0. Cuentas fuera de uso");
		}

		codigo.focus();
	}

	private void initBinder() {
		binder = new Binder<>(CuentaContable.class);
//		binder.addStatusChangeListener(event -> {
//			boolean isValid = event.getBinder().isValid();
//			boolean hasChanges = event.getBinder().hasChanges();
//			saveButton.setEnabled(hasChanges && isValid);
//			resetButton.setEnabled(hasChanges);
//		});
	}

	private void createHeader() {
		this.title = new H3("Cuenta contable");
		this.title.setWidthFull();

		buttonOpen = new Button();
		buttonOpen.setIcon(new Icon(VaadinIcon.EXTERNAL_LINK));
		buttonOpen.addThemeVariants(ButtonVariant.LUMO_SMALL);
		buttonOpen.addClickListener(buttonClickEvent -> open());

		HorizontalLayout header = new HorizontalLayout();
		header.setWidthFull();
		header.setPadding(false);
		header.setMargin(false);
//		header.setSpacing(false);

//		Div d = new Div();
//		d.setWidthFull();

		header.add(this.title, buttonOpen);
//		header.setFlexGrow(1, this.title);
//		header.setAlignItems(FlexComponent.Alignment.CENTER);
		header.setAlignItems(Alignment.END);
//		header.getStyle().set("background-color", "green");
		add(header);
	}

	private void open() {
		open(this.binder.getBean());
	}

	protected void open(CuentaContable item) {

	}

	private void initForm() {

		accordion = new Accordion();
		accordion.setWidthFull();

		// -------------------------------------------------------------------
		// Controls
		// -------------------------------------------------------------------

		CuentaContableFormUtil utilForm = new CuentaContableFormUtil();

		HorizontalLayout mascaraPadre = new HorizontalLayout();
		mascaraPadre.setPadding(false);
		mascaraPadre.setMargin(false);
		mascaraPadre.setSpacing(false);
		mascaraPadrePrefix = new H5();
		mascaraPadreSufix = new H5();
		mascaraPadreSufix.getStyle().set("color", "#9e9e9e");
		mascaraPadre.add(mascaraPadrePrefix, mascaraPadreSufix);

		HorizontalLayout mascaraHijo = new HorizontalLayout();
		mascaraHijo.setPadding(false);
		mascaraHijo.setMargin(false);
		mascaraHijo.setSpacing(false);
		mascaraHijoPrefix = new H5();
		mascaraHijoPrefix.getStyle().set("color", "#9e9e9e");
		mascaraHioSufix = new H5();
		mascaraHijo.add(mascaraHijoPrefix, mascaraHioSufix);

		HorizontalLayout mascara = new HorizontalLayout();
		mascara.setPadding(false);
		mascara.setMargin(false);
//		mascara.setSpacing(false);
		mascara.add(mascaraPadre, mascaraHijo);		
		
		codigo = utilForm.initCodigo(binder);
		nombre = utilForm.initNombre(binder);
//		ejercicioContable = utilForm.initEjercicioContable(binder);
//		integra = utilForm.initIntegra(binder);

		cuentaJerarquia = utilForm.initCuentaJerarquia(binder);
//		cuentaJerarquia.addKeyPressListener(Key.ENTER, event -> {
//			search();
//		});
		
		cuentaJerarquia.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				mascaraHijoPrefix.setText("0.00.00.00.00.00");
			} else {

				String padre = "";
				if (binder.getBean().getIntegra() != null
						&& binder.getBean().getIntegra().getCuentaJerarquia() != null) {
					padre = binder.getBean().getIntegra().getCuentaJerarquia();
				}
				String hijo = event.getValue();

				// ---------------

				String padrePprefixSufix = UIUtils.formtatCCIntegraPrefixSufix(padre);

				if (padrePprefixSufix != null && padrePprefixSufix.trim().length() > 0) {
					String padrePprefixSufixArray[] = padrePprefixSufix.split(";");
					String padrePrefix = padrePprefixSufixArray[0];
					String padreSufix = "." + padrePprefixSufixArray[1];

//					
					mascaraPadrePrefix.setText(padrePrefix);
					mascaraPadreSufix.setText(padreSufix);
				} else {
					
					mascaraPadrePrefix.setText("");
//					mascaraPadreSufix.setText("");
					mascaraPadreSufix.setText("0.00.00.00.00.00");
				}
				
				String hijoPprefixSufix = UIUtils.formtatCCPrefixSufix(hijo);
				
				if (hijoPprefixSufix != null && hijoPprefixSufix.trim().length() > 0) {
					String hijoPprefixSufixArray[] = hijoPprefixSufix.split(";");
					String hijoPrefix = hijoPprefixSufixArray[0];
					String hijoSufix = hijoPprefixSufixArray[1];
					if(hijoPrefix.length() > 0) {
						hijoPrefix = hijoPrefix + ".";
					}

					mascaraHijoPrefix.setText(hijoPrefix);
					mascaraHioSufix.setText(hijoSufix);
				} else {
					mascaraHijoPrefix.setText("");
					mascaraHioSufix.setText("");
				}

				
				

			}
		});
//		cuentaJerarquia.addBlurListener(event -> {
//			search();
//		});

		imputable = utilForm.initImputable(binder);
		imputable.addValueChangeListener(event -> {
			resetFormCC();
		});
		ajustaPorInflacion = utilForm.initAjustaPorInflacion(binder);
		cuentaContableEstado = utilForm.initCuentaContableEstado(binder);
		cuentaConApropiacion = utilForm.initCuentaConApropiacion(binder);
		centroCostoContable = utilForm.initCentroCostoContableH(binder);
		cuentaAgrupadora = utilForm.initCuentaAgrupadora(binder);
		porcentaje = utilForm.initPorcentaje(binder);
		puntoEquilibrio = utilForm.initPuntoEquilibrioH(binder);
		costoVenta = utilForm.initCostoVenta(binder);
		seguridadPuerta = utilForm.initSeguridadPuerta(binder);

		// -------------------------------------------------------------------
		// Layout's
		// -------------------------------------------------------------------

		formGeneral = new FormLayout();
		formGeneral.setWidthFull();

		accordion.add("General", formGeneral);

		formGeneral.add(mascara);
		formGeneral.add(cuentaJerarquia);
		formGeneral.add(codigo);		
		formGeneral.add(nombre);
//		form.add(ejercicioContable);			
		formGeneral.add(imputable);
		formGeneral.add(ajustaPorInflacion);
		formGeneral.add(cuentaConApropiacion);
		formGeneral.add(cuentaContableEstado);

		// ----

		formCC = new FormLayout();
		formCC.setWidthFull();

		ccPanel = accordion.add("Centro de costos", formCC);

		formCC.add(centroCostoContable);
		formCC.add(cuentaAgrupadora);
		formCC.add(porcentaje);
		formCC.add(puntoEquilibrio);
		formCC.add(costoVenta);
		formCC.add(seguridadPuerta);

		// ----

		formSeguridad = new FormLayout();
		formSeguridad.setWidthFull();

		accordion.add("Seguridad", formSeguridad);

		formSeguridad.add(seguridadPuerta);

		// ----

		add(accordion);

		// ----

		if (header) {
			createButtonLayout();
		}

	}

	private void createButtonLayout() {
		saveButton = new Button("Guardar");
		saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		saveButton.addClickListener(event -> {
			save();
		});

		deleteButton = new Button();
		deleteButton.setIcon(new Icon(VaadinIcon.TRASH));
		deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
		deleteButton.addClickListener(event -> {
			delete();
		});

		actions = new HorizontalLayout();
		actions.setId("button-layout");
		actions.setWidthFull();
		actions.setSpacing(true);
//		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

		actions.add(saveButton);
		add(actions);

		actions2 = new HorizontalLayout();
		actions2.setId("button-layout");
		actions2.setWidthFull();
		actions2.setSpacing(true);

		actions2.add(deleteButton);
		add(actions2);

		actions2.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void load(CuentaContable item) {

		binder.setBean(item);

		centroCostoContable.cbx.filter.setEjercicioContable(binder.getBean().getEjercicioContable());
		puntoEquilibrio.cbx.filter.setEjercicioContable(binder.getBean().getEjercicioContable());

//		ccPanel.setEnabled(imputable.getValue());

		binder.validate();

		if (binder.isValid() == false) {
			BinderValidationStatus<CuentaContable> validate = binder.validate();
			String errorText = validate.getFieldValidationStatuses().stream().filter(BindingValidationStatus::isError)
					.map(BindingValidationStatus::getMessage).map(Optional::get).distinct()
					.collect(Collectors.joining(", "));

			Notification notification = new Notification(
					"El ítem tiene uno o mas valores del ítem son incorrectos. " + errorText, 3000,
					Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
			notification.open();
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void search(String id) {
		try {
			CuentaContable item = service.findById(id);
			if (item != null) {

				Notification notification = new Notification("Cuenta contable " + item + " cargado con éxito.", 1000,
						Position.BOTTOM_END);
				notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
				notification.open();

				load(item);
			}
		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo buscar el ítem !!");
		}
	}

	public boolean save() {

		if (binder.validate().isOk()) {
			try {
				CuentaContable item = service.save(binder.getBean());

				Notification notification = new Notification("Cuenta contable " + item + " guardado con éxito.", 1000,
						Position.BOTTOM_END);
				notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
				notification.open();

				return true;

			} catch (Exception500 e) {
				new NotificationError(e, "No se pudo guardar el ítem !!");
			}
		}

		return false;
	}

	public void delete() {

		if (binder.validate().isOk()) {

			ConfirmationDialog confirmationDialog = new ConfirmationDialog();
			confirmationDialog.setTitle("¿ Estás seguro, quieres borrar el ítem ?");
			confirmationDialog.setQuestion(binder.getBean() != null ? binder.getBean().toString() : "");
			confirmationDialog.addConfirmationListener(buttonClickEvent -> {
				delete(binder.getBean());
			});
			confirmationDialog.open();

		}

	}

	protected boolean delete(CuentaContable item) {

		try {
			service.deleteById(item.getId());

			Notification notification = new Notification("Cuenta contable " + item + " borrado con éxito.", 1000,
					Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
			notification.open();

			return true;

		} catch (Exception500 e) {

			if (e.getException() instanceof DeleteForeignKeyViolationException) {

				Notification notification = new Notification(
						"Cuenta contable " + item + " NO se puede borrar. El ítem tiene otros objetos relacionados.",
						2000, Position.BOTTOM_END);
				notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
				notification.open();

			} else {
				new NotificationError(e, "No se pudo borrar el ítem !!");
			}
		}

		return false;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void resetFormCC() {
		ccPanel.setEnabled(imputable.getValue());

		if (imputable.getValue() == false) {
			centroCostoContable.cbx.setValue(null);
			puntoEquilibrio.cbx.setValue(null);
			porcentaje.setValue(null);
			cuentaAgrupadora.setValue("");
			costoVenta.setValue(null);

//			binder.getBean().setCentroCostoContable(null);
//			binder.getBean().setPuntoEquilibrio(null);
//			binder.getBean().setPorcentaje(null);
//			binder.getBean().setCuentaAgrupadora(null);
//			binder.getBean().setCostoVenta(null);
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 6782973177012383676L;

} // END CLASS -----------------------------------------------------------------