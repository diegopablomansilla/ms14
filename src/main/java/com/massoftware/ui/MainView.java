package com.massoftware.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.massoftware.c.persist.DataBases;
import com.massoftware.ui.views.CentroCostoContableViewList;
import com.massoftware.ui.views.EjercicioContableViewList;
import com.massoftware.ui.views.PuntoEquilibrioViewList;
import com.massoftware.ui.views.views.form.FormView;
import com.massoftware.ui.views.views.list.ListView;
import com.massoftware.ui.views.views.masterdetail.MasterDetailView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
@PWA(name = "MasSoftware", shortName = "MasSoftware")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MainView extends AppLayout {

	// ---------------------------------------------------------------------------------------------------------------------------

	private final Tabs menu;

	// ---------------------------------------------------------------------------------------------------------------------------

	public MainView() {

		DataBases.setup();

		menu = createMenuTabs();
		addToNavbar(menu);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private static Tabs createMenuTabs() {

		final Tabs tabs = new Tabs();

		tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
		tabs.add(getAvailableTabs());

		return tabs;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private static Tab[] getAvailableTabs() {

		final List<Tab> tabs = new ArrayList<>();

		tabs.add(createTab("List", ListView.class));
		tabs.add(createTab("MasterDetail", MasterDetailView.class));
		tabs.add(createTab("Form", FormView.class));		
		tabs.add(createTab("Ejercicios", EjercicioContableViewList.class));
		tabs.add(createTab("CC", CentroCostoContableViewList.class));
		tabs.add(createTab("Punto equilibrio", PuntoEquilibrioViewList.class));

		return tabs.toArray(new Tab[tabs.size()]);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private static Tab createTab(String title, Class<? extends Component> viewClass) {
		return createTab(populateLink(new RouterLink(null, viewClass), title));
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private static Tab createTab(Component content) {

		final Tab tab = new Tab();

		tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
		tab.add(content);

		return tab;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private static <T extends HasComponents> T populateLink(T a, String title) {
		a.add(title);
		return a;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		selectTab();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	private void selectTab() {
		String target = RouteConfiguration.forSessionScope().getUrl(getContent().getClass());
		Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
			Component child = tab.getChildren().findFirst().get();
			return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
		}).findFirst();
		tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 3226635924127481267L;

} // END CLASS -----------------------------------------------------------------