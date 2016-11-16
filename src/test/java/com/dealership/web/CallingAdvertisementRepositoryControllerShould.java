package com.dealership.web;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dealership.web.service.AdvertisementService;

public class CallingAdvertisementRepositoryControllerShould extends SpringMVCConfigForTests {

	private static final Long ADVERTISEMENT_ID = 15L;

	private static AdvertisementService service;
	private static AdvertisementRepositoryController controller;
	private static MockMvc mockMvc;

	@BeforeClass
	public static void setUp() {
		service = Mockito.mock(AdvertisementService.class);
		controller = new AdvertisementRepositoryController(service);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void showAddView() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/add"))
		                .andExpect(MockMvcResultMatchers.view().name("addAdvertisement"));
	}

	@Test
	public void hasAttributeAdvertisementForm() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/add"))
		                .andExpect(MockMvcResultMatchers.model().attributeExists("advertisementForm"));
	}

	@Test
	public void deleteAdvertisement() throws Exception {
		Mockito.when(service.delete(Mockito.anyLong())).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.get("/advertisement/delete/" + ADVERTISEMENT_ID.toString()))
		                .andExpect(MockMvcResultMatchers.redirectedUrl("/view/all"));
		Mockito.verify(service, Mockito.only()).delete(ADVERTISEMENT_ID);

	}

}
