package com.dealership.web.form.mapper;

/**
 * Provide methods to convert between form objects and model objects.
 *
 * @param <T>
 *            the form object
 * @param <V>
 *            the model object
 */
public interface Mapper<T, V> {

	/**
	 * Convert from model to form object.
	 * 
	 * @param model
	 *            object to be converted
	 * @return the converted form object.
	 */
	T mapForm(V model);

	/**
	 * Convert from form to model object.
	 * 
	 * @param form
	 *            object to be converted
	 * @return the converted model object
	 */
	V mapModel(T form);

}