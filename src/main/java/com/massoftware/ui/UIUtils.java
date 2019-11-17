package com.massoftware.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class UIUtils {

	public static void setTooltip(String tooltip, Component... components) {
		for (Component component : components) {
			component.getElement().setProperty("title", tooltip);
		}
	}

	/* === ICONS === */

	public static Icon createPrimaryIcon(VaadinIcon icon) {
		Icon i = new Icon(icon);
		setTextColor(TextColor.PRIMARY, i);
		return i;
	}

	public static Icon createDisabledIcon(VaadinIcon icon) {
		Icon i = new Icon(icon);
		setTextColor(TextColor.DISABLED, i);
		return i;
	}

	/* === CSS UTILITIES === */

	public static void setTextColor(TextColor textColor, Component... components) {
		for (Component component : components) {
			component.getElement().getStyle().set("color", textColor.getValue());
		}
	}

	public static String formtatCC(String cuentaJerarquia) {

		String formatted = "";

		if (cuentaJerarquia != null && cuentaJerarquia.length() == 11) {

			for (int i = 0; i < 11; i++) {

				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
					formatted += ".";
				}
				formatted += cuentaJerarquia.charAt(i);

//				if (i == 0) {
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 1) {
//					formatted += ".";
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 2) {
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 3) {
//					formatted += ".";
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 4) {
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 5) {
//					formatted += ".";
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 6) {
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 7) {
//					formatted += ".";
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 8) {
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 9) {
//					formatted += ".";
//					formatted += item.getCuentaJerarquia().charAt(i);
//				} else if (i == 10) {
//					formatted += item.getCuentaJerarquia().charAt(i);
//				}
			}

		} else if (cuentaJerarquia != null && cuentaJerarquia.length() != 11) {

			return cuentaJerarquia;
		}

		return formatted;
	}
	
	

	public static String formtatCCPrefixSufix(String cuentaJerarquia) {

		String formattedSufix = "";
		String formattedPrefix = "";

		if (cuentaJerarquia != null && cuentaJerarquia.length() == 11) {

			int c = 0;

			String s1 = cuentaJerarquia.charAt(c) + "";
			String s2 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s3 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s4 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s5 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);
			String s6 = cuentaJerarquia.charAt(++c) + "" + cuentaJerarquia.charAt(++c);

			int p1 = Integer.valueOf(s1);
			int p2 = Integer.valueOf(s2);
			int p3 = Integer.valueOf(s3);
			int p4 = Integer.valueOf(s4);
			int p5 = Integer.valueOf(s5);
			int p6 = Integer.valueOf(s6);

			if (p1 > 0 && p2 == 0 && p3 == 0 & p4 == 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = "";
				formattedSufix = s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 == 0 & p4 == 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1;
				formattedSufix = s2 + "." + s3 + "." + s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 > 0 & p4 == 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2;
				formattedSufix =  s3 + "." + s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 > 0 & p4 > 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2 + "." + s3;
				formattedSufix = s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 > 0 & p4 > 0 && p5 > 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2 + "." + s3 + "." + s4;
				formattedSufix = s5 + "." + s6;
				
			} else if (p6 >= 0) {
				
				formattedPrefix = s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;
				formattedSufix = s6;
			}

		} else if (cuentaJerarquia != null && cuentaJerarquia.length() != 11) {

//			throw new IllegalArgumentException("Cuenta de Jerarquia debe ser de 11 caracteres.");
			
			return  null;
		}

		return  formattedPrefix + ";" + formattedSufix;
	}
	
	public static String formtatCCIntegraPrefixSufix(String integra) {

		String formattedSufix = "";
		String formattedPrefix = "";

		if (integra != null && integra.length() == 11) {

			int c = 0;

			String s1 = integra.charAt(c) + "";
			String s2 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s3 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s4 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s5 = integra.charAt(++c) + "" + integra.charAt(++c);
			String s6 = integra.charAt(++c) + "" + integra.charAt(++c);

			int p1 = Integer.valueOf(s1);
			int p2 = Integer.valueOf(s2);
			int p3 = Integer.valueOf(s3);
			int p4 = Integer.valueOf(s4);
			int p5 = Integer.valueOf(s5);
			int p6 = Integer.valueOf(s6);

			if (p1 > 0 && p2 == 0 && p3 == 0 & p4 == 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1 + "";
				formattedSufix =  s2 + "." + s3 + "." + s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 == 0 & p4 == 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2;
				formattedSufix =  s3 + "." + s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 > 0 & p4 == 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2 + "." + s3;
				formattedSufix =  s4 + "." + s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 > 0 & p4 > 0 && p5 == 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2 + "." + s3 + "." + s4;
				formattedSufix =   s5 + "." + s6;
				
			} else if (p1 > 0 && p2 > 0 && p3 > 0 & p4 > 0 && p5 > 0 && p6 == 0) {
				
				formattedPrefix = s1 + "." + s2 + "." + s3 + "." + s4 + "." + s5;
				formattedSufix =  s6;
				
			} 
//			else if (p6 >= 0) {
//				
//				formattedPrefix = s2 + "." + s3 + "." + s4 + "." + s5;
//				formattedSufix = s6;
//			}

		} else if (integra != null && integra.length() != 11) {

//			throw new IllegalArgumentException("Cuenta de Jerarquia debe ser de 11 caracteres.");
			
			return  null;
		}

		return  formattedPrefix + ";" + formattedSufix;
	}

} // END CLASS -----------------------------------------------------------------