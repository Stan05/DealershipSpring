package com.dealership.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dealership.model.Advertisement;
import com.dealership.model.AdvertisementRepository;

/**
 * This class has a connection to MySQL database through injected EntityManager.
 * Implements {@link AdvertisementRepository}
 */
@Transactional
@Repository
public class MySQLAdvertisementRepository implements AdvertisementRepository {

	private EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
		
	}

	/**
	 * Instantiates a new my SQL advertisement repository.
	 */
	public MySQLAdvertisementRepository() {
	}

	@Override
	public Advertisement getBy(final Long id) {
		return em.find(Advertisement.class, id);
	}

	@Override
	public List<Advertisement> getAll() {
		return em.createQuery("SELECT a FROM Advertisement a", Advertisement.class).getResultList();
	}

	@Override
	public Advertisement add(final Advertisement ad) {
		em.persist(ad);
		return ad;
	}

	@Override
	public List<Advertisement> searchByYears(int from, int to) {
		String query = "SELECT a FROM Advertisement a WHERE a.car.technicalInformation.firstRegistration BETWEEN "
		                + from + " AND " + to;
		return em.createQuery(query, Advertisement.class).getResultList();
	}

	@Override
	public boolean delete(final Long id) {
		Advertisement advertisement = em.find(Advertisement.class, id);
		em.remove(advertisement);
		return (em.find(Advertisement.class, id) == null);
	}

}
