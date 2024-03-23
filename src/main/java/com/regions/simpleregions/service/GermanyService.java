package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.GermanyEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.GermanyModel;
import com.regions.simpleregions.respository.GermanyRepo;
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
public class GermanyService {

    private final GermanyRepo germanyRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "germany_region", key = "#region")
    public List<GermanyModel> getGermanPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getGermanPlatesByRegion");
        List<GermanyEntity> germanRegions = germanyRepo.findByRegion(region);

        Optional.ofNullable(germanRegions.stream().parallel().filter(germanyEntity -> germanyEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return germanRegions.stream().map(GermanyModel::toModelRegion).toList();
    }

    @Cacheable(value = "germany_description", key = "#description")
    public List<GermanyModel> getGermanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getGermanPlatesByDescription");
        List<GermanyEntity> germanyEntityList = germanyRepo.findByDescription(description);

        germanyEntityList.stream().parallel().findAny().map(germanyEntity -> germanyEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return germanyEntityList.stream().map(GermanyModel::toModelDescription).toList();
    }

    public Iterable<GermanyEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return germanyRepo.findAll();
    }
}
