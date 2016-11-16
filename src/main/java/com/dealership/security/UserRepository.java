package com.dealership.security;

/**
 * Provides methods for operating with user's database.
 * 
 */
public interface UserRepository {

	/**
	 * Gets the user searching it by username.
	 *
	 * @param username
	 *                the username to be searched
	 * @return the user if there is,otherwise return null
	 */
	User getUser(final String username);

	/**
	 * Adds user.
	 *
	 * @param user
	 *                to be added
	 * @return the saved User
	 */
	User add(final User user);
}
