package com.dealership.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * Provides basic methods for operating with authority database.
 * 
 */
public interface AuthorityRepository {

	/**
	 * Gets all authorities.
	 *
	 * @return list of {@link GrantedAuthority}
	 */
	List<GrantedAuthority> getAll();

	/**
	 * Gets the authority by it's name.
	 *
	 * @param authority
	 *                the name to be searched by
	 * @return the found authority or null if not found
	 */
	GrantedAuthority getBy(final String authority);
}
