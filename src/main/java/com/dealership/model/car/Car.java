package com.dealership.model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents one car.
 *
 * @author sstankov
 */
public class Car {

	private Long id;
	private String brand;
	private String model;
	private TechnicalInformation technicalInformation;
	private List<Features> features;

	/**
	 * Instantiates a new car with an empty list of features.
	 */
	public Car() {
		this.features = new ArrayList<>();
	}

	/**
	 * Instantiates a new car.
	 *
	 * @param brand
	 *                the brand
	 * @param model
	 *                the model
	 * @param technicalInformation
	 *                the technical information
	 * @param features
	 *                the features
	 */
	public Car(final String brand, final String model, final TechnicalInformation technicalInformation,
	                final List<Features> features) {
		setBrand(brand);
		setModel(model);
		setTechnicalInformation(technicalInformation);
		setFeatures(features);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id, if the object hasn't already have an id and the provided
	 * id is not null. Checks are made with {@link Objects}
	 * 
	 * @param id
	 *                to be set
	 */
	public void setId(final Long id) {
		if ( Objects.isNull(this.id) )
			this.id = Objects.requireNonNull(id, "The id cannot be null!");
	}

	/**
	 * Sets the brand if the provided brand is not null. Check is made with
	 * {@link Objects}
	 *
	 * @param brand
	 *                to be set
	 */
	public void setBrand(final String brand) {
		this.brand = Objects.requireNonNull(brand, "The brand of the car cannot be null.");
	}

	/**
	 * Sets the model if the provided model is not null. Check is made with
	 * {@link Objects}
	 * 
	 * @param model
	 *                to be set
	 */
	public void setModel(final String model) {
		this.model = Objects.requireNonNull(model, "The model of the car cannot be null.");
	}

	/**
	 * Sets the technical information if the provided is not null. Check is
	 * made with {@link Objects}
	 * 
	 * @param technicalInformation
	 *                to be set
	 */
	public void setTechnicalInformation(final TechnicalInformation technicalInformation) {
		this.technicalInformation = Objects.requireNonNull(technicalInformation,
		                "The technical information cannot be null.");
	}

	/**
	 * Sets the features if the provided is not null. Check is made with
	 * {@link Objects}
	 * 
	 * @param features
	 *                to be set
	 */
	public void setFeatures(final List<Features> features) {
		this.features = Objects.requireNonNull(features, "The list of features cannot be null.");
	}

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Gets the technical information.
	 *
	 * @return the technical information
	 */
	public TechnicalInformation getTechnicalInformation() {
		return technicalInformation;
	}

	/**
	 * Gets the features.
	 *
	 * @return the features
	 */
	public List<Features> getFeatures() {
		return features;
	}

	@Override
	public int hashCode() {
		return (int) (id * id.hashCode()) & Integer.MAX_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		Car car = (Car) obj;
		return (car != null) && (car instanceof Car) && (car.getId() != null) && (this.getId() != null)
		                && car.getId().equals(this.getId()) && car.getBrand().equals(this.getBrand())
		                && car.getModel().equals(this.getModel())
		                && car.getTechnicalInformation().equals(this.getTechnicalInformation());
	}
}
