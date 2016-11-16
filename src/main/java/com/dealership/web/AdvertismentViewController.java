package com.dealership.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dealership.web.form.AdvertisementForm;
import com.dealership.web.service.AdvertisementService;
import com.dealership.web.util.SearchCriteria;

@RequestMapping("/view")
public class AdvertismentViewController {

	private AdvertisementService advertisementService;
	
	@Autowired
	public AdvertismentViewController(AdvertisementService viewService) {
		this.advertisementService = viewService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String viewAllAds(Model model) {
		model.addAttribute(advertisementService.getAllAdvertisements());
		return "viewAll";
	}

	@RequestMapping(value = "/{advertisementId}", method = RequestMethod.GET)
	public String viewSingleAd(@PathVariable Long advertisementId, Model model) {
		AdvertisementForm ad = advertisementService.getBy(advertisementId);
		model.addAttribute(ad);
		return "viewSingleAd";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearchView(final Model model) {
		model.addAttribute(new SearchCriteria());
		List<Integer> possibleYears = initializePossibleYears();
		model.addAttribute("possibleYears", possibleYears);
		return "search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String processSearch(final Model model, final SearchCriteria searchCriteria) {
		model.addAttribute(advertisementService.seacrhBy(searchCriteria));
		return "viewAll";
	}

	private List<Integer> initializePossibleYears() {
		List<Integer> possibleYears = new ArrayList<>();
		for ( int i = 1970; i < LocalDateTime.now().getYear(); i++ ) {
			possibleYears.add(i);
		}
		return possibleYears;
	}
}
