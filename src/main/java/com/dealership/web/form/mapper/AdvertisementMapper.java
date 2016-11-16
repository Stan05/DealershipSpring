package com.dealership.web.form.mapper;

import org.springframework.stereotype.Component;

import com.dealership.model.Advertisement;
import com.dealership.model.car.Car;
import com.dealership.model.car.TechnicalInformation;
import com.dealership.web.form.AdvertisementForm;
@Component
public class AdvertisementMapper implements Mapper<AdvertisementForm, Advertisement> {

	/**
	 * Map from {@link Advertisement} to {@link AdvertisementForm}
	 * 
	 * @param advertisement
	 *            to be converted
	 * @return the converted advertisement form
	 */
	@Override
	public AdvertisementForm mapForm(Advertisement advertisement) {
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

	/**
	 * Map from {@link AdvertisementForm} to {@link Advertisement}
	 *
	 * @param form
	 *            the advertisement form to be converted
	 * @return the converted advertisement
	 */
	@Override
	public Advertisement mapModel(AdvertisementForm advertisementForm) {
		Advertisement advertisement = new Advertisement();
		Car car = new Car();
		TechnicalInformation technicalInformation = new TechnicalInformation();

		technicalInformation.setFirstRegistration(advertisementForm.getFirstRegistration());
		technicalInformation.setMileage(advertisementForm.getMileage());
		technicalInformation.setFuel(advertisementForm.getFuel());

		car.setBrand(advertisementForm.getBrand());
		car.setModel(advertisementForm.getModel());
		car.setTechnicalInformation(technicalInformation);
		car.setFeatures(advertisementForm.getFeatures());
		
		advertisement.setCar(car);
		advertisement.setOwner(advertisementForm.getUser());
		advertisement.setPrice(advertisementForm.getPrice());

		return advertisement;
	}

}
