package com.massoftware.ui.forms;

import java.util.Optional;
import java.util.stream.Collectors;

import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.b.service.PuntoEquilibrioService;
import com.massoftware.b.service.util.Exception500;
import com.massoftware.c.persist.dao.ds.ex.DeleteForeignKeyViolationException;
import com.massoftware.ui.ConfirmationDialog;
import com.massoftware.ui.NotificationError;
import com.massoftware.ui.cbx.TipoPuntoEquilibrioCBX;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;

public class PuntoEquilibrioFormCard extends Div {

	// ---------------------------------------------------------------------------------------------------------------------------

	private H3 title;
	private Button buttonOpen;

	// ---------------------------------------------------------------------------------------------------------------------------

	private PuntoEquilibrioService service;

	// Binder	
	private Binder<PuntoEquilibrio> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private HorizontalLayout actions2;
	private Button saveButton;
	private Button deleteButton;
	
	private boolean header;

	
	private NumberField numero;
	private TextField nombre;
	private TipoPuntoEquilibrioCBX tipoPuntoEquilibrio;

	// ---------------------------------------------------------------------------------------------------------------------------

	public PuntoEquilibrioFormCard(PuntoEquilibrioService service) {
		this.header = true;
		init(service);
	}

	public PuntoEquilibrioFormCard(PuntoEquilibrioService service, boolean header) {
		this.header = header;
		init(service);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void init(PuntoEquilibrioService service) {
		this.service = service;
		initBinder();
		if (header) {
			createHeader();
		}
		initForm();
		this.setHeightFull();
		
		numero.focus();
	}
	
	

	private void initBinder() {		
		binder = new Binder<>(PuntoEquilibrio.class);
//		binder.addStatusChangeListener(event -> {
//			boolean isValid = event.getBinder().isValid();
//			boolean hasChanges = event.getBinder().hasChanges();
//			saveButton.setEnabled(hasChanges && isValid);
//			resetButton.setEnabled(hasChanges);
//		});
	}
	
	private void createHeader() {
		this.title = new H3("Punto equilibrio");
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

		Div d = new Div();
		d.setWidthFull();

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

	protected void open(PuntoEquilibrio item) {

	}	

	private void initForm() {

		// -------------------------------------------------------------------
		// Controls
		// -------------------------------------------------------------------		

		PuntoEquilibrioFormUtil utilForm = new PuntoEquilibrioFormUtil();
		
		numero = utilForm.initNumero(binder);
		nombre = utilForm.initNombre(binder);
		tipoPuntoEquilibrio = utilForm.initTipoPuntoEquilibrio(binder);

		// -------------------------------------------------------------------
		// Layout's
		// -------------------------------------------------------------------

		form = new FormLayout();
		form.setWidthFull();

		add(form);

		
		form.add(numero);
		form.add(nombre);
		form.add(tipoPuntoEquilibrio);

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

	public void load(PuntoEquilibrio item) {
		
		binder.setBean(item);

		binder.validate();

		if (binder.isValid() == false) {
			BinderValidationStatus<PuntoEquilibrio> validate = binder.validate();
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

	public void searchx(String id) {
		try {
			PuntoEquilibrio item = service.findById(id);
			if (item != null) {

				Notification notification = new Notification("Punto equilibrio " + item + " cargado con éxito.",
						1000, Position.BOTTOM_END);
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
				PuntoEquilibrio item = service.save(binder.getBean());
				
				Notification notification = new Notification("Punto equilibrio " + item + " guardado con éxito.", 1000,
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
//			confirmationDialog.setTitle("¿ Estás seguro, quieres borrar el ítem " + binder.getBean() + " ?");
			confirmationDialog.setTitle("¿ Estás seguro, quieres borrar el ítem ?");

			confirmationDialog.setQuestion(binder.getBean() != null ? binder.getBean().toString() : "");
			confirmationDialog.addConfirmationListener(buttonClickEvent -> {
				delete(binder.getBean());
			});
			confirmationDialog.open();

		}

	}
	
	protected boolean delete(PuntoEquilibrio item) {

		try {
			service.deleteById(item.getId());

			Notification notification = new Notification("Punto equilibrio " + item.getNumero() + " borrado con éxito.", 1000,
					Position.BOTTOM_END);
			notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
			notification.open();

			return true;

		} catch (Exception500 e) {

			if (e.getException() instanceof DeleteForeignKeyViolationException) {

				Notification notification = new Notification(
						"Punto equilibrio " + item.getNumero()
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