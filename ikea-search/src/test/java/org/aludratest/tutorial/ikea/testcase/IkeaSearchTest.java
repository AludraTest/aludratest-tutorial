package org.aludratest.tutorial.ikea.testcase;

import org.aludratest.service.ComponentId;
import org.aludratest.service.gui.web.AludraWebGUI;
import org.aludratest.testcase.AludraTestCase;
import org.aludratest.testcase.Test;
import org.aludratest.testcase.data.Source;
import org.aludratest.tutorial.ikea.main.IkeaMainPage;
import org.aludratest.tutorial.ikea.search.IkeaSearchData;
import org.aludratest.tutorial.ikea.search.IkeaSearchResultPage;
import org.aludratest.tutorial.ikea.search.PriceRangeData;

public class IkeaSearchTest extends AludraTestCase {

	// The test data for this test class. It contains multiple data sets, each representing a test case to execute (but all using
	// this class and its method).
	private static final String XML_FILE = "ikea_1.testdata.xml";

	// this method is invoked once for every test data configuration in the XML file. Every invocation is a single
	// test case.
	// The @Test annotation (AludraTest @Test, not JUnit @Test!) is important for the AludraTest engine to identify this
	// method as a test method.
	@Test
	public void testIkeaSearch(
			@Source(uri = XML_FILE, segment = "searchData") IkeaSearchData searchData,
			@Source(uri = XML_FILE, segment = "invalidPriceRangeData") PriceRangeData invalidPriceRangeData,
			@Source(uri = XML_FILE, segment = "validPriceRangeData") PriceRangeData validPriceRangeData
			) {
		// getService returns a new service to be used in the test. It is closed automatically when the test ends.
		// The second parameter, "ikea", allows us to specify service configuration especially for this service instance.
		// So, if you would create a folder, src/test/resources/config/ikea, and put an own seleniumWrapper.properties there,
		// configuration done there would override more generic parameters from src/test/resources/config/seleniumWrapper.properties.
		// See http://aludratest.github.io/aludratest/service-configuration.html for details.
		AludraWebGUI gui = getService(ComponentId.create(AludraWebGUI.class, "ikea"));

		// This is the whole test. The goal is that this is "human readable" and nearly equivalent to a textual
		// description of the test.
		newTestStepGroup("Open IKEA main page");
		gui.perform().open();
		gui.perform().windowMaximize();
		IkeaMainPage mainPage = new IkeaMainPage(gui);

		newTestStepGroup("Search for a keyword");
		IkeaSearchResultPage searchResultPage = mainPage.search(searchData);
		
		newTestStepGroup("Verify that an invalid price range displays an error");
		searchResultPage = searchResultPage.verifyInvalidPriceRange(invalidPriceRangeData);
		
		newTestStepGroup("Verify that a valid price range removes the error");
		searchResultPage = searchResultPage.verifyValidPriceRange(validPriceRangeData);
	}

}
