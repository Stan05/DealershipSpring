package com.dealership.web.form.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dealership.model.Advertisement;
import com.dealership.model.car.Car;
import com.dealership.model.car.Features;
import com.dealership.model.car.TechnicalInformation;
import com.dealership.security.User;
import com.dealership.web.form.AdvertisementForm;
import com.dealership.web.form.mapper.AdvertisementMapper;
import com.dealership.web.form.mapper.Mapper;

public class AdvertisementMapperShould {

    private static Mapper<AdvertisementForm, Advertisement> advertisementMapper;
    private static Advertisement advertisement;
    private static AdvertisementForm advertisementForm;

    @BeforeClass
    public static void setUp() {
        advertisementMapper = new AdvertisementMapper();
        advertisement = initializeAdvertisement();
        advertisementForm = advertisementMapper.mapForm(advertisement);

    }

    @Test
    public void createObject() {
        assertNotNull("The advertisement mapper is not creating.", advertisementMapper);
    }

    @Test
    public void convertModelObjectToNotNullForm() {
        assertNotNull("The map from Advertisement to AdvertisementForm return null.", advertisementForm);
    }

    @Test
    public void convertModelObjectToForm() {
        AdvertisementForm actual = convertToFormObject();
        AdvertisementForm expected = advertisementMapper.mapForm(advertisement);
       
        assertEquals("The advertisement form mapper is not converting from model to form object.", expected, actual);
    }

    @Test
    public void convertFormToNotNullModelObject() {
        Advertisement expectNotNullAdvertisement = advertisementMapper.mapModel(advertisementForm);
      
        assertNotNull("The map from AdvertisementForm to Advertisement return null.", expectNotNullAdvertisement);
    }

    @Test
    public void convertFormToModelObject() {
        Advertisement actual = advertisement;
        Advertisement expected = advertisementMapper.mapModel(advertisementForm);
        
        /*
         * Set the id of the 'expected' because as it is converted from form
         * object it assumes that this object is not persisted and don't have an
         * id.
         */
        expected.setId(advertisement.getId());
       
        assertEquals("The advertisement form mapper is not converting from form to model object", expected, actual);
    }

    private AdvertisementForm convertToFormObject() {
        AdvertisementForm advertisementForm = new AdvertisementForm();

        advertisementForm.setId(advertisement.getId());
        advertisementForm.setBrand(advertisement.getCar().getBrand());
        advertisementForm.setModel(advertisement.getCar().getModel());
        advertisementForm.setFirstRegistration(advertisement.getCar().getTechnicalInformation().getFirstRegistration());
        advertisementForm.setFuel(advertisement.getCar().getTechnicalInformation().getFuel());
        advertisementForm.setMileage(advertisement.getCar().getTechnicalInformation().getMileage());
        advertisementForm.setFeatures(advertisement.getCar().getFeatures());
        advertisementForm.setUser(advertisement.getOwner());
        advertisementForm.setPrice(advertisement.getPrice());

        return advertisementForm;
    }

    private static Advertisement initializeAdvertisement() {
        User user = new User("test", "test", new ArrayList<>());
        List<Features> features = new ArrayList<>();
        features.add(Features.ABS);

        return new Advertisement(1L, new Car("Opel", "Corsa", new TechnicalInformation(1995, "Gas", 265000), features),
                user, 2600);
    }
}
