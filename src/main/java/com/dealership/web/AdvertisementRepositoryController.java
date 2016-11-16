package com.dealership.web;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dealership.model.car.Features;
import com.dealership.security.User;
import com.dealership.web.form.AdvertisementForm;
import com.dealership.web.service.AdvertisementService;
import com.dealership.web.util.UserUtils;

@RequestMapping(value = { "/advertisement" })
public class AdvertisementRepositoryController {

	private AdvertisementService advertisementService;

	@Autowired
	public AdvertisementRepositoryController(AdvertisementService addService) {
		this.advertisementService = addService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddView(Model model) {
		populateModel(model);
		model.addAttribute("advertisementForm", new AdvertisementForm());
		return "addAdvertisement";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(Model model, @Valid AdvertisementForm advertisementForm, BindingResult errors) {
		if ( errors.hasErrors() ) {
			populateModel(model);
			return "addAdvertisement";
		}
		advertisementForm.setUser(UserUtils.getLoggedInUser());
		advertisementService.add(advertisementForm);
		return "redirect:/view/all";
	}
	
	
	@RequestMapping(value = "/delete/{advertisementId}" , method = RequestMethod.GET)
	public String deleteAdvertisement(@PathVariable Long advertisementId) {
		User user = UserUtils.getLoggedInUser();
		
		//TO-DO Make it possible ADMIN to delete advertisement without constraint 
		
		if(user.equals(advertisementService.getBy(advertisementId).getUser()) ){
			advertisementService.delete(advertisementId);
		}
		return "redirect:/view/all";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String showUpdateView(@RequestAttribute AdvertisementForm form){
		return "addAdvertisement";
	}
	
	private void populateModel(Model model) {
		Features[] features = Features.values();
		model.addAttribute("features", features);
		model.addAttribute("beginYear", 1970);
		model.addAttribute("endYear", LocalDateTime.now().getYear());
		model.addAttribute("user", UserUtils.getLoggedInUser());
	}

}
