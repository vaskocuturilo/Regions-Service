package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.KazakhstanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.KazakhstanModel;
import com.regions.simpleregions.respository.KazakhstanRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class KazakhstanService {
    private final KazakhstanRepo kazakhstanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KazakhstanModel getPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getPlatesByRegion");
        Optional<KazakhstanEntity> kazakhstanRegion = kazakhstanRepo.findByRegion(region);

        kazakhstanRegion.stream().parallel().filter(kazakhstanEntity -> kazakhstanEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return KazakhstanModel.toModelRegion(kazakhstanRegion);
    }

    public List<KazakhstanModel> getPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getPlatesByDescription");
        List<KazakhstanEntity> kazakhstanEntityList = kazakhstanRepo.findByDescription(description);
        kazakhstanEntityList.stream().parallel().findAny().map(kazakhstanEntity -> kazakhstanEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return kazakhstanEntityList.stream().map(KazakhstanModel::toModelDescription).toList();
    }

    public Iterable<KazakhstanEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return kazakhstanRepo.findAll();
    }
}
