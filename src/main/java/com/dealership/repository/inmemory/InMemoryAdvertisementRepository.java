package com.dealership.repository.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dealership.model.Advertisement;
import com.dealership.model.AdvertisementRepository;
import com.dealership.repository.inmemory.idgenerator.IdGenerator;

/**
 * 
 * In memory advertisement provider implementing {@link AdvertisementRepository}
 */
public class InMemoryAdvertisementRepository implements AdvertisementRepository {

	private List<Advertisement> advertisements;

	private IdGenerator idGenerator;

	/**
	 * Instantiates a new in memory advertisement repository.
	 *
	 * @param idGenerator
	 *                the id generator
	 */
	public InMemoryAdvertisementRepository(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
		this.advertisements = new ArrayList<>();

	}

	@Override
	public Advertisement getBy(final Long id) {
		for ( Advertisement advertisement : advertisements ) {
			if ( advertisement.getId().equals(id) ) {
				return advertisement;
			}
		}
		return new Advertisement();
	}

	@Override
	public List<Advertisement> getAll() {
		return advertisements;
	}

	@Override
	public Advertisement add(final Advertisement ad) {
		ad.setId(idGenerator.getNext());
		advertisements.add(ad);
		return ad;

	}

	@Override
	public List<Advertisement> searchByYears(int from, int to) {
		return advertisements.stream()
		                .filter(s -> between(from, to,
		                                s.getCar().getTechnicalInformation().getFirstRegistration()))
		                .collect(Collectors.toList());
	}

	/**
	 * Between.
	 *
	 * @param from
	 *                the from
	 * @param to
	 *                the to
	 * @param currnet
	 *                the currnet
	 * @return true, if successful
	 */
	private boolean between(int from, int to, int currnet) {
		return (currnet >= from) && (currnet <= to);
	}

	@Override
	public boolean delete(final Long id) {
		return advertisements.remove(id);

	}
}
