package com.dealership.model.car;

/**
 * Represent the possible feature a car can have.
 * 
 * @author sstankov
 *
 */
public enum Features {
	ABS("ABS"),
	AIRBAG("Airbag"),
	AIR_CONDITIONING("Air conditioning"),
	ELECTRIC_WINDOWS("Electric windows"),
	ESP("ESP");

	private String featureName;

	private Features(final String featureName) {
		this.featureName = featureName;
	}

	/**
	 * Returns the human readable name of the feature
	 * 
	 */
	public String getFeatureName() {
		return this.featureName;
	}

}
