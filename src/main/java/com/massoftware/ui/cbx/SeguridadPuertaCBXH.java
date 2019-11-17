package com.massoftware.ui.cbx;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SeguridadPuertaCBXH extends HorizontalLayout {

	public SeguridadPuertaCBX cbx;
	public Button buttonOpen;

	public SeguridadPuertaCBXH(SeguridadPuertaCBX cbx) {

//		this.setHeightFull();
		this.setPadding(false);
		this.setMargin(false);
		this.setSpacing(false);
		this.setWidthFull();

		buttonOpen = new Button("", clickEvent -> {
			cbx.openFormDialog();
		});
		buttonOpen.setIcon(new Icon(VaadinIcon.EXTERNAL_LINK));
		
		
		this.cbx = cbx;

		this.add(this.cbx, buttonOpen);
		
//		setAlignItems(FlexComponent.Alignment.CENTER);
		setAlignItems(Alignment.END);
	}

	@SuppressWarnings("unchecked")
	public void addOpenListener(@SuppressWarnings("rawtypes") ComponentEventListener listener) {
		buttonOpen.addClickListener(listener);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 2695867360064579950L;

} // END CLASS -----------------------------------------------------------------