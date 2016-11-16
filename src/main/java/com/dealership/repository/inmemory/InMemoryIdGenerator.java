package com.dealership.repository.inmemory;

import com.dealership.repository.inmemory.idgenerator.IdGenerator;

/**
 * 
 * In memory id generator implementing {@link IdGenerator}.
 */
public class InMemoryIdGenerator implements IdGenerator {

	private Long id;

	/**
	 * Instantiates a new in memory id generator. Sets initial id to 0.
	 */
	public InMemoryIdGenerator() {
		id = 0L;
	}

	@Override
	public Long getNext() {
		return id++;
	}

}
