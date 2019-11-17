package com.massoftware.ui;

import com.massoftware.b.service.util.Exception500;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class NotificationError extends Notification {

	// ---------------------------------------------------------------------------------------------------------------------------

	public NotificationError(Exception500 ex, String msg) {
		
		ex.printStackTrace();
		
//		ex.getException().printStackTrace();

		addThemeVariants(NotificationVariant.LUMO_ERROR);
		
		this.setPosition(Position.TOP_STRETCH);

		Label label = new Label(msg + ". Se produjo un error del sistema.");

		Button thisIsFineButton = new Button("Esto esta bien", e -> this.close());

//		Button investigateButton = new Button("Investigar", e -> this.close());
//		investigateButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		this.add(label, thisIsFineButton/*, investigateButton*/);

		Button openButton = new Button("Notificación de error", e -> this.open());
		openButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

		label.getStyle().set("margin-right", "0.5rem");
		thisIsFineButton.getStyle().set("margin-right", "0.5rem");
		
		open();
		
		
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 5640938119806942462L;

} // END CLASS -----------------------------------------------------------------
