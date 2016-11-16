package com.dealership.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.model.Advertisement;
import com.dealership.model.AdvertisementRepository;
import com.dealership.web.form.AdvertisementForm;
import com.dealership.web.form.mapper.Mapper;
import com.dealership.web.service.AdvertisementService;
import com.dealership.web.util.SearchCriteria;

/**
 * Implements {@link AdvertisementService}. Encapsulates
 * {@link AdvertisementRepository} and supply it with appropriate information
 * received from the web layer.
 * 
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    private Mapper<AdvertisementForm, Advertisement> advertisementMapper;

    /**
     * Instantiates a new advertisement service.
     *
     * @param advertisementRepository
     *            the advertisement repository
     */
    @Autowired
    public AdvertisementServiceImpl(final AdvertisementRepository advertisementRepository,
            final Mapper<AdvertisementForm, Advertisement> advertisementMapper) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementMapper = advertisementMapper;
    }

    @Override
    public List<AdvertisementForm> getAllAdvertisements() {
        return advertisementRepository.getAll().stream()
                .map(advertisement -> advertisementMapper.mapForm(advertisement)).collect(Collectors.toList());
    }

    @Override
    public AdvertisementForm getBy(final Long id) {
        AdvertisementForm advertisementForm = advertisementMapper.mapForm(advertisementRepository.getBy(id));
        return advertisementForm;
    }

    @Override
    public List<AdvertisementForm> seacrhBy(final SearchCriteria searchCriteria) {
        List<Advertisement> advertisements = advertisementRepository.searchByYears(searchCriteria.getFromYear(),
                searchCriteria.getToYear());

        return advertisements.stream().map(advertisement -> advertisementMapper.mapForm(advertisement))
                .collect(Collectors.toList());
    }

    @Override
    public AdvertisementForm add(final AdvertisementForm advertisementForm) {
        Advertisement advertisement = advertisementRepository.add(advertisementMapper.mapModel(advertisementForm));
        return advertisementMapper.mapForm(advertisement);
    }

    @Override
    public boolean delete(final Long id) {
        return advertisementRepository.delete(id);
    }

}
