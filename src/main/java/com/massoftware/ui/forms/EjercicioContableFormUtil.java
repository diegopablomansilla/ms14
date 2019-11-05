package com.massoftware.ui.forms;

import java.time.LocalDate;
import java.util.Locale;

import com.massoftware.a.model.EjercicioContable;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.massoftware.ui.util.UIDatePickerI18n_es_AR;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.Binder;

public class EjercicioContableFormUtil {
	
	public NumberField initNumero(Binder<EjercicioContable> binder) {

		// Nº ejercicio

		NumberField numero = new NumberField();

		numero.setLabel("Nº ejercicio");
//		numero.setWidthFull();
		numero.setClearButtonVisible(true);
//		numero.setReadOnly(true);

		// --------------------------------------------

		binder.forField(numero)
				.asRequired(numero.getLabel() + " es requerido.")
				.withConverter(new DoubleToIntegerConverter())				
				.withValidator(value -> (value != null) ? value >= 1990 : true, "El valor tiene que ser >= " + 1990)
				.withValidator(value -> (value != null) ? value <= 2030 : true, "El valor tiene que ser <= " + 2030)
				.bind(EjercicioContable::getNumero, EjercicioContable::setNumero);

		// --------------------------------------------

		return numero;
	}

//	public TextField initNumero(Binder<EjercicioContable> binder) {
//
//		// Nº ejercicio
//
//		TextField numero = new TextField();
//
//		numero.setLabel("Nº ejercicio");
////		numero.setWidthFull();
//		numero.setClearButtonVisible(true);
////		numero.setReadOnly(true);
//
//		// --------------------------------------------
//
//		binder.forField(numero).asRequired(numero.getLabel() + " es requerido.")
//				.withValidator(text -> text.length() == 4, numero.getLabel() + " debe ser un año de 4 dígitos")
//				.withConverter(new MyStringToIntegerConverter(numero.getLabel() + " tiene que ser un número entero"))
//				.withValidator(value -> (value != null) ? value >= 1990 : true, "El valor tiene que ser >= 1990")
//				.withValidator(value -> (value != null) ? value <= 2030 : true, "El valor tiene que ser <= " + 2030)
//				.bind(EjercicioContable::getNumero, EjercicioContable::setNumero);
//
//		// --------------------------------------------
//
//		return numero;
//	}

	public DatePicker initApertura(Binder<EjercicioContable> binder) {

		// Apertura

		DatePicker apertura = new DatePicker();

		apertura.setLabel("Apertura");
//		apertura.setWidthFull();
		apertura.setClearButtonVisible(true);
//		apertura.setRequired(true);
		apertura.setLocale(new Locale("es"));
		apertura.setI18n(new UIDatePickerI18n_es_AR());
//		apertura.setReadOnly(true);

		// --------------------------------------------

		binder.forField(apertura).asRequired(apertura.getLabel() + " es requerido.")
				.bind(EjercicioContable::getApertura, EjercicioContable::setApertura);

		// --------------------------------------------

		return apertura;
	}

	public DatePicker initCierre(Binder<EjercicioContable> binder, DatePicker apertura) {

		// Cierre

		DatePicker cierre = new DatePicker();

		cierre.setLabel("Cierre");
//		cierre.setWidthFull();
		cierre.setClearButtonVisible(true);
//		cierre.setRequired(true);
		cierre.setLocale(new Locale("es"));
		cierre.setI18n(new UIDatePickerI18n_es_AR());

		// --------------------------------------------

//		binder.forField(cierre).asRequired(cierre.getLabel() + " es requerido.").bind(EjercicioContable::getCierre,
//				EjercicioContable::setCierre);

		Binder.Binding<EjercicioContable, LocalDate> returningBinding = binder.forField(cierre)
				.asRequired(apertura.getLabel() + " es requerido.")
				.withValidator(cierreDate -> (cierreDate != null) ? !cierreDate.isBefore(apertura.getValue()) : true,
						"La fecha de cierre debe ser anterior a la de apertura")
				.bind(EjercicioContable::getCierre, EjercicioContable::setCierre);

		apertura.addValueChangeListener(event -> returningBinding.validate());

		// --------------------------------------------

		return cierre;
	}

	public Checkbox initCerrado(Binder<EjercicioContable> binder) {

		// Cerrado

		Checkbox cerrado = new Checkbox();

		cerrado.setLabel("Ejercicio cerrado");
//		cerrado.setWidthFull();

		// --------------------------------------------

		binder.forField(cerrado).bind(EjercicioContable::getCerrado, EjercicioContable::setCerrado);

		// --------------------------------------------

		return cerrado;
	}

	public Checkbox initCerradoModulos(Binder<EjercicioContable> binder) {

		// Cerrado módulos

		Checkbox cerradoModulos = new Checkbox();

		cerradoModulos.setLabel("Módulos cerrados");
//		cerradoModulos.setWidthFull();

		// --------------------------------------------

		binder.forField(cerradoModulos).bind(EjercicioContable::getCerradoModulos,
				EjercicioContable::setCerradoModulos);

		// --------------------------------------------

		return cerradoModulos;
	}

	public TextArea initComentario(Binder<EjercicioContable> binder) {

		// Comentario

		TextArea comentario = new TextArea();

		comentario.setLabel("Comentario");
//		comentario.setWidthFull();
		comentario.setClearButtonVisible(true);
		comentario.setAutoselect(true);

		// --------------------------------------------

		binder.forField(comentario)
				.withValidator(value -> (value != null) ? value.length() <= 250 : true,
						comentario.getLabel() + " tiene que contener menos de 250 caracteres")
				.bind(EjercicioContable::getComentario, EjercicioContable::setComentario);

		// --------------------------------------------

		return comentario;
	}

} // END CLASS -----------------------------------------------------------------