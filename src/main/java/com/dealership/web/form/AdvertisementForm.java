package com.dealership.web.form;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.dealership.model.car.Features;
import com.dealership.security.User;

/**
 * This class is used in the user interface, in order to be binded by the user.
 * Every property is anotated with {@code javax.validation.constraints} for
 * auto-validating by Spring. Represents the {@link Advertisement} by splitting
 * every object in it to {@code String} or others primitive variables.
 * 
 *
 */
public class AdvertisementForm {

	private Long id;
	
	@NotNull
	@Size(min = 3, max = 10)
	private String brand;

	@NotNull
	@Size(min = 1, max = 10)
	private String model;

	private int firstRegistration;

	@NotNull
	private String fuel;

	@Min(1)
	@Max(999999)
	private int mileage;

	@NotEmpty
	private List<Features> features;

	private User user;

	@Min(1)
	@Max(Integer.MAX_VALUE)
	private int price;
	

	/**
	 * Instantiates a new advertisement form.
	 */
	public AdvertisementForm() {

	}

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
                        this.id = Objects.requireNonNull(id, "The id of the advertisement form cannot be null!");
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
         * Sets the brand if the provided brand is not null. Check is made with
         * {@link Objects}
         *
         * @param brand
         *                to be set
         */
        public void setBrand(final String brand) {
                this.brand = Objects.requireNonNull(brand, "The brand of the advertisement form cannot be null.");
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
         * Sets the model if the provided model is not null. Check is made with
         * {@link Objects}
         * 
         * @param model
         *                to be set
         */
        public void setModel(final String model) {
                this.model = Objects.requireNonNull(model, "The model of the advertisement form cannot be null.");
        }

	/**
	 * Gets the first registration.
	 *
	 * @return the first registration
	 */
	public int getFirstRegistration() {
		return firstRegistration;
	}

	/**
	 * Sets the first registration.
	 *
	 * @param firstRegistration
	 *                to be set
	 */
	public void setFirstRegistration(int firstRegistration) {
		this.firstRegistration = firstRegistration;
	}

	/**
	 * Gets the fuel.
	 *
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
         * Sets the type of fuel if the provided fuel is not null.Check is made with {@link Objects}.
         * 
         * @param fuel
         *                to be set
         */
        public void setFuel(final String fuel) {
                this.fuel = Objects.requireNonNull(fuel, "The fuel of the advertisement form cannot be null.");

        }

	/**
	 * Gets the mileage.
	 *
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
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
	 * Gets the features.
	 *
	 * @return the features
	 */
	public List<Features> getFeatures() {
		return features;
	}

	/**
         * Sets the features if the provided is not null. Check is made with
         * {@link Objects}
         * 
         * @param features
         *                to be set
         */
        public void setFeatures(final List<Features> features) {
                this.features = Objects.requireNonNull(features, "The list of features in advertisement form cannot be null.");
        }

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
         * Sets the user if the provided is not null. Check is made with
         * {@link Objects}
         * 
         * @param user
         *                to be set
         */
        public void setUser(final User user) {
                this.user = Objects.requireNonNull(user, "User in the advertisement form cannot be null.");
        }

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *                to be set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
        public int hashCode() {
                return (int) ((id == null ? 1 : id.hashCode())) & Integer.MAX_VALUE;
        }

        @Override
        public boolean equals(Object obj) {
                if ( this == obj )
                        return true;
                if ( obj == null || getClass() != obj.getClass() )
                        return false;

                final AdvertisementForm other = (AdvertisementForm) obj;
                return sameIdentityAs(other);

        }

        private boolean sameIdentityAs(AdvertisementForm other) {
                return other != null && 
                                id != null && 
                                other.id != null && 
                                id.equals(other.id);
        }
}
