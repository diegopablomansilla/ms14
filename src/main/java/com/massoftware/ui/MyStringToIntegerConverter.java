package com.massoftware.ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.vaadin.flow.data.converter.StringToIntegerConverter;

public class MyStringToIntegerConverter extends StringToIntegerConverter {

	// --------------------------------------------------------------------------------------------------

	public MyStringToIntegerConverter(String errorMessage) {
		super(errorMessage);
		// TODO Auto-generated constructor stub
	}

	// --------------------------------------------------------------------------------------------------

	protected NumberFormat getFormat(Locale locale) {
//		if (locale == null) {
//			locale = Locale.getDefault();
//		}		
		
		NumberFormat nf = NumberFormat.getIntegerInstance(locale);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("####");
		
		return df;
	}

	// --------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = -2950710116504076773L;

} // END CLASS -----------------------------------------------------------------
