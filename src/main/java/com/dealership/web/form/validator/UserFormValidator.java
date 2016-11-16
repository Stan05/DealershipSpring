package com.dealership.web.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dealership.web.form.UserForm;
import com.dealership.web.service.UserService;

/**
 * Implements {@link org.springframework.validation.Validator}. Used by
 * {@link com.dealership.web.UserController} to validate users who are trying to
 * register in the system.Checks if there is another user with the same
 * username.
 */
public class UserFormValidator implements Validator {

	private UserService userService;

	/**
	 * Instantiates a new user form validator.
	 *
	 * @param userService
	 *                the user service
	 */
	@Autowired
	public UserFormValidator(final UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return UserForm.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {
		UserForm user = (UserForm) obj;
		if ( userService.findBy(user.getUsername()) != null ) {
			error.rejectValue("username", "username.exist");
		}
	}

}
