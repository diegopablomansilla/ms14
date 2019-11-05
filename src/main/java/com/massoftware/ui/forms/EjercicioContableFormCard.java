package com.massoftware.ui.forms;

import java.util.Optional;
import java.util.stream.Collectors;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.b.service.EjercicioContableService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.dao.ds.ex.DeleteForeignKeyViolationException;
import com.massoftware.ui.util.ConfirmationDialog;
import com.massoftware.ui.util.NotificationError;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;

public class EjercicioContableFormCard extends Div {

	// ---------------------------------------------------------------------------------------------------------------------------

	private H3 title;
	private Button buttonOpen;

	// ---------------------------------------------------------------------------------------------------------------------------

	private EjercicioContableService service;

	// Binder
//	private EjercicioContable item;
	private Binder<EjercicioContable> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private HorizontalLayout actions2;
	private Button saveButton;
	private Button deleteButton;

	private NumberField numero;
	private DatePicker apertura;
	private DatePicker cierre;
	private Checkbox cerrado;
	private Checkbox cerradoModulos;
	private TextArea comentario;

	private boolean header;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableFormCard(EjercicioContableService service) {
		this.header = true;
		init(service);
	}

	public EjercicioContableFormCard(EjercicioContableService service, boolean header) {
		this.header = header;
		init(service);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void init(EjercicioContableService service) {
		this.service = service;
		initBinder();
		this.binder.setBean(new EjercicioContable());
		if (header) {
			createHeader();
		}
		initForm();
		this.setHeightFull();
	}

	private void initBinder() {
//		item = new EjercicioContable();
		binder = new Binder<>(EjercicioContable.class);
//		binder.addStatusChangeListener(event -> {
//			boolean isValid = event.getBinder().isValid();
//			boolean hasChanges = event.getBinder().hasChanges();
//			saveButton.setEnabled(hasChanges && isValid);
//			resetButton.setEnabled(hasChanges);
//		});
	}

	private void createHeader() {
		this.title = new H3("Ejercicio");
		buttonOpen = new Button();
		buttonOpen.setIcon(new Icon(VaadinIcon.EXTERNAL_LINK));
		buttonOpen.addThemeVariants(ButtonVariant.LUMO_SMALL);
		buttonOpen.addClickListener(buttonClickEvent -> open());

		HorizontalLayout header = new HorizontalLayout();

		header.setWidthFull();
		header.setPadding(false);
		header.setMargin(false);
//		header.setSpacing(false);

		Div d = new Div();
		d.setWidthFull();

		header.add(this.title, d, buttonOpen);
//		header.setFlexGrow(1, this.title);
//		header.setAlignItems(FlexComponent.Alignment.CENTER);
		header.setAlignItems(Alignment.END);
//		header.getStyle().set("background-color", "green");
		add(header);
	}

	private void open() {
		open(this.binder.getBean());
	}

	protected void open(EjercicioContable item) {

	}

	private void initForm() {

		// -------------------------------------------------------------------
		// Controls
		// -------------------------------------------------------------------

		EjercicioContableFormUtil utilForm = new EjercicioContableFormUtil();

		numero = utilForm.initNumero(binder);
		apertura = utilForm.initApertura(binder);
		cierre = utilForm.initCierre(binder, apertura);
		cerrado = utilForm.initCerrado(binder);
		cerradoModulos = utilForm.initCerradoModulos(binder);
		comentario = utilForm.initComentario(binder);

		// -------------------------------------------------------------------
		// Layout's
		// -------------------------------------------------------------------

		form = new FormLayout();
		form.setWidthFull();

		add(form);

		form.add(numero);
		form.add(apertura);
		form.add(cierre);
		form.add(cerrado);
		form.add(cerradoModulos);
		form.add(comentario);

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

	public void load(EjercicioContable item) {

//		this.item = itemArg;
		binder.setBean(item);

		binder.validate();

		if (binder.isValid() == false) {
			BinderValidationStatus<EjercicioContable> validate = binder.validate();
			String errorText = validate.getFieldValidationStatuses().stream().filter(BindingValidationStatus::isError)
					.map(BindingValidationStatus::getMessage).map(Optional::get).distinct()
					.collect(Collectors.joining(", "));

			Notification notification = new Notification("El ítem tiene uno o mas valores del ítem son incorrectos. " + errorText,
					3000, Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
			notification.open();
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void search(String id) {
		try {
			EjercicioContable item = service.findById(id);
			if (item != null) {

				Notification notification = new Notification("Ejercicio " + item.getNumero() + " cargado con éxito.",
						1000, Position.BOTTOM_END);
				notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
				notification.open();

				load(item);
			}
		} catch (Exception500 e) {
			new NotificationError(e, "No se pudo buscar el ítem !!");
		}
	}

//	public void savex() {
//
//		try {
//
//			binder.validate();
//
//			if (binder.isValid()) {
//				item = service.update(item);
//				Notification.show("El ítem '" + item + "' se guardo con éxito !");
//				search(item.getId());
//			} else {
//				BinderValidationStatus<EjercicioContable> validate = binder.validate();
//				String errorText = validate.getFieldValidationStatuses().stream()
//						.filter(BindingValidationStatus::isError).map(BindingValidationStatus::getMessage)
//						.map(Optional::get).distinct().collect(Collectors.joining(", "));
//
//				Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
//			}
//
//		} catch (Exception500 e) {
//			new NotificationError(e, "No se pudo guardar el ítem !!");
//		}
//
//	}

	public boolean save() {

		if (binder.validate().isOk()) {
			try {
				EjercicioContable item = service.save(binder.getBean());

				Notification notification = new Notification("Ejercicio " + item.getNumero() + " guardado con éxito.",
						1000, Position.BOTTOM_END);
				notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
				notification.open();

				return true;

			} catch (Exception500 e) {
				new NotificationError(e, "No se pudo guardar el ítem !!");
			}

		} else {
			BinderValidationStatus<EjercicioContable> validate = binder.validate();
			String errorText = validate.getFieldValidationStatuses().stream().filter(BindingValidationStatus::isError)
					.map(BindingValidationStatus::getMessage).map(Optional::get).distinct()
					.collect(Collectors.joining(", "));

			Notification notification = new Notification("El ítem tiene uno o mas valores del ítem son incorrectos. " + errorText,
					3000, Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
			notification.open();
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

	protected boolean delete(EjercicioContable item) {

		try {
			service.deleteById(item.getId());

			Notification notification = new Notification("Ejercicio " + item.getNumero() + " borrado con éxito.", 1000,
					Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
			notification.open();

			return true;

		} catch (Exception500 e) {

			if (e.getException() instanceof DeleteForeignKeyViolationException) {

				Notification notification = new Notification(
						"Ejercicio " + item.getNumero()
								+ " NO se puede borrar. El ítem tiene otros objetos relacionados.",
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 6782973177012383676L;

} // END CLASS -----------------------------------------------------------------