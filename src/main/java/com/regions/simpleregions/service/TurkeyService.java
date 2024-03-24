package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.TurkeyEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.TurkeyModel;
import com.regions.simpleregions.respository.TurkeyRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class TurkeyService {

    private final TurkeyRepository turkeyRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "turkey_region", key = "#region")
    public TurkeyModel getTurkeyPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getTurkeyPlatesByRegion");
        Optional<TurkeyEntity> turkeyRegion = turkeyRepository.findByRegion(region);

        Optional.ofNullable(turkeyRegion.stream().parallel().filter(turkeyEntity -> turkeyEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return TurkeyModel.toModelByRegion(turkeyRegion);
    }

    @Cacheable(value = "turkey_description", key = "#description")
    public List<TurkeyModel> getTurkeyPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getTurkeyPlatesByDescription");
        List<TurkeyEntity> turkeyEntityList = turkeyRepository.findByDescription(description);

        turkeyEntityList.stream().parallel().findAny().map(turkeyEntity -> turkeyEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return turkeyEntityList.stream().map(TurkeyModel::toModelByDescription).toList();
    }

    public Iterable<TurkeyEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return turkeyRepository.findAll();
    }
}
