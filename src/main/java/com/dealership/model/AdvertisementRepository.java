package com.dealership.model;

import java.util.List;

/**
 * Provide basic methods operating with advertisement database.
 * 
 * @author sstankov
 *
 */
public interface AdvertisementRepository {

	/**
	 * Gets the advertisement, searching by id.
	 *
	 * @param id
	 *                the id
	 * @return the found advertisement
	 */
	Advertisement getBy(final Long id);

	/**
	 * Gets all advertisements.
	 *
	 * @return list of advertisements.
	 */
	List<Advertisement> getAll();

	/**
	 * Adds one adertisement.
	 *
	 * @param ad
	 *                the advertisement to be added.
	 * @return the saved advertisement
	 */
	Advertisement add(final Advertisement ad);

	/**
	 * Search advertisements by querying the car's registration years.
	 *
	 * @param from
	 *                the start year for query
	 * @param to
	 *                the end year for query
	 * @return the list of found advertisements, if not found the list is
	 *         empty.
	 */
	List<Advertisement> searchByYears(int from, int to);

	/**
	 * Delete advertisement by given id.
	 *
	 * @param id
	 *                the id of the advertisement
	 * @return true if the Advertisement has been deleted
	 */
	boolean delete(final Long id);
}