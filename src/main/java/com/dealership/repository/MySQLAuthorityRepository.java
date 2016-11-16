package com.dealership.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import com.dealership.security.AuthorityRepository;

/**
 * This class has a connection to MySQL database through injected EntityManager.
 * Implements {@link AuthorityRepository}
 */
@Repository
public class MySQLAuthorityRepository implements AuthorityRepository {
	private EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<GrantedAuthority> getAll() {
		return em.createQuery("SELECT a FROM Authority a", GrantedAuthority.class).getResultList();
	}

	@Override
	public GrantedAuthority getBy(String authority) {
		GrantedAuthority foundAuthority = null;
		try {
			foundAuthority = em
					.createQuery("SELECT a FROM Authority a WHERE a.authority = :authority ", GrantedAuthority.class)
					.setParameter("authority", authority).getSingleResult();
		} catch (NoResultException ex) {
			return foundAuthority;
		}
		return foundAuthority;
	}

}
