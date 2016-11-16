package com.dealership.web.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dealership.security.UserRepository;

/**
 * Implements {@link UserDetailsService}, in order to be used by spring security
 * for logging users. Encapsulates {@link UserRepository}.
 * 
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	/**
	 * Instantiates a new user details service.
	 *
	 * @param userRepository
	 *                the user repository
	 */
	public UserDetailsServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.getUser(username);
	}

}
