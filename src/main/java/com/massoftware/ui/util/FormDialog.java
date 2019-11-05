package com.massoftware.ui.util;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FormDialog extends Dialog {

	// ---------------------------------------------------------------------------------------------------------------------------

	private H3 title;
	private Button confirm;
	private Button abort;
	private Button close;
	private VerticalLayout content;

	// ---------------------------------------------------------------------------------------------------------------------------

	public FormDialog() {
		createHeader();
		createContent();
		createFooter();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public void setContent(Component component) {
		content.add(component);
	}

	@SuppressWarnings("unchecked")
	public void addConfirmationListener(@SuppressWarnings("rawtypes") ComponentEventListener listener) {
		confirm.addClickListener(listener);
	}

//	@SuppressWarnings("unchecked")
//	public void addAbortListener(@SuppressWarnings("rawtypes") ComponentEventListener listener) {
//		confirm.addClickListener(listener);
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void createHeader() {
		this.title = new H3();
		close = new Button();
		close.setIcon(VaadinIcon.CLOSE.create());
		close.addClickListener(buttonClickEvent -> close());

		HorizontalLayout header = new HorizontalLayout();
		header.add(this.title, close);
		header.setFlexGrow(1, this.title);
		header.setAlignItems(FlexComponent.Alignment.CENTER);
//		header.getStyle().set("background-color", "green");
		add(header);
	}

	private void createContent() {		
		content = new VerticalLayout();		
		content.setPadding(false);
//		content.getStyle().set("background-color", "red");
		add(content);
	}

	private void createFooter() {
		abort = new Button("Cancelar");
		abort.addClickListener(buttonClickEvent -> close());

		confirm = new Button("Guardar");
//		confirm.addClickListener(buttonClickEvent -> close());
		confirm.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		HorizontalLayout footer = new HorizontalLayout();
		footer.add(abort, confirm);
//		footer.add(confirm);
		footer.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
//		footer.getStyle().set("background-color", "yellow");
		add(footer);
	}

	@Override
	public void open() {
		super.open();
//		close.focus();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 40152453846491114L;

} // END CLASS -----------------------------------------------------------------