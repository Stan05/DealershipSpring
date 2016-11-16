package com.dealership.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dealership.security.User;
import com.dealership.security.UserRepository;

/**
 * This class has a connection to MySQL database through injected EntityManager.
 * Implements {@link UserRepository}
 */
@Transactional
@Repository
public class MySQLUserRepository implements UserRepository {

	private EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public User getUser(final String username) {
		User user = null;
		try {
			user = em.createQuery("Select u FROM User u WHERE u.username = :username", User.class)
			                .setParameter("username", username).getSingleResult();
		} catch ( NoResultException ex ) {
			return user;
		}
		return user;
	}

	@Override
	public User add(final User user) {
		em.persist(user);
		return user;
	}
}
