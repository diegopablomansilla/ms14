package com.massoftware.ui.forms;

import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.ui.DoubleToIntegerConverter;
import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class CentroCostoContableFormUtil {


	public NumberField initNumero(Binder<CentroCostoContable> binder) {

		// Nº cc

		NumberField numero = new NumberField();

		numero.setLabel("Nº cc");
//		numero.setWidthFull();
		numero.setClearButtonVisible(true);
//		numero.setReadOnly(true);

		// --------------------------------------------

		binder.forField(numero)
				.asRequired(numero.getLabel() + " es requerido.")
//				.withConverter(new MyStringToIntegerConverter(numero.getLabel() + " tiene que ser un número entero"))
				.withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value >= 1 : true, numero.getLabel() +  " tiene que ser >= " + 1)
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true, numero.getLabel() +  " tiene que ser <= " + Integer.MAX_VALUE)

				.bind(CentroCostoContable::getNumero, CentroCostoContable::setNumero);

		// --------------------------------------------

		return numero;
	}

	public TextField initNombre(Binder<CentroCostoContable> binder) {

		// Nombre

		TextField nombre = new TextField();

		nombre.setLabel("Nombre");
//		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);

		// --------------------------------------------

		binder.forField(nombre)
				.asRequired(nombre.getLabel() + " es requerido.")
//				.withValidator(value -> (value != null) ? value.length() >= ${ATT_NAME_MIN} : true, nombre.getLabel() + " tiene que contener al menos ${ATT_NAME_MIN} caracteres")
				.withValidator(value -> (value != null) ? value.length() <= 50 : true, nombre.getLabel() + " tiene que contener igual o menos de 50 caracteres")
				.bind(CentroCostoContable::getNombre, CentroCostoContable::setNombre);

		// --------------------------------------------

		return nombre;
	}

	public TextField initAbreviatura(Binder<CentroCostoContable> binder) {

		// Abreviatura

		TextField abreviatura = new TextField();

		abreviatura.setLabel("Abreviatura");
//		abreviatura.setWidthFull();
		abreviatura.setClearButtonVisible(true);
		abreviatura.setAutoselect(true);

		// --------------------------------------------

		binder.forField(abreviatura)
				.asRequired(abreviatura.getLabel() + " es requerido.")
//				.withValidator(value -> (value != null) ? value.length() >= ${ATT_NAME_MIN} : true, abreviatura.getLabel() + " tiene que contener al menos ${ATT_NAME_MIN} caracteres")
				.withValidator(value -> (value != null) ? value.length() <= 5 : true, abreviatura.getLabel() + " tiene que contener igual o menos de 5 caracteres")
				.bind(CentroCostoContable::getAbreviatura, CentroCostoContable::setAbreviatura);

		// --------------------------------------------

		return abreviatura;
	}
} // END CLASS -----------------------------------------------------------------