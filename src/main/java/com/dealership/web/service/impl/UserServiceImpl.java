package com.dealership.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.dealership.security.AuthorityRepository;
import com.dealership.security.User;
import com.dealership.security.UserRepository;
import com.dealership.web.form.UserForm;
import com.dealership.web.form.mapper.Mapper;
import com.dealership.web.service.UserService;

/**
 * Implements {@link UserService}. Encapsulates {@link UserRepository} and
 * {@link AuthorityRepository} and supply them with appropriate information
 * received from the web layer.
 * 
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private Mapper<UserForm, User> userMapper;

   

    /**
     * Instantiates a new user service impl.
     *
     * @param userRepository
     *            the user repository
     * @param authorityRepository
     *            the authority repository
     */
    @Autowired
    public UserServiceImpl(final UserRepository userRepository, 
            final AuthorityRepository authorityRepository,
            final Mapper<UserForm, User> userMapper) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserForm createUser(UserForm userForm) {
        User user = userMapper.mapModel(userForm);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authorityRepository.getBy("ROLE_USER"));
        user.setAuthorities(authorities);

        return userMapper.mapForm(userRepository.add(user));
    }

    @Override
    public UserForm findBy(String username) {
        User user = userRepository.getUser(username);
        return user == null ? null : userMapper.mapForm(user);
    }

}
