package com.dealership.security;

import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dealership.model.SellerContact;

/**
 * Represent one user implements {@link UserDetails}, in order to be used in
 * spring security.
 * 
 */
public class User implements UserDetails {

    private static final long serialVersionUID = -5025098630443219650L;

    private Long id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private SellerContact userContact;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    /**
     * Instantiates a new user.
     */
    public User() {
        this.enabled = true;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

    /**
     * Instantiates a new user.
     *
     * @param username
     *            the username
     * @param password
     *            the password
     * @param authorities
     *            the authorities
     */
    public User(String username, String password, List<GrantedAuthority> authorities) {
        this();
        this.username = username;
        this.password = password;
        this.authorities = authorities;
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
     * Sets the id, if the object hasn't already have an id and the provided id
     * is not null. Checks are made with {@link Objects}
     * 
     * @param id
     *            to be set
     */
    public void setId(final Long id) {
        if (Objects.isNull(this.id))
            this.id = Objects.requireNonNull(id, "The id cannot be null!");
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username if the provided is not null. Check is made with
     * {@link Objects}.
     *
     * @param username
     *            to be set
     */
    public void setUsername(final String username) {
        this.username = Objects.requireNonNull(username, "The username cannot be null!");
    }

    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password if the provided password is not null.
     *
     * @param password
     *            to be set
     */
    public void setPassword(final String password) {
        this.password = Objects.requireNonNull(password, "The password cannot be null!");
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Sets the authorities if the provided authorities is not null.
     *
     * @param authorities2
     *            to be set
     */
    public void setAuthorities(final List<GrantedAuthority> authorities2) {
        this.authorities = Objects.requireNonNull(authorities2, "The list of authorities of the user cannot be null.");
    }

    /**
     * Gets the user contact.
     *
     * @return the user contact
     */
    public SellerContact getUserContact() {
        return userContact;
    }

    /**
     * Sets the user contact if the provided contacts are not null.
     *
     * @param userContact
     *            to be set
     */
    public void setUserContact(final SellerContact userContact) {
        this.userContact = Objects.requireNonNull(userContact, "User contacts cannot beb null!");
    }

    @Override
    public int hashCode() {
        return (int) ((id == null ? 1 : id.hashCode()) * username.hashCode()) & Integer.MAX_VALUE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        final User other = (User) obj;
        return sameIdentityAs(other);

    }

    private boolean sameIdentityAs(User other) {
        return other != null && 
                id != null && 
                other.id != null && 
                id.equals(other.id);
    }
}
