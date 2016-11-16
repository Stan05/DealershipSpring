package com.dealership.web.service;

import com.dealership.web.form.UserForm;

/**
 * Provides identical methods to {@link com.dealership.security.UserRepository}.
 * 
 */
public interface UserService {

	/**
	 * Creates the user.
	 *
	 * @param userForm
	 *                the user form from which to be created the user
	 */
	UserForm createUser(final UserForm userForm);

	/**
	 * Find user by username.
	 *
	 * @param username
	 *                to be searched
	 * @return the user
	 */
	UserForm findBy(String username);
}
