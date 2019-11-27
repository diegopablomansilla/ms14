package com.massoftware.ui.forms;

import java.util.Optional;
import java.util.stream.Collectors;

import com.massoftware.a.model.CuentaContable;
import com.massoftware.a.model.CuentaJerarquia;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCodigoExistsEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCodigoIsLengthMayor11ErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCodigoIsNullEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaExistsEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsCharsNotNumberErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsEmptyEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsIntegraEqualsErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsLengthMayor11ErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsLengthMinor11ErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsNullEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveCuentaJerarquiaIsValueErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveEjercicioContableIsNullEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveIntegraNotExistsEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveIsNullEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveNombreExistsEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveNombreIsLengthMayor50ErrorEx;
import com.massoftware.b.service.cuentacontable.CuentaContableSaveNombreIsNullEx;
import com.massoftware.b.service.cuentacontable.CuentaContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.dao.ds.ex.DeleteForeignKeyViolationException;
import com.massoftware.ui.ConfirmationDialog;
import com.massoftware.ui.NotificationError;
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

	private H5 s0Integra;
	private H5 s1Integra;
	private H5 s2Integra;
	private H5 s3Integra;
	private H5 s4Integra;
	private H5 s5Integra;

	private H5 s0Jerarquia;
	private H5 s1Jerarquia;
	private H5 s2Jerarquia;
	private H5 s3Jerarquia;
	private H5 s4Jerarquia;
	private H5 s5Jerarquia;

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

//		codigo.focus();
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

		s0Integra = new H5("_");
		s1Integra = new H5("__");
		s2Integra = new H5("__");
		s3Integra = new H5("__");
		s4Integra = new H5("__");
		s5Integra = new H5("__");

		mascaraPadre.add(s0Integra, new H5("."), s1Integra, new H5("."), s2Integra, new H5("."), s3Integra, new H5("."),
				s4Integra, new H5("."), s5Integra);

		HorizontalLayout mascaraHijo = new HorizontalLayout();
		mascaraHijo.setPadding(false);
		mascaraHijo.setMargin(false);
		mascaraHijo.setSpacing(false);

		s0Jerarquia = new H5("_");
		s1Jerarquia = new H5("__");
		s2Jerarquia = new H5("__");
		s3Jerarquia = new H5("__");
		s4Jerarquia = new H5("__");
		s5Jerarquia = new H5("__");

		mascaraHijo.add(s0Jerarquia, new H5("."), s1Jerarquia, new H5("."), s2Jerarquia, new H5("."), s3Jerarquia,
				new H5("."), s4Jerarquia, new H5("."), s5Jerarquia);

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
		cuentaJerarquia.addValueChangeListener(event -> {
			setColorJerarquia(event.getValue());
		});

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

	private void setColorJerarquia(String cuentaJerarquiaString) {

		CuentaJerarquia cj = new CuentaJerarquia(cuentaJerarquiaString,
				(binder.getBean().getIntegra() != null ? binder.getBean().getIntegra().getCuentaJerarquia() : null));

		s0Jerarquia.setText(cj.s0);
		s1Jerarquia.setText(cj.s1);
		s2Jerarquia.setText(cj.s2);
		s3Jerarquia.setText(cj.s3);
		s4Jerarquia.setText(cj.s4);
		s5Jerarquia.setText(cj.s5);

		setColorOk(s0Jerarquia);
		setColorOk(s1Jerarquia);
		setColorOk(s2Jerarquia);
		setColorOk(s3Jerarquia);
		setColorOk(s4Jerarquia);
		setColorOk(s5Jerarquia);

		setColorOk(s0Integra);
		setColorOk(s1Integra);
		setColorOk(s2Integra);
		setColorOk(s3Integra);
		setColorOk(s4Integra);
		setColorOk(s5Integra);

//		cuentaJerarquia.setLabel(cj.integra + " --> " + cj.integraCompute + " --> " + cj.formatIntegra
//				+ " | isIntegraEqualsError: " + cj.isIntegraEqualsError);

		if (cj.p0 == null || cj.p0NumberError || cj.p0ValueError || cj.isLengthMayor11Error) { // en las rayitas
			setColorRed(s0Jerarquia);
//			setColorRed(s0Integra);
		} else {
			setColorOk(s0Jerarquia);
//			setColorOk(s0Integra);
		}

		if (cj.p1 == null || cj.p1NumberError || cj.p1ValueError || cj.isLengthMayor11Error) { // en las rayitas
			setColorRed(s1Jerarquia);
//			setColorRed(s1Integra);
		} else {
			setColorOk(s1Jerarquia);
//			setColorOk(s1Integra);
		}

		if (cj.p2 == null || cj.p2NumberError || cj.p2ValueError || cj.isLengthMayor11Error) { // en las rayitas
			setColorRed(s2Jerarquia);
//			setColorRed(s2Integra);
		} else {
			setColorOk(s2Jerarquia);
//			setColorOk(s2Integra);
		}

		if (cj.p3 == null || cj.p3NumberError || cj.p3ValueError || cj.isLengthMayor11Error) { // en las rayitas
			setColorRed(s3Jerarquia);
//			setColorRed(s3Integra);
		} else {
			setColorOk(s3Jerarquia);
//			setColorOk(s3Integra);
		}

		if (cj.p4 == null || cj.p4NumberError || cj.p4ValueError || cj.isLengthMayor11Error) { // en las rayitas
			setColorRed(s4Jerarquia);
//			setColorRed(s4Integra);
		} else {
			setColorOk(s4Jerarquia);
//			setColorOk(s4Integra);
		}

		if (cj.p5 == null || cj.p5NumberError || cj.p5ValueError || cj.isLengthMayor11Error) { // en las rayitas
			setColorRed(s5Jerarquia);
//			setColorRed(s5Integra);
		} else {
			setColorOk(s5Jerarquia);
//			setColorOk(s5Integra);
		}

		if (cj.isErrorOnlyJerarquia() == false) {

			s0Integra.setText(cj.sI0);
			s1Integra.setText(cj.sI1);
			s2Integra.setText(cj.sI2);
			s3Integra.setText(cj.sI3);
			s4Integra.setText(cj.sI4);
			s5Integra.setText(cj.sI5);

			if (cj.p5ValueSufix) {
				setColorOk(s5Jerarquia);
				setColorGrey(s5Integra);
			} else {
				setColorGrey(s5Jerarquia);
				setColorOk(s5Integra);
			}

			if (cj.p4ValueSufix) {
				setColorOk(s4Jerarquia);
				setColorOk(s5Jerarquia);

				setColorGrey(s4Integra);
				setColorGrey(s5Integra);
			} else {
				setColorGrey(s4Jerarquia);
				setColorOk(s4Integra);
			}

			if (cj.p3ValueSufix) {
				setColorOk(s3Jerarquia);
				setColorOk(s4Jerarquia);
				setColorOk(s5Jerarquia);

				setColorGrey(s3Integra);
				setColorGrey(s4Integra);
				setColorGrey(s5Integra);
			} else {
				setColorGrey(s3Jerarquia);
				setColorOk(s3Integra);
			}

			if (cj.p2ValueSufix) {
				setColorOk(s2Jerarquia);
				setColorOk(s3Jerarquia);
				setColorOk(s4Jerarquia);
				setColorOk(s5Jerarquia);

				setColorGrey(s2Integra);
				setColorGrey(s3Integra);
				setColorGrey(s4Integra);
				setColorGrey(s5Integra);

			} else {
				setColorGrey(s2Jerarquia);
				setColorOk(s2Integra);
			}

			if (cj.p1ValueSufix) {
				setColorOk(s1Jerarquia);
				setColorOk(s2Jerarquia);
				setColorOk(s3Jerarquia);
				setColorOk(s4Jerarquia);
				setColorOk(s5Jerarquia);

				setColorGrey(s1Integra);
				setColorGrey(s2Integra);
				setColorGrey(s3Integra);
				setColorGrey(s4Integra);
				setColorGrey(s5Integra);

			} else {
				setColorGrey(s1Jerarquia);
				setColorOk(s1Integra);
			}

			if (cj.p0ValueSufix) {
				setColorOk(s0Jerarquia);
				setColorOk(s1Jerarquia);
				setColorOk(s2Jerarquia);
				setColorOk(s3Jerarquia);
				setColorOk(s4Jerarquia);
				setColorOk(s5Jerarquia);

				setColorGrey(s0Integra);
				setColorGrey(s1Integra);
				setColorGrey(s2Integra);
				setColorGrey(s3Integra);
				setColorGrey(s4Integra);
				setColorGrey(s5Integra);

			} else {
				setColorGrey(s0Jerarquia);
				setColorOk(s0Integra);
			}

		} 
		
		
		if (cj.isError()) {
			
			setColorRed(s0Integra);
			setColorRed(s1Integra);
			setColorRed(s2Integra);
			setColorRed(s3Integra);
			setColorRed(s4Integra);
			setColorRed(s5Integra);

			if (cj.isIntegraEqualsError) {

				if (cj.integra.length() == 11) {
					s0Integra.setText(cj.integra.charAt(0) + "");
					s1Integra.setText(cj.integra.charAt(1) + "" + cj.integra.charAt(2));
					s2Integra.setText(cj.integra.charAt(3) + "" + cj.integra.charAt(4));
					s3Integra.setText(cj.integra.charAt(5) + "" + cj.integra.charAt(6));
					s4Integra.setText(cj.integra.charAt(7) + "" + cj.integra.charAt(8));
					s5Integra.setText(cj.integra.charAt(9) + "" + cj.integra.charAt(10));
				} else {
					s0Integra.setText(cj.sI0);
					s1Integra.setText(cj.sI1);
					s2Integra.setText(cj.sI2);
					s3Integra.setText(cj.sI3);
					s4Integra.setText(cj.sI4);
					s5Integra.setText(cj.sI5);
				}

				setColorRedA400(s0Integra);
				setColorRedA400(s1Integra);
				setColorRedA400(s2Integra);
				setColorRedA400(s3Integra);
				setColorRedA400(s4Integra);
				setColorRedA400(s5Integra);

			} else {
				s0Integra.setText("_");
				s1Integra.setText("__");
				s2Integra.setText("__");
				s3Integra.setText("__");
				s4Integra.setText("__");
				s5Integra.setText("__");
			}

		}

	}

	private void setColorRed(H5 h) {
		h.getStyle().set("color", "#f44336");
	}

	private void setColorRedA400(H5 h) {
		h.getStyle().set("color", "#ff1744");
	}

	private void setColorGrey(H5 h) {
		h.getStyle().set("color", "#9e9e9e");
	}

	private void setColorOk(H5 h) {
		h.getStyle().set("color", "#000000");
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

		// -----------------------

		centroCostoContable.cbx.filter.setEjercicioContable(binder.getBean().getEjercicioContable());
		puntoEquilibrio.cbx.filter.setEjercicioContable(binder.getBean().getEjercicioContable());

		if (binder.getBean().getCuentaContableEstado() == true) {
			cuentaContableEstado.setLabel("1. Cuentas en uso");
			cuentaContableEstado.getStyle().set("color", "#00897b");
		} else {
			cuentaContableEstado.setLabel("0. Cuentas fuera de uso");
			cuentaContableEstado.getStyle().set("color", "#80cbc4");
		}

		if (binder.getBean().getImputable() == false) {

			ccPanel.setEnabled(binder.getBean().getImputable());

			centroCostoContable.cbx.setValue(null);
			puntoEquilibrio.cbx.setValue(null);
			porcentaje.setValue(null);
			cuentaAgrupadora.setValue("");
			costoVenta.setValue(null);

		}

		// -----------------------

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
				CuentaContable item;

				item = service.save(binder.getBean());

				Notification notification = new Notification("Cuenta contable " + item + " guardado con éxito.", 1000,
						Position.BOTTOM_END);
				notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
				notification.open();

				return true;

			} catch (Exception500 e) {

				new NotificationError(e, "No se pudo guardar el ítem !!");

			} catch (CuentaContableSaveCodigoExistsEx e) {

				this.codigo.setInvalid(true);
				openNotificationSaveException(this.codigo.getLabel(),
						"En la base de datos ya existe una Cuenta Contable con el mismo código y el mismo ejercicio contable.");

			} catch (CuentaContableSaveNombreExistsEx e) {

				this.nombre.setInvalid(true);
				openNotificationSaveException(this.nombre.getLabel(),
						"En la base de datos ya existe una Cuenta Contable con el mismo nombre y el mismo ejercicio contable.");

			} catch (CuentaContableSaveCuentaJerarquiaExistsEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"En la base de datos ya existe una Cuenta Contable con la misma cuenta jerarquía y el mismo ejercicio contable.");

			} catch (CuentaContableSaveIntegraNotExistsEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"En la base de datos no existe una Cuenta Contable integradora con el mismo ejercicio contable para esta cuenta contable.");

			} catch (CuentaContableSaveCuentaJerarquiaIsNullEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(), "Debe ingresar un valor.");

			} catch (CuentaContableSaveCuentaJerarquiaIsEmptyEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(), "Debe ingresar un valor.");

			} catch (CuentaContableSaveCuentaJerarquiaIsLengthMinor11ErrorEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"Debe ingresar un valor con 11 caracteres. Valor ingresado "
								+ e.getCuentaContable().getCuentaJerarquia().length());

			} catch (CuentaContableSaveCuentaJerarquiaIsLengthMayor11ErrorEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"Debe ingresar un valor con 11 caracteres. Valor ingresado "
								+ e.getCuentaContable().getCuentaJerarquia().length());

			} catch (CuentaContableSaveCuentaJerarquiaIsCharsNotNumberErrorEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"Debe ingresar un valor con 11 caracteres y el formato #.##.##.##.##.##, donde # es un número de 0-9");

			} catch (CuentaContableSaveCuentaJerarquiaIsValueErrorEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"Debe ingresar un valor con 11 caracteres y el formato #.##.##.##.##.##, donde # es un número de 0-9. Recordar que node pueden existir pares de valores 00 como padres, por ejemplo 1.23.45.67.00.12 es erróneo.");

			} catch (CuentaContableSaveCuentaJerarquiaIsIntegraEqualsErrorEx e) {

				this.cuentaJerarquia.setInvalid(true);
				openNotificationSaveException(this.cuentaJerarquia.getLabel(),
						"La cuenta inntegra no coincide con la cuenta jerarquía. Cuenta recibida " + e.cj.integra
								+ ", se esperaba " + e.cj.integraCompute);

			} catch (CuentaContableSaveCodigoIsNullEx e) {

				this.codigo.setInvalid(true);
				openNotificationSaveException(this.codigo.getLabel(), "Debe ingresar un valor.");

			} catch (CuentaContableSaveNombreIsNullEx e) {

				this.nombre.setInvalid(true);
				openNotificationSaveException(this.nombre.getLabel(), "Debe ingresar un valor.");

			} catch (CuentaContableSaveCodigoIsLengthMayor11ErrorEx e) {

				this.codigo.setInvalid(true);
				openNotificationSaveException(this.codigo.getLabel(),
						"Debe ingresar un valor con más de 11 caracteres. Valor ingresado "
								+ e.getCuentaContable().getCuentaJerarquia().length());

			} catch (CuentaContableSaveNombreIsLengthMayor50ErrorEx e) {

				this.nombre.setInvalid(true);
				openNotificationSaveException(this.nombre.getLabel(),
						"Debe ingresar un valor con más de 50 caracteres. Valor ingresado "
								+ e.getCuentaContable().getCuentaJerarquia().length());

			} catch (CuentaContableSaveEjercicioContableIsNullEx e) {

				openNotificationSaveException("Ejercicio contable",
						"No se puede guardar una Cuenta Contable sin especificar su ejercicio.");

			} catch (CuentaContableSaveIsNullEx e) {

				openNotificationSaveException("Cuenta contable", "No se puede guardar una Cuenta Contable nula.");
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

	private void openNotificationSaveException(String label, String msg) {
		Notification notification = new Notification("El campo " + label + " es incorrecto. " + msg, 3500,
				Position.BOTTOM_END);
		notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		notification.open();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 6782973177012383676L;

} // END CLASS -----------------------------------------------------------------