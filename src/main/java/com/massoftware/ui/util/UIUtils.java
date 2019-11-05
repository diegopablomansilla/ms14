package com.massoftware.ui.util;

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

} // END CLASS -----------------------------------------------------------------