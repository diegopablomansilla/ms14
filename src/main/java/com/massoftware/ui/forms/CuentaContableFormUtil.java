package com.massoftware.ui.forms;

import com.massoftware.a.model.CuentaContable;
//import com.massoftware.a.model.CentroCostoContable;
import com.massoftware.ui.cbx.CentroCostoContableCBX;
import com.massoftware.ui.cbx.CentroCostoContableCBXH;
//import com.massoftware.a.model.CostoVenta;
import com.massoftware.ui.cbx.CostoVentaCBX;
//import com.massoftware.ui.util.DoubleToIntegerConverter;
//import com.massoftware.a.model.PuntoEquilibrio;
import com.massoftware.ui.cbx.PuntoEquilibrioCBX;
import com.massoftware.ui.cbx.PuntoEquilibrioCBXH;
//import com.massoftware.a.model.SeguridadPuerta;
import com.massoftware.ui.cbx.SeguridadPuertaCBX;
//import com.massoftware.a.model.EjercicioContable;
//import com.massoftware.ui.cbx.EjercicioContableCBX;
//import com.massoftware.a.model.CuentaContable;
//import com.massoftware.ui.cbx.IntegraCBX;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CuentaContableFormUtil {

	public TextField initCodigo(Binder<CuentaContable> binder) {

		// Cuenta contable

		TextField codigo = new TextField();

		codigo.setLabel("Cuenta contable");
//		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);

		// --------------------------------------------

		binder.forField(codigo)
				.asRequired(codigo.getLabel() + " es requerido.")
//				.withValidator(value -> (value != null) ? value.length() == 11 : true, codigo.getLabel() + " tiene que contener al menos 11 caracteres")
				.withValidator(value -> (value != null) ? value.length() <= 11 : true, codigo.getLabel() + " tiene que contener igual o menos de 11 caracteres")
				.bind(CuentaContable::getCodigo, CuentaContable::setCodigo);

		// --------------------------------------------

		return codigo;
	}

	public TextField initNombre(Binder<CuentaContable> binder) {

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
				.bind(CuentaContable::getNombre, CuentaContable::setNombre);

		// --------------------------------------------

		return nombre;
	}

//	public EjercicioContableCBX initEjercicioContable(Binder<CuentaContable> binder) {	
//
//		// Ejercicio
//
//		EjercicioContableCBX ejercicioContable = new EjercicioContableCBX();
//
//		ejercicioContable.setLabel("Ejercicio");
////		ejercicioContable.setWidthFull();
//		ejercicioContable.setClearButtonVisible(true);
////		ejercicioContable.setItemLabelGenerator(PuntoEquilibrio::getNombre);
//
//		// --------------------------------------------
//
//		binder.forField(ejercicioContable)
////				.asRequired(ejercicioContable.getLabel() + " es requerido.")
//				.bind(CuentaContable::getEjercicioContable, CuentaContable::setEjercicioContable);
//
//		// --------------------------------------------
//
//		return ejercicioContable;
//	}

//	public CuentaContableCBX initIntegra(Binder<CuentaContable> binder) {	
//
//		// Integra
//
//		CuentaContableCBX integra = new CuentaContableCBX();
//
//		integra.setLabel("Integra");
////		integra.setWidthFull();
//		integra.setClearButtonVisible(true);
////		integra.setItemLabelGenerator(PuntoEquilibrio::getNombre);
//
//		// --------------------------------------------
//
//		binder.forField(integra)
////				.asRequired(integra.getLabel() + " es requerido.")
//				.bind(CuentaContable::getIntegra, CuentaContable::setIntegra);
//
//		// --------------------------------------------
//
//		return integra;
//	}

	public TextField initCuentaJerarquia(Binder<CuentaContable> binder) {

		// Cuenta de jerarquia

		TextField cuentaJerarquia = new TextField();

		cuentaJerarquia.setLabel("Cuenta de jerarquia");
//		cuentaJerarquia.setWidthFull();
		cuentaJerarquia.setClearButtonVisible(true);
		cuentaJerarquia.setAutoselect(true);

		// --------------------------------------------

		binder.forField(cuentaJerarquia)
				.asRequired(cuentaJerarquia.getLabel() + " es requerido.")
				.withValidator(value -> (value != null) ? value.length() == 11 : true, cuentaJerarquia.getLabel() + " tiene que contener 11 caracteres")
//				.withValidator(value -> (value != null) ? value.length() <= ${ATT_NAME_MAX} : true, cuentaJerarquia.getLabel() + " tiene que contener igual o menos de ${ATT_NAME_MAX} caracteres")
				.bind(CuentaContable::getCuentaJerarquia, CuentaContable::setCuentaJerarquia);

		// --------------------------------------------

		return cuentaJerarquia;
	}

	public Checkbox initImputable(Binder<CuentaContable> binder) {

		// Imputable

		Checkbox imputable = new Checkbox();

		imputable.setLabel("Imputable");
//		imputable.setWidthFull();

		// --------------------------------------------

		binder.forField(imputable).bind(CuentaContable::getImputable, CuentaContable::setImputable);

		// --------------------------------------------

		return imputable;
	}

	public Checkbox initAjustaPorInflacion(Binder<CuentaContable> binder) {

		// Ajusta por inflación

		Checkbox ajustaPorInflacion = new Checkbox();

		ajustaPorInflacion.setLabel("Ajusta por inflación");
//		ajustaPorInflacion.setWidthFull();

		// --------------------------------------------

		binder.forField(ajustaPorInflacion).bind(CuentaContable::getAjustaPorInflacion,
				CuentaContable::setAjustaPorInflacion);

		// --------------------------------------------

		return ajustaPorInflacion;
	}

	public Checkbox initCuentaContableEstado(Binder<CuentaContable> binder) {

		// Estado

		Checkbox cuentaContableEstado = new Checkbox();

		cuentaContableEstado.setLabel("Estado");
//		cuentaContableEstado.setWidthFull();

		// --------------------------------------------

		binder.forField(cuentaContableEstado).bind(CuentaContable::getCuentaContableEstado,
				CuentaContable::setCuentaContableEstado);
		
		// --------------------------------------------
		
		cuentaContableEstado.addValueChangeListener(event -> {
			if (event.getValue() == true) {
				cuentaContableEstado.setLabel("1. Cuentas en uso");
			} else {
				cuentaContableEstado.setLabel("0. Cuentas fuera de uso");
			}
		});

		// --------------------------------------------

		return cuentaContableEstado;
	}

	public Checkbox initCuentaConApropiacion(Binder<CuentaContable> binder) {

		// Cuenta con apropiación

		Checkbox cuentaConApropiacion = new Checkbox();

		cuentaConApropiacion.setLabel("Cuenta con apropiación");
//		cuentaConApropiacion.setWidthFull();

		// --------------------------------------------

		binder.forField(cuentaConApropiacion).bind(CuentaContable::getCuentaConApropiacion,
				CuentaContable::setCuentaConApropiacion);

		// --------------------------------------------

		return cuentaConApropiacion;
	}

	public CentroCostoContableCBX initCentroCostoContable(Binder<CuentaContable> binder) {

		// Centro costo contable

		CentroCostoContableCBX centroCostoContable = new CentroCostoContableCBX();

		centroCostoContable.setLabel("Centro costo contable");
		centroCostoContable.setWidthFull();
		centroCostoContable.setClearButtonVisible(true);
//		centroCostoContable.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(centroCostoContable)
//				.asRequired(centroCostoContable.getLabel() + " es requerido.")
				.bind(CuentaContable::getCentroCostoContable, CuentaContable::setCentroCostoContable);

		// --------------------------------------------

		return centroCostoContable;
	}

	public CentroCostoContableCBXH initCentroCostoContableH(Binder<CuentaContable> binder) {

		// Centro costo contable

		CentroCostoContableCBX centroCostoContable = new CentroCostoContableCBX();

		centroCostoContable.setLabel("Centro costo contable");
		centroCostoContable.setWidthFull();
		centroCostoContable.setClearButtonVisible(true);
//		centroCostoContable.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(centroCostoContable)
//				.asRequired(centroCostoContable.getLabel() + " es requerido.")
				.bind(CuentaContable::getCentroCostoContable, CuentaContable::setCentroCostoContable);

		// --------------------------------------------

//		return centroCostoContable;
		return new CentroCostoContableCBXH(centroCostoContable);
	}

	public TextField initCuentaAgrupadora(Binder<CuentaContable> binder) {

		// Cuenta agrupadora

		TextField cuentaAgrupadora = new TextField();

		cuentaAgrupadora.setLabel("Cuenta agrupadora");
//		cuentaAgrupadora.setWidthFull();
		cuentaAgrupadora.setClearButtonVisible(true);
		cuentaAgrupadora.setAutoselect(true);

		// --------------------------------------------

		binder.forField(cuentaAgrupadora)
//				.asRequired(cuentaAgrupadora.getLabel() + " es requerido.")
//				.withValidator(value -> (value != null) ? value.length() >= ${ATT_NAME_MIN} : true, cuentaAgrupadora.getLabel() + " tiene que contener al menos ${ATT_NAME_MIN} caracteres")
				.withValidator(value -> (value != null) ? value.length() <= 50 : true, cuentaAgrupadora.getLabel() + " tiene que contener igual o menos de 50 caracteres")
				.bind(CuentaContable::getCuentaAgrupadora, CuentaContable::setCuentaAgrupadora);

		// --------------------------------------------

		return cuentaAgrupadora;
	}

	public NumberField initPorcentaje(Binder<CuentaContable> binder) {

		// Porcentaje

		NumberField porcentaje = new NumberField();

		porcentaje.setLabel("Porcentaje");
//		porcentaje.setWidthFull();
		porcentaje.setClearButtonVisible(true);
//		porcentaje.setReadOnly(true);

		// --------------------------------------------

		binder.forField(porcentaje)
//				.asRequired(porcentaje.getLabel() + " es requerido.")
//				.withConverter(new MyStringToDoubleConverter(porcentaje.getLabel() + " tiene que ser un número"))
//				.withConverter(new DoubleToDConverter())
				.withValidator(value -> (value != null) ? value >= 0.0 : true,
						porcentaje.getLabel() + " tiene que ser >= " + 0.0)
				.withValidator(value -> (value != null) ? value <= 999.99 : true,
						porcentaje.getLabel() + " tiene que ser <= " + 999.99)

				.bind(CuentaContable::getPorcentaje, CuentaContable::setPorcentaje);

		// --------------------------------------------

		return porcentaje;
	}

	public PuntoEquilibrioCBX initPuntoEquilibrio(Binder<CuentaContable> binder) {

		// Punto de equilibrio

		PuntoEquilibrioCBX puntoEquilibrio = new PuntoEquilibrioCBX();

		puntoEquilibrio.setLabel("Punto de equilibrio");
//		puntoEquilibrio.setWidthFull();
		puntoEquilibrio.setClearButtonVisible(true);
//		puntoEquilibrio.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(puntoEquilibrio)
//				.asRequired(puntoEquilibrio.getLabel() + " es requerido.")
				.bind(CuentaContable::getPuntoEquilibrio, CuentaContable::setPuntoEquilibrio);

		// --------------------------------------------

		return puntoEquilibrio;
	}

	public PuntoEquilibrioCBXH initPuntoEquilibrioH(Binder<CuentaContable> binder) {

		// Punto de equilibrio

		PuntoEquilibrioCBX puntoEquilibrio = new PuntoEquilibrioCBX();

		puntoEquilibrio.setLabel("Punto de equilibrio");
		puntoEquilibrio.setWidthFull();
		puntoEquilibrio.setClearButtonVisible(true);
//		puntoEquilibrio.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(puntoEquilibrio)
//				.asRequired(puntoEquilibrio.getLabel() + " es requerido.")
				.bind(CuentaContable::getPuntoEquilibrio, CuentaContable::setPuntoEquilibrio);

		// --------------------------------------------

		return new PuntoEquilibrioCBXH(puntoEquilibrio);
	}

	public CostoVentaCBX initCostoVenta(Binder<CuentaContable> binder) {

		// Costo de venta

		CostoVentaCBX costoVenta = new CostoVentaCBX();

		costoVenta.setLabel("Costo de venta");
//		costoVenta.setWidthFull();
		costoVenta.setClearButtonVisible(true);
//		costoVenta.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(costoVenta)
//				.asRequired(costoVenta.getLabel() + " es requerido.")
				.bind(CuentaContable::getCostoVenta, CuentaContable::setCostoVenta);

		// --------------------------------------------

		return costoVenta;
	}

	public SeguridadPuertaCBX initSeguridadPuerta(Binder<CuentaContable> binder) {

		// Puerta

		SeguridadPuertaCBX seguridadPuerta = new SeguridadPuertaCBX();

		seguridadPuerta.setLabel("Puerta");
//		seguridadPuerta.setWidthFull();
		seguridadPuerta.setClearButtonVisible(true);
//		seguridadPuerta.setItemLabelGenerator(PuntoEquilibrio::getNombre);

		// --------------------------------------------

		binder.forField(seguridadPuerta)
//				.asRequired(seguridadPuerta.getLabel() + " es requerido.")
				.bind(CuentaContable::getSeguridadPuerta, CuentaContable::setSeguridadPuerta);

		// --------------------------------------------

		return seguridadPuerta;
	}
} // END CLASS -----------------------------------------------------------------