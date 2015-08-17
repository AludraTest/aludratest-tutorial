package org.aludratest.tutorial.ikea.search;

import org.aludratest.service.gui.component.Button;
import org.aludratest.service.gui.component.InputField;
import org.aludratest.service.gui.component.Label;
import org.aludratest.service.gui.web.AludraWebGUI;
import org.aludratest.service.gui.web.uimap.UIMap;
import org.aludratest.service.locator.element.GUIElementLocator;
import org.aludratest.service.locator.element.IdLocator;
import org.aludratest.service.locator.element.XPathLocator;

public class IkeaSearchResultUIMap extends UIMap {

	// see IkeaMainUIMap for what this is
	private static GUIElementLocator SEARCH_RESULTS_HEADER = new XPathLocator("//h2[contains(., 'Search Results')]");

	private static GUIElementLocator SEARCH_REPEAT_TEXT = new XPathLocator("//div[@class='serpSearchString']");

	private static GUIElementLocator SEARCH_SERIES_TEXT = new IdLocator("serpSearchSeries");

	private static GUIElementLocator MIN_PRICE = new IdLocator("minPrice");

	private static GUIElementLocator MAX_PRICE = new IdLocator("maxPrice");

	private static GUIElementLocator VIEW_BUTTON = new XPathLocator("//input[@type='button' and @value='View']");

	private static GUIElementLocator PRICERANGE_ERROR = new IdLocator("minMaxPriceError");

	public IkeaSearchResultUIMap(AludraWebGUI aludraGUI) {
		super(aludraGUI);
	}

	public Label searchResultsHeader() {
		return aludraGUI.getComponentFactory().createLabel(SEARCH_RESULTS_HEADER);
	}

	public Label searchRepeatText() {
		return aludraGUI.getComponentFactory().createLabel(SEARCH_REPEAT_TEXT);
	}

	public Label searchSeriesText() {
		return aludraGUI.getComponentFactory().createLabel(SEARCH_SERIES_TEXT);
	}

	public InputField minPrice() {
		return aludraGUI.getComponentFactory().createInputField(MIN_PRICE);
	}

	public InputField maxPrice() {
		return aludraGUI.getComponentFactory().createInputField(MAX_PRICE);
	}

	public Button viewButton() {
		return aludraGUI.getComponentFactory().createButton(VIEW_BUTTON);
	}

	public Label priceRangeError() {
		return aludraGUI.getComponentFactory().createLabel(PRICERANGE_ERROR);
	}

}
