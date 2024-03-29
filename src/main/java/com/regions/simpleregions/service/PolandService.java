package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.PolandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.PolandModel;
import com.regions.simpleregions.respository.PolandRepository;
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
public class PolandService {

    private final PolandRepository polandRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "poland_region", key = "#region")
    public PolandModel getPolandPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getPolandPlatesByRegion");
        Optional<PolandEntity> polandRegion = polandRepository.findByRegion(region);

        Optional.ofNullable(polandRegion.stream().parallel().filter(polandEntity -> polandEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return PolandModel.toModel(polandRegion);
    }

    @Cacheable(value = "poland_description", key = "#description")
    public List<PolandModel> getPolandPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getPolandPlatesByDescription");
        List<PolandEntity> polandEntityList = polandRepository.findByDescription(description);
        polandEntityList.stream().parallel().findAny().map(polandEntity -> polandEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return polandEntityList.stream().map(PolandModel::toDescription).toList();
    }

    public Iterable<PolandEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return polandRepository.findAll();
    }
}
