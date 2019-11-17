package com.massoftware.ui.forms;

import com.massoftware.b.service.EjercicioContableFilterQ1;
import com.massoftware.ui.DoubleToIntegerConverter;
import com.massoftware.ui.UIUtils;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;

public class EjercicioContableFilterForm extends HorizontalLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private EjercicioContableFilterQ1 lastFilter;
	private EjercicioContableFilterQ1 filter;
	private Binder<EjercicioContableFilterQ1> binder;

	// ---------------------------------------------------------------------------------------------------------------------------

	private NumberField numeroFrom;
	private NumberField numeroTo;
	private Checkbox cerrado;

	private Button newButton;
	private Button findButton;

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableFilterForm() {

		initBinder();
		initFilterRows();
		binder.setBean(filter);
		
		numeroTo.focus();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public EjercicioContableFilterQ1 getFilter() {
		return filter;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initBinder() {
		filter = new EjercicioContableFilterQ1();
		binder = new Binder<>(EjercicioContableFilterQ1.class);
	}

	private void initFilterRows() {

		// Controls ------------------------

		initNumeroFrom();
		initNumeroTo();
		initCerrado();

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
		this.setSpacing(true);
//		this.setMargin(false);
//		this.setPadding(false);

		this.add(numeroFrom, numeroTo, cerrado, s, findButton, newButton);

		this.setAlignItems(Alignment.CENTER);

		// -------------------------------------------------------------------
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void initNumeroFrom() {

		// Nº ejercicio (desde)

		numeroFrom = new NumberField();
		numeroFrom.setPlaceholder("Nº desde ");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(numeroFrom).withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value >= 1990 : true, "El valor tiene que ser >= 1990")
				.withValidator(value -> (value != null) ? value <= 2030 : true, "El valor tiene que ser <= " + 2030)
				.bind(EjercicioContableFilterQ1::getNumeroFrom, EjercicioContableFilterQ1::setNumeroFrom);

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

		// Nº ejercicio (hasta)

		numeroTo = new NumberField();
		numeroTo.setPlaceholder("Nº hasta ");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
		numeroTo.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);

		// --------------------------------------------

		binder.forField(numeroTo).withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value >= 1990 : true, "El valor tiene que ser >= 1990")
				.withValidator(value -> (value != null) ? value <= 2030 : true, "El valor tiene que ser <= " + 2030)
				.bind(EjercicioContableFilterQ1::getNumeroTo, EjercicioContableFilterQ1::setNumeroTo);

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

	private void initCerrado() {

		// Cerrado

		cerrado = new Checkbox();
		cerrado.setLabel("Ejercicios cerrados");
//		cerrado.setHeightFull();
		cerrado.setWidthFull();

		// --------------------------------------------

		binder.forField(cerrado).bind(EjercicioContableFilterQ1::getCerrado, EjercicioContableFilterQ1::setCerrado);

		// --------------------------------------------

		cerrado.addValueChangeListener(event -> {
			search();
		});
		cerrado.addBlurListener(event -> {
			search();
		});
	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	public void load(EjercicioContableFilterQ1 filterArg) {
//
//		this.filter = filterArg;
//		binder.setBean(filter);
//
//		binder.validate();
//
//		if (binder.isValid() == false) {
//			BinderValidationStatus<EjercicioContableFilterQ1> validate = binder.validate();
//			String errorText = validate.getFieldValidationStatuses().stream().filter(BindingValidationStatus::isError)
//					.map(BindingValidationStatus::getMessage).map(Optional::get).distinct()
//					.collect(Collectors.joining(", "));
//
//			Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
//		}
//
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void search() {

		binder.validate();

		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (EjercicioContableFilterQ1) this.filter.clone();
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 5868954652393992267L;

} // END CLASS -----------------------------------------------------------------