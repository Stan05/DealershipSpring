package com.dealership.web.service;

import java.util.List;

import com.dealership.model.AdvertisementRepository;
import com.dealership.web.form.AdvertisementForm;
import com.dealership.web.util.SearchCriteria;

/**
 * Provide identical methods to {@link AdvertisementRepository}.
 * 
 */
public interface AdvertisementService {

	/**
	 * Gets all advertisement forms from the repository
	 *
	 * @return list of advertisement forms or empty list if there aren't any
	 */
	List<AdvertisementForm> getAllAdvertisements();

	/**
	 * Gets advertisement form by id from the repository.
	 *
	 * @param id
	 *                to be searched by
	 * @return the advertisement form
	 */
	AdvertisementForm getBy(final Long id);

	/**
	 * Search advertisement forms by specific search criteria in the repository.
	 *
	 * @param searchCriteria
	 *                the search criteria
	 * @return the list of advertisement forms
	 * @see SearchCriteria
	 */
	List<AdvertisementForm> seacrhBy(final SearchCriteria searchCriteria);

	/**
	 * Adds advertisement form to the repository.
	 *
	 * @param advertisementForm
	 *               to be added 
	 */
	AdvertisementForm add(final AdvertisementForm advertisementForm);

	/**
	 * Delete advertisement form by given id from the repository.
	 *
	 * @param id
	 *                of the advertisement form to be deleted
	 * @return true if the object is deleted and false if it is not
	 */
	boolean delete(final Long id);
}