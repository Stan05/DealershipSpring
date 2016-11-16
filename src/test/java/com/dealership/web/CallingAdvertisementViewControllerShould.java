package com.dealership.web;

import org.hamcrest.collection.IsIterableContainingInOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dealership.model.Advertisement;
import com.dealership.model.car.Car;
import com.dealership.model.car.TechnicalInformation;
import com.dealership.security.User;
import com.dealership.web.form.AdvertisementForm;
import com.dealership.web.form.mapper.AdvertisementMapper;
import com.dealership.web.service.AdvertisementService;

public class CallingAdvertisementViewControllerShould extends SpringMVCConfigForTests {

	private static AdvertisementService service;
	private static AdvertismentViewController controller;
	private static MockMvc mockMvc;
	private static List<AdvertisementForm> expectedAds;

	@BeforeClass
	public static void setUp() {
		service = Mockito.mock(AdvertisementService.class);
		controller = new AdvertismentViewController(service);
		expectedAds = initializeListOfAds();

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		Mockito.when(service.getAllAdvertisements()).thenReturn(expectedAds);
		Mockito.when(service.getBy((long) 0)).thenReturn(expectedAds.get(0));

	}

	@Test
	public void showProperView() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/view/all"))
		                .andExpect(MockMvcResultMatchers.view().name("viewAll"));
	}

	@Test
	public void hasAttribute() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/view/all"))
		                .andExpect(MockMvcResultMatchers.model().attributeExists("advertisementFormList"));
	}

	@Test
	public void showAllAds() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/view/all"))
		                .andExpect(MockMvcResultMatchers.model().attribute("advertisementFormList",
		                                IsIterableContainingInOrder.contains(expectedAds.toArray())));
	}
	
	@Test
	public void showSingleAdView() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/view/0"))
			.andExpect(MockMvcResultMatchers.view().name("viewSingleAd"));
	}
	
	@Test
	public void showCorrectAdvertisement() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/view/0"))
			.andExpect(MockMvcResultMatchers.model().attribute("advertisementForm", expectedAds.get(0)));
	}

	private static List<AdvertisementForm> initializeListOfAds() {
		User user = new User();
		AdvertisementMapper mapper = new AdvertisementMapper();
		List<Advertisement> list = new ArrayList<>();
		for ( int i = 1; i < 10; i++ ) {
			list.add(new Advertisement((long) i, new Car("","",new TechnicalInformation(1995,"",250000),new ArrayList<>()), user, 2600));
		}
		return list
				.stream()
				.map(advertisement -> mapper.mapForm(advertisement))
				.collect(Collectors.toList());
	}

}
