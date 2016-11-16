package com.dealership.security;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

/**
 * This class represent one authority. Implements {@link GrantedAuthority}, in
 * order to be used by spring security.
 */
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = -2225029016285579171L;

	private Long id;

	private String authority;

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

	@Override
	public String getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 *
	 * @param authority
	 *                to be set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public int hashCode() {
		return (int) ((id == null ? 1 : id.hashCode()) * authority.hashCode()) & Integer.MAX_VALUE;
	}

	@Override
	public boolean equals(Object obj) {
		if ( this == obj )
			return true;
		if ( obj == null || getClass() != obj.getClass() )
			return false;

		final Authority other = (Authority) obj;
		return sameIdentityAs(other);

	}

	private boolean sameIdentityAs(Authority other) {
		return other != null && id.equals(other.id) && authority.equals(other.authority);
	}
}
