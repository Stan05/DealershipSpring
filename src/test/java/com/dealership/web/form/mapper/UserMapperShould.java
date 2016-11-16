package com.dealership.web.form.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dealership.model.SellerContact;
import com.dealership.security.User;
import com.dealership.web.form.UserForm;

public class UserMapperShould {

    private static Mapper<UserForm, User> userMapper;
    private static UserForm userForm;
    private static User user;

    @BeforeClass
    public static void setUp() {
        userMapper = new UserMapper();
        user = initializeUser();
        userForm = convertToFormObject();
    }

    @Test
    public void createObject() {
        assertNotNull("The user mapper is not creating.", userMapper);
    }

    @Test
    public void convertFormToNotNullModelObject() {
        User expecectNotNullUser = userMapper.mapModel(userForm);

        assertNotNull("The map from UserForm to User return null.", expecectNotNullUser);
    }

    @Test
    public void convertFormToModelObject() {
        User actual = user;
        User expected = userMapper.mapModel(userForm);

        /*
         * Set the id of the 'expected' because as it is converted from form
         * object it assumes that this object is not persisted and don't have an
         * id.
         */
        expected.setId(user.getId());

        assertEquals("The user mapper is not converting form to model.", expected, actual);
    }

    @Test
    public void convertModelToNotNullFormObject() {
        UserForm expectedNotNullUserForm = userMapper.mapForm(user);

        assertNotNull("The map from User to UserForm return null.", expectedNotNullUserForm);
    }

    @Test
    public void convertModetToFormObject() {
        UserForm actual = userForm;
        UserForm expected = userMapper.mapForm(user);

        assertEquals("The user mapper is not converting model to form.", expected, actual);
    }

    private static UserForm convertToFormObject() {
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

    private static User initializeUser() {
        User user = new User("test", "test", new ArrayList<>());
        SellerContact sellerContact = new SellerContact("SPRING", "0898762116", "spring@abv.bg", "spring");
        user.setId(15L);
        user.setUserContact(sellerContact);
        return user;
    }

}
