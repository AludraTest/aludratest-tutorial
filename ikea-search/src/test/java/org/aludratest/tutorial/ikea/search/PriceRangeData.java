package org.aludratest.tutorial.ikea.search;

import org.aludratest.dict.Data;

public class PriceRangeData extends Data {

	// always use String for Data fields (or list of string, or other Data subclasses). This allows e.g. for
	// testing invalid input in number fields.
	private String minPrice;

	private String maxPrice;

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

}
