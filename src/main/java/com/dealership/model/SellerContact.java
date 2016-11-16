package com.dealership.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * Represents the contacts of the seller.
 *
 * @author sstankov
 */
public class SellerContact {

	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private String city;

	/**
	 * Instantiates a new seller contact.
	 * 
	 */
	public SellerContact() {

	}

	/**
	 * Instantiates a new seller contact.
	 *
	 * @param name
	 *                the name
	 * @param phoneNumber
	 *                the phone number
	 * @param email
	 *                the email
	 * @param city
	 *                the city
	 */
	public SellerContact(final String name, final String phoneNumber, final String email, final String city) {
		setName(name);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setCity(city);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public final Long getId() {
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
	 * Sets the name if the provided name is not null. Check is made with
	 * {@link Objects}
	 * 
	 * @param name
	 *                to be set
	 */
	public void setName(final String name) {
		this.name = Objects.requireNonNull(name, "The name of the seller cannot be null.");
	}

	/**
	 * Sets the phone number if the provided phone number is not null.
	 * Validate phone number with regular expression :
	 * <code>(0|\\+359|00359)8[789]\\d{7}</code>.
	 *
	 * @param phoneNumber
	 *                to be set
	 * @throws IlleagalArgumentException
	 *                 if the phone number doesn't pass the regular
	 *                 expression.
	 */
	public void setPhoneNumber(final String phoneNumber) {
		Objects.requireNonNull(phoneNumber, "The phone number of the seller connot be null.");
		if ( !isPhoneNumberValid(phoneNumber) )
			throw new IllegalArgumentException("The phone number is invalid.");
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Sets the email if the email is valid. The validation is made with
	 * {@link EmailValidator}
	 *
	 * @param email
	 *                to be set
	 * @throws IllegalArgumentException
	 *                 if the validation is not passed
	 */
	public void setEmail(String email) {
		if ( !isEmailValid(email) )
			throw new IllegalArgumentException("The email is invalid or null.");
		this.email = email;

	}

	/**
	 * Sets the city if the provided city is not null. Check is made with
	 * {@link Objects}
	 * 
	 * @param city
	 *                to be set
	 */
	public void setCity(final String city) {
		this.city = Objects.requireNonNull(city, "The city of the seller cannot be null");
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	private boolean isEmailValid(final String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	private boolean isPhoneNumberValid(final String phoneNumber) {
		Pattern pattern = Pattern.compile("(0|\\+359|00359)8[789]\\d{7}");
		Matcher match = pattern.matcher(phoneNumber);
		return match.find();
	}

	@Override
	public int hashCode() {
		return (int) (id * phoneNumber.hashCode()) & Integer.MAX_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		SellerContact contact = (SellerContact) obj;
		return (contact != null) && (contact instanceof SellerContact) && (contact.getId() != null)
		                && (this.getId() != null) && contact.getId().equals(this.getId())
		                && contact.getName().equals(this.getName())
		                && contact.getPhoneNumber().equals(this.getPhoneNumber())
		                && contact.getEmail().equals(this.getEmail())
		                && contact.getCity().equals(this.getCity());
	}

}