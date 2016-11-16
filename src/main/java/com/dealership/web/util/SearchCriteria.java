package com.dealership.web.util;

import java.time.LocalDateTime;

/**
 * Encapsulates the start and end year in order to be used by
 * {@link com.dealership.web.service.impl.AdvertisementServiceImpl} and it's
 * search by years method.
 */
public class SearchCriteria {
	private int fromYear;
	private int toYear;

	/**
	 * Instantiates a new search criteria.
	 */
	public SearchCriteria() {

	}

	/**
	 * Gets the from year.
	 *
	 * @return the from year
	 */
	public int getFromYear() {
		return fromYear;
	}

	/**
	 * Sets the from year.If the provided year is -1 it is set to 0.
	 *
	 * @param fromYear
	 *                the new from year
	 */
	public void setFromYear(int fromYear) {
		this.fromYear = (fromYear != -1) ? fromYear : 0;
	}

	/**
	 * Gets the to year.
	 *
	 * @return the to year
	 */
	public int getToYear() {
		return toYear;
	}

	/**
	 * Sets the to year.If the provided year is -1 it is set to the current
	 * year, which is get from {@link LocalDateTime}
	 *
	 * @param toYear
	 *                the new to year
	 */
	public void setToYear(int toYear) {
		this.toYear = (toYear != -1) ? toYear : LocalDateTime.now().getYear();
	}

}
