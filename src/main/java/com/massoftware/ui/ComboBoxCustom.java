package com.massoftware.ui;

import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.provider.DataProvider;

public abstract class ComboBoxCustom<T> extends ComboBox<T> {

	// ---------------------------------------------------------------------------------------------------------------------------

	public ComboBoxCustom() {

		// ----------------------------------------------------------------------

//		addListeners();
		this.focus();

		// ----------------------------------------------------------------------

		loadItems();

		// ----------------------------------------------------------------------

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void refreshAll() {
		this.getDataProvider().refreshAll();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected abstract Integer countFromService(String filterText);

	protected abstract List<T> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc,
			String filterText);

	protected abstract boolean removeItemFromService(T item);

	// ---------------------------------------------------------------------------------------------------------------------------

//	protected void addListeners() {
//
////		getElement().executeJavaScript("addKeyListenersCustom($0)", getElement());
//
//		addSelectionListener(event -> selectItemAction(event));
//		addItemDoubleClickListener(event -> doubleClickAction(event));
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void loadItems() {

		DataProvider<T, String> dataProvider = DataProvider.fromFilteringCallbacks(

				query -> {

					int offset = query.getOffset();
					int limit = query.getLimit();
					Integer orderBy = null;
					Boolean orderByDesc = null;

					// getFilter returns Optional<String>
					String filterText = query.getFilter().orElse(null);

					List<T> items = findFromService(offset, limit, orderBy, orderByDesc, filterText);

					if (items.size() == 1) {
						this.setValue(items.get(0));
					} else if (items.size() == 0) {
//						openFormDialog(filterText);
					}

					return items.stream();

//					return service.fetch(query.getOffset(), query.getLimit(), filter).stream();
				},

				query -> {

					String filterText = query.getFilter().orElse(null);

					int c = countFromService(filterText);

					if (c == 0) {
						notificationCantItems(c);
						if (filterText != null && filterText.trim().length() > 0) {
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							
//							System.out.println(filterText);
//							
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

//							openFormDialog();

//							this.setValue(null);
						}

					}

					return c;

//					return service.getCount(filter);
				}

		);

		setDataProvider(dataProvider);

	}

	private void notificationCantItems(int size) {

//		if(size == 0) {
//			this.setLabel("Tipo (" + size + " ítems)");
//		} else {
//			this.setLabel("Tipo");
//		}

		Notification notification = new Notification(size + " items.", 1000);
		notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
		notification.open();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	protected void removeItemAction(T item) {
//		removeItemAction(item, item.toString());
//	}

//	protected void removeItemAction(T item, String msg) {
//
//		ConfirmationDialog confirmationDialog = new ConfirmationDialog();
//		confirmationDialog.setTitle("¿ Estás seguro, quieres borrar el ítem ?");
//
//		confirmationDialog.setQuestion(item != null ? msg : "");
//		confirmationDialog.addConfirmationListener(buttonClickEvent -> {
//			if (removeItemFromService(item)) {
//				this.getDataProvider().refreshAll();
//			}
//		});
//		confirmationDialog.open();
//
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	protected void selectItemAction(SelectionEvent<Grid<T>, T> event) {
//		Optional<T> selected = event.getFirstSelectedItem();
//		if (selected.isPresent()) {
//			selectItemAction(selected.get());
//		}
//	}

//	protected void selectItemAction(T item) {
//		Notification.show(item.toString());
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	protected void doubleClickAction(ItemDoubleClickEvent<T> event) {
//		open(event.getItem());
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	protected void open(T item) {
//		EntityId e = (EntityId) item;
//		open(e.getId());
//	}

//	protected void open(String id) {
//		Notification.show("Open: " + id);
//	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void openFormDialog() {

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 3226635924127481257L;

} // END CLASS -----------------------------------------------------------------