package org.aludratest.tutorial.ikea.search;

import org.aludratest.service.gui.web.AludraWebGUI;
import org.aludratest.service.gui.web.page.Page;

public class IkeaSearchResultPage extends Page {

	// for class contents, see IkeaMainPage

	public IkeaSearchResultPage(AludraWebGUI aludraGUI) {
		super(aludraGUI);
		checkCorrectPage();
	}

	private IkeaSearchResultUIMap getUIMap() {
		return new IkeaSearchResultUIMap(aludraGUI);
	}

	@Override
	protected void checkCorrectPage() {
		getUIMap().searchResultsHeader().assertVisible();
		getUIMap().searchRepeatText().assertVisible();
		getUIMap().searchSeriesText().assertVisible();
	}

	public IkeaSearchResultPage verifySearchResultFound() {
		getUIMap().searchSeriesText().assertTextContains("We found matches in the following series:");

		// to make clear we are stateless, return a new object every time, although type of Action Word Library does not
		// change in this case (same page afterwards). This avoids unintentionally stateful page classes.
		return new IkeaSearchResultPage(aludraGUI);
	}

	public IkeaSearchResultPage verifyInvalidPriceRange(PriceRangeData priceRange) {
		getUIMap().minPrice().enter(priceRange.getMinPrice());
		getUIMap().maxPrice().enter(priceRange.getMaxPrice());

		getUIMap().viewButton().click();
		getUIMap().priceRangeError().assertVisible();
		return new IkeaSearchResultPage(aludraGUI);
	}

	public IkeaSearchResultPage verifyValidPriceRange(PriceRangeData priceRange) {
		getUIMap().minPrice().enter(priceRange.getMinPrice());
		getUIMap().maxPrice().enter(priceRange.getMaxPrice());

		getUIMap().viewButton().click();
		// assertNotVisible is missing in AludraTest 3.0, but will be added to 3.1.
		if (getUIMap().priceRangeError().isVisible()) {
			aludraGUI.perform().functionalError("price range error should not be visible for valid price range");
		}

		return new IkeaSearchResultPage(aludraGUI);
	}

}
