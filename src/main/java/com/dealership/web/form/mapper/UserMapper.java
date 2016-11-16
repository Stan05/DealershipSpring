package com.dealership.web.form.mapper;

import org.springframework.stereotype.Component;

import com.dealership.model.SellerContact;
import com.dealership.security.User;
import com.dealership.web.form.UserForm;
@Component
public class UserMapper implements Mapper<UserForm, User> {
    
    /**
     * Map from {@link User} to {@link UserForm}
     * 
     * @param user
     *            to be converted
     * @return the converted user form
     */
    @Override
    public UserForm mapForm(User user) {
        UserForm form = new UserForm();

        form.setId(user.getId());
        form.setUsername(user.getUsername());
        form.setPassword(user.getPassword());
        form.setName(user.getUserContact().getName());
        form.setPhoneNumber(user.getUserContact().getPhoneNumber());
        form.setEmail(user.getUserContact().getEmail());
        form.setCity(user.getUserContact().getCity());

        return form;
    }

    /**
     * Map from {@link UserForm} to {@link User}
     *
     * @param form
     *            the user form to be converted
     * @return the converted user
     */
    @Override
    public User mapModel(UserForm form) {
        User user = new User();
        SellerContact sellerContact = new SellerContact();

        sellerContact.setName(form.getName());
        sellerContact.setCity(form.getCity());
        sellerContact.setEmail(form.getEmail());
        sellerContact.setPhoneNumber(form.getPhoneNumber());

        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setUserContact(sellerContact);

        return user;
    }

}
