package com.dealership.model;

import java.util.Date;
import java.util.Objects;

import com.dealership.model.car.Car;
import com.dealership.security.User;

/**
 * Represents one car advertisement.
 * 
 * @author sstankov
 *
 */
public class Advertisement {

	private Long id;
	private Car car;
	private User owner;
	private Date creationDate;
	private int price;

	/**
	 * Instantiates a new advertisement.
	 *
	 * @param id
	 *                the id
	 * @param car
	 *                the car
	 * @param owner
	 *                the owner
	 * @param price
	 *                the price
	 */
	public Advertisement(final Long id, final Car car, final User owner, int price) {
		setId(id);
		setCar(car);
		setOwner(owner);
		setPrice(price);
		this.creationDate = new Date();
	}

	/**
	 * Instantiates a new advertisement.
	 */
	public Advertisement() {
		this.creationDate = new Date();
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
         * Sets the car if the provided is not null. Check is made with
         * {@link Objects}.
         * 
         * @param car
         *            to be set
         */
        public void setCar(final Car car) {
                if (Objects.isNull(this.car))
                        this.car = Objects.requireNonNull(car, "The car in the advertisement cannot be null.");
        }


	/**
	 * Sets the owner if the provided is not null. Check is made with
	 * {@link Objects}
	 * 
	 * @param owner
	 *                to be set
	 */
	public void setOwner(final User owner) {
		this.owner = Objects.requireNonNull(owner, "User in the advertisement cannot be null.");
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

	/**
	 * Gets the creation date of the advertisement.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Gets the car.
	 *
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate
	 *                to be set
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return (int) ((id == null ? 1 : id.hashCode()) * creationDate.hashCode()) & Integer.MAX_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj )
			return true;
		if ( obj == null || getClass() != obj.getClass() )
			return false;

		final Advertisement other = (Advertisement) obj;
		return sameIdentityAs(other);

	}

	private boolean sameIdentityAs(Advertisement other) {
	    return other != null && id != null && other.id != null && id.equals(other.id);
	}

}