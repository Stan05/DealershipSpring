package com.dealership.web.form;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.dealership.web.form.validator.PasswordMatches;

/**
 * This class is used in the user interface, in order to be binded by the user.
 * Every property is anotated with {@code javax.validation.constraints} for
 * auto-validating by Spring. Represents the {@link User} by splitting every
 * object in it to {@code String} or others primitive variables.
 * 
 *
 */
@PasswordMatches
public class UserForm {

    private Long id;

    @NotNull
    @Size(min = 1, max = 20)
    private String username;

    @NotNull
    @Size(min = 1, max = 15)
    private String password;
    private String matchingPassword;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Pattern(regexp = "(0|\\+359|00359)8[789]\\d{7}")
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 1, max = 15)
    private String city;

    /**
     * Instantiates a new user form.
     */
    public UserForm() {

    }

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
            this.id = Objects.requireNonNull(id, "The id of the user form cannot be null!");
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the matching password.
     *
     * @return the matching password
     */
    public String getMatchingPassword() {
        return matchingPassword;
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
    
    /**
     * Sets the username.
     *
     * @param username
     *            to be set
     */
    public void setUsername(final String username) {
            this.username = Objects.requireNonNull(username, "The username in user form cannot be nulL!");
    }
    
    /**
     * Sets the password if the provided is not null.Check is made with
     * {@link Objects}.
     *
     * @param password
     *            to be set
     */
    public void setPassword(final String password) {
        this.password = Objects.requireNonNull(password, "The password in user form cannot be null!");
    }

    /**
     * Sets the matching password if the provided is not null.Check is made with
     * {@link Objects}.
     *
     * @param matchingPassword
     *            to be set
     */
    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    /**
     * Sets the name if the provided name is not null. Check is made with
     * {@link Objects}
     * 
     * @param name
     *            to be set
     */
    public void setName(final String name) {
        this.name = Objects.requireNonNull(name, "The name in the user form cannot be null.");
    }

    /**
     * Sets the phone number if the provided is not null.Check is made with
     * {@link Objects}.
     *
     * @param phoneNumber
     *            to be set
     */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "The phonenumber in the user form cannot be null!");
    }

    /**
     * Sets the email if the provided is not null.Check is made with
     * {@link Objects}.
     *
     * @param email
     *            to be set
     */
    public void setEmail(final String email) {
        this.email = Objects.requireNonNull(email, "The email in the user form cannot be null!");
    }

    /**
     * Sets the city if the provided is not null.Check is made with
     * {@link Objects}.
     *
     * @param city
     *            to be set
     */
    public void setCity(final String city) {
        this.city = Objects.requireNonNull(city, "the city in the user form cannot be null!");
    }
    
    @Override
    public int hashCode() {
            return (int) ((id == null ? 1 : id.hashCode())) & Integer.MAX_VALUE;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null || getClass() != obj.getClass())
                    return false;

            final UserForm other = (UserForm) obj;
            return sameIdentityAs(other);

    }

    private boolean sameIdentityAs(UserForm other) {
            return other != null && id != null && other.id != null && id.equals(other.id);
    }
}
