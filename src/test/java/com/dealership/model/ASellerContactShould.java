package com.dealership.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ASellerContactShould {
	private SellerContact sellerContact;

	@Before
	public void initSeller() {
		sellerContact = new SellerContact("Stanislav", "0898762116", "stanislav9505@gmail.com", "Varna");

	}

	@Test
	public void createItSelfWithNecessaryFields() {
		assertNotNull("The seller contact is not created", sellerContact);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWithNullEmail() {
		sellerContact.setEmail(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWithInvalidEmail() {
		sellerContact.setEmail(".@abv.bg");
	}
	@Test(expected = IllegalArgumentException.class)
	public void throwExceptionWithInvalidPhoneNumber(){
		sellerContact.setPhoneNumber("000");
	}
}
