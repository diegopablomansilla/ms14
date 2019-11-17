package com.massoftware.ui;

import java.util.List;
import java.util.Optional;

import com.massoftware.a.model.util.EntityId;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.provider.SortOrder;
import com.vaadin.flow.data.selection.SelectionEvent;

public abstract class GridCustom<T> extends Grid<T> {

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean showToolBarColumn = false;

	// ---------------------------------------------------------------------------------------------------------------------------

	public GridCustom(Class<T> beanType, boolean showToolBarColumn) {
		super(beanType, false);

		// ----------------------------------------------------------------------

		this.showToolBarColumn = showToolBarColumn;

		// ----------------------------------------------------------------------

		this.setSelectionMode(SelectionMode.SINGLE);
		this.setMultiSort(false);
		this.setColumnReorderingAllowed(true);
		this.addThemeVariants(GridVariant.LUMO_NO_BORDER);

		// ----------------------------------------------------------------------

		addColumns();
		addColumnToolBar();
		addListeners();
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

	protected abstract Integer countFromService();

	protected abstract List<T> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc);

	protected abstract boolean removeItemFromService(T item);

	// ---------------------------------------------------------------------------------------------------------------------------

	protected abstract void addColumns();

	public void addColumnToolBar() {
		if (showToolBarColumn) {
			this.addComponentColumn(item -> createActionsColumn(this, item)).setKey("toolBar").setHeader("")
					.setTextAlign(ColumnTextAlign.END);
		}
	}

	public HorizontalLayout createActionsColumn(Grid<T> grid, T item) {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setMargin(false);
		hl.setPadding(false);
		hl.setSpacing(true);

		Button buttonRemove = new Button("", clickEvent -> {
			removeItemAction(item, item.toString());
		});
		buttonRemove.setIcon(new Icon(VaadinIcon.TRASH));
		buttonRemove.addThemeVariants(ButtonVariant.LUMO_ERROR);

		Button buttonOpen = new Button("", clickEvent -> {			
			open(item);
		});
		buttonOpen.setIcon(new Icon(VaadinIcon.EXTERNAL_LINK));

		hl.add(buttonRemove, buttonOpen);

		return hl;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected void addListeners() {

//		getElement().executeJavaScript("addKeyListenersCustom($0)", getElement());

		addSelectionListener(event -> selectItemAction(event));
		addItemDoubleClickListener(event -> doubleClickAction(event));

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void loadItems() {

		DataProvider<T, Void> dataProvider = DataProvider.fromCallbacks(

				query -> {

					int offset = query.getOffset();
					int limit = query.getLimit();
					Integer orderBy = null;
					Boolean orderByDesc = null;
					for (SortOrder<String> queryOrder : query.getSortOrders()) {
						orderBy = Integer.valueOf(queryOrder.getSorted());
						orderByDesc = queryOrder.getDirection() == SortDirection.DESCENDING;
					}

					List<T> items = findFromService(offset, limit, orderBy, orderByDesc);

					return items.stream();
				},

				query -> {
					int c = countFromService();

					if (c == 0) {
						notificationCantItems(c);
					}

					return c;
				}

		);

		setDataProvider(dataProvider);

	}

	private void notificationCantItems(int size) {

		Notification notification = new Notification(size + " items.", 1000);
		notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
		notification.open();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected void removeItemAction(T item) {
		removeItemAction(item, item.toString());
	}

	protected void removeItemAction(T item, String msg) {

		if (this.showToolBarColumn) {

			ConfirmationDialog confirmationDialog = new ConfirmationDialog();
			confirmationDialog.setTitle("¿ Estás seguro, quieres borrar el ítem ?");

			confirmationDialog.setQuestion(item != null ? msg : "");
			confirmationDialog.addConfirmationListener(buttonClickEvent -> {
				if (removeItemFromService(item)) {
					this.getDataProvider().refreshAll();
				}
			});
			confirmationDialog.open();

		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected void selectItemAction(SelectionEvent<Grid<T>, T> event) {
		Optional<T> selected = event.getFirstSelectedItem();
		if (selected.isPresent()) {
			selectItemAction(selected.get());
		}
	}

	protected void selectItemAction(T item) {
//		Notification.show(item.toString());
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected void doubleClickAction(ItemDoubleClickEvent<T> event) {
		if (this.showToolBarColumn) {
//			open(event.getItem());
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	protected void open(T item) {
		EntityId e = (EntityId) item;
		open(e.getId());
	}

	protected void open(String id) {
		Notification.show("Open: " + id);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 3226635924127481257L;

} // END CLASS -----------------------------------------------------------------