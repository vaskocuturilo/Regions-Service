package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ArmeniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.ArmeniaModel;
import com.regions.simpleregions.respository.ArmeniaRepo;
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
public class ArmeniaService {

    private final ArmeniaRepo armeniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "armenia_region", key = "#region")
    public ArmeniaModel getArmeniaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getArmeniaPlatesByRegion");
        Optional<ArmeniaEntity> armeniaRegion = armeniaRepo.findByRegion(region);

        Optional.ofNullable(armeniaRegion.stream().parallel().filter(armeniaEntity -> armeniaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return ArmeniaModel.toModelRegion(armeniaRegion);
    }

    @Cacheable(value = "armenia_description", key = "#description")
    public List<ArmeniaModel> getArmeniaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getArmeniaPlatesByDescription");
        List<ArmeniaEntity> armeniaEntityList = armeniaRepo.findByDescription(description);
        armeniaEntityList.stream().parallel().findAny().map(armeniaEntity -> armeniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return armeniaEntityList.stream().map(ArmeniaModel::toModelDescription).toList();
    }

    public Iterable<ArmeniaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return armeniaRepo.findAll();
    }
}
