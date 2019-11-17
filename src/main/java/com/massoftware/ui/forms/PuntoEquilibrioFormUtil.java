package com.massoftware.ui.forms;

import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.ui.DoubleToIntegerConverter;
import com.massoftware.ui.cbx.TipoPuntoEquilibrioCBX;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class PuntoEquilibrioFormUtil {

	public NumberField initNumero(Binder<PuntoEquilibrio> binder) {

		// Nº cc

		NumberField numero = new NumberField();

		numero.setLabel("Nº cc");
//		numero.setWidthFull();
		numero.setClearButtonVisible(true);
//		numero.setReadOnly(true);

		// --------------------------------------------

		binder.forField(numero).asRequired(numero.getLabel() + " es requerido.")
//				.withConverter(new MyStringToIntegerConverter(numero.getLabel() + " tiene que ser un número entero"))
				.withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value >= 1 : true,
						numero.getLabel() + " tiene que ser >= " + 1)
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						numero.getLabel() + " tiene que ser <= " + Integer.MAX_VALUE)

				.bind(PuntoEquilibrio::getNumero, PuntoEquilibrio::setNumero);

		// --------------------------------------------

		return numero;
	}

	public TextField initNombre(Binder<PuntoEquilibrio> binder) {

		// Nombre

		TextField nombre = new TextField();

		nombre.setLabel("Nombre");
//		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);

		// --------------------------------------------

		binder.forField(nombre).asRequired(nombre.getLabel() + " es requerido.")
//				.withValidator(value -> (value != null) ? value.length() >= ${ATT_NAME_MIN} : true, nombre.getLabel() + " tiene que contener al menos ${ATT_NAME_MIN} caracteres")
				.withValidator(value -> (value != null) ? value.length() <= 50 : true,
						nombre.getLabel() + " tiene que contener igual o menos de 50 caracteres")
				.bind(PuntoEquilibrio::getNombre, PuntoEquilibrio::setNombre);

		// --------------------------------------------

		return nombre;
	}

	public TipoPuntoEquilibrioCBX initTipoPuntoEquilibrio(Binder<PuntoEquilibrio> binder) {	

		// Nombre

		TipoPuntoEquilibrioCBX tipoPuntoEquilibrio = new TipoPuntoEquilibrioCBX();

		tipoPuntoEquilibrio.setLabel("Tipo");
//		tipoPuntoEquilibrio.setWidthFull();
		tipoPuntoEquilibrio.setClearButtonVisible(true);
//		tipoPuntoEquilibrio.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(tipoPuntoEquilibrio)
				.asRequired(tipoPuntoEquilibrio.getLabel() + " es requerido.")
				.bind(PuntoEquilibrio::getTipoPuntoEquilibrio, PuntoEquilibrio::setTipoPuntoEquilibrio);

		// --------------------------------------------

		return tipoPuntoEquilibrio;
	}

} // END CLASS -----------------------------------------------------------------