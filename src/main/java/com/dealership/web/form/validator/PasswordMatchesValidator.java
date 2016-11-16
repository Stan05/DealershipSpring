package com.dealership.web.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dealership.web.form.UserForm;

/**
 * Implements {@link ConstraintValidator} with the custom annotation
 * {@link PasswordMatches} and {@link UserForm} Checks whether the password and
 * the matching password in the given {@code UserForm} are the same.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserForm> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(UserForm form, ConstraintValidatorContext context) {
		return form.getPassword().equals(form.getMatchingPassword());
	}

}
