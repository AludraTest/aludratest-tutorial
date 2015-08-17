package org.aludratest.tutorial.ikea.main;

import org.aludratest.service.gui.component.Button;
import org.aludratest.service.gui.component.InputField;
import org.aludratest.service.gui.component.Label;
import org.aludratest.service.gui.component.Link;
import org.aludratest.service.gui.web.AludraWebGUI;
import org.aludratest.service.gui.web.uimap.UIMap;
import org.aludratest.service.locator.element.GUIElementLocator;
import org.aludratest.service.locator.element.IdLocator;
import org.aludratest.service.locator.element.XPathLocator;

/**
 * Reflects components important for testing on the IKEA Main page (http://www.ikea.com/gb/en/). <br>
 * Component IDs are taken from web page using e.g. Chrome Developer Tools or FireBug. <br>
 * This UIMap is used by {@link IkeaMainPage}.
 * 
 * @author falbrech
 * 
 */
public class IkeaMainUIMap extends UIMap {

	// collect all relevant locators here.
	private static final GUIElementLocator LOGO_HEADER = new IdLocator("lnkIKEALogoHeader");

	private static final GUIElementLocator SEARCH_TEXT = new IdLocator("search");

	// no ID available for button - so use XPath.
	private static final GUIElementLocator SEARCH_BUTTON = new XPathLocator(
			"//form[@id='searchForm']//input[@type='button' and @value='Search']");

	// a component solely to ensure we are on main page.
	private static final GUIElementLocator DEPARTMENTS_LIST = new XPathLocator("//div[contains(@class, 'departmentLinkBlock')]");

	// Constructor must take GUI instance and pass it to super constructor. This initializes protected field with GUI.
	public IkeaMainUIMap(AludraWebGUI gui) {
		super(gui);
	}

	/**
	 * Returns the component reflecting the IKEA Logo.
	 * 
	 * @return The component reflecting the IKEA Logo, as a link.
	 */
	public Link headerLogo() {
		return aludraGUI.getComponentFactory().createLink(LOGO_HEADER);
	}

	/**
	 * Returns the component reflecting the search input field.
	 * 
	 * @return The component reflecting the search input field.
	 */
	public InputField searchText() {
		return aludraGUI.getComponentFactory().createInputField(SEARCH_TEXT);
	}

	/**
	 * Returns the component reflecting the search button.
	 * 
	 * @return The component reflecting the search button.
	 */
	public Button searchButton() {
		return aludraGUI.getComponentFactory().createButton(SEARCH_BUTTON);
	}

	/**
	 * Returns the component reflecting the Departments list. Can use Label for this, as only simple actions like
	 * <code>assertVisible()</code> should be executed on this.
	 * 
	 * @return The component reflecting the Departments list.
	 */
	public Label departmentsList() {
		return aludraGUI.getComponentFactory().createLabel(DEPARTMENTS_LIST);
	}

}
