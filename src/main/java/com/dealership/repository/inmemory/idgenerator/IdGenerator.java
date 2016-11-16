package com.dealership.repository.inmemory.idgenerator;

/**
 * Provide method for operating with id generator.
 */
public interface IdGenerator {

	/**
	 * Gets the next id.
	 *
	 * @return the next id.
	 */
	Long getNext();
}
