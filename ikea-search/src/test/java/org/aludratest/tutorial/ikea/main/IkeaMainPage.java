package org.aludratest.tutorial.ikea.main;

import org.aludratest.service.gui.web.AludraWebGUI;
import org.aludratest.service.gui.web.page.Page;
import org.aludratest.tutorial.ikea.search.IkeaSearchData;
import org.aludratest.tutorial.ikea.search.IkeaSearchResultPage;

public class IkeaMainPage extends Page {

	/**
	 * Creates a new Page object, which is an Action Word Library operating on the given GUI instance. The GUI should
	 * already have the IKEA main page open.
	 * 
	 * @param aludraGUI GUI instance to operate on.
	 */
	public IkeaMainPage(AludraWebGUI aludraGUI) {
		super(aludraGUI);
		checkCorrectPage();
	}
	
	// a private getter for our UI Map. Creates a new object every time to ensure the stateless nature of this
	// action word library.
	private IkeaMainUIMap getUIMap() {
		return new IkeaMainUIMap(aludraGUI);
	}
	
	@Override
	protected void checkCorrectPage() {
		// this validates that we have really the correct page open, and that the last action did not take us to the
		// wrong page. So add all checks here which ensure you are on exactly this, and not another, page.
		
		// the Departments list is only on Main Page
		getUIMap().departmentsList().assertVisible();
	}
	
	/**
	 * A classical Action Word on this class. Executes a search as specified in the given search object. Returns a new Action Word
	 * Library which is able to work on the new state of the GUI (the new page displayed in the browser).
	 * 
	 * @param search
	 *            Parameters for the search to execute.
	 * 
	 * @return The Action Word Library to perform operations on the search result.
	 */
	public IkeaSearchResultPage search(IkeaSearchData search) {
		// use stenstorp
		getUIMap().searchText().enter(search.getSearchText());
		getUIMap().searchButton().click();

		// return an action word library able to work on the new state of the GUI.
		return new IkeaSearchResultPage(aludraGUI);
	}

}
