package com.dealership.model.car;

import java.util.Objects;

/**
 * Represents the technical information of the car.
 * 
 * @author sstankov
 *
 */
public class TechnicalInformation {

	private int firstRegistration;
	private String fuel;
	private int mileage;

	/**
	 * Instantiates a new technical information.
	 */
	public TechnicalInformation() {

	}

	/**
	 * Instantiates a new technical information.
	 * 
	 * @param firstRegistration
	 *                the year of registration
	 * @param fuel
	 *                the type of fuel
	 * @param mileage
	 *                the mileage
	 */
	public TechnicalInformation(int firstRegistration, String fuel, int mileage) {
		this.firstRegistration = firstRegistration;
		this.fuel = fuel;
		this.mileage = mileage;
	}

	/**
	 * Sets the year of registration.
	 * 
	 * @param year
	 *                to be set
	 */
	public void setFirstRegistration(int year) {
		this.firstRegistration = year;
	}

	/**
	 * Sets the type of fuel.
	 * 
	 * @param fuel
	 *                to be set
	 */
	public void setFuel(final String fuel) {
		this.fuel = Objects.requireNonNull(fuel, "The fuel of the car cannot be null.");

	}

	/**
	 * Sets the mileage.
	 * 
	 * @param mileage
	 *                to be set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;

	}

	/**
	 * Gets the year of first registration.
	 * 
	 * @return the first registration
	 */
	public int getFirstRegistration() {
		return firstRegistration;
	}

	/**
	 * Gets the type of fuel.
	 * 
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * Gets the mileage.
	 * 
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	@Override
	public int hashCode() {
		return (int) (fuel.hashCode() * 13) & Integer.MAX_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		TechnicalInformation info = (TechnicalInformation) obj;
		return (info != null) && (info instanceof TechnicalInformation)
		                && info.getFirstRegistration() == this.getFirstRegistration()
		                && info.getFuel().equals(this.getFuel()) && info.getMileage() == this.getMileage();
	}
}