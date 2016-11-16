package com.dealership.web.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.dealership.security.User;

/**
 * Provide method for getting the current user.
 * 
 */
public class UserUtils {

	private UserUtils() {
	}

	/**
	 * Gets the current user who is logged in.
	 *
	 * @return the user
	 */
	public static User getLoggedInUser() {
		Object principal;

		try {
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch ( NullPointerException e ) {
			return null;
		}

		if ( principal == null || !(principal instanceof User) ) {
			return null;
		}

		return (User) principal;
	}
}
