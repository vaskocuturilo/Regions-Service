package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.NorthMacedoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.NorthMacedoniaModel;
import com.regions.simpleregions.respository.NorthMacedoniaRepo;
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
public class NorthMacedoniaService {

    private final NorthMacedoniaRepo northMacedoniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "armenia_region", key = "#region")
    public NorthMacedoniaModel getNorthMacedoniaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getArmeniaPlatesByRegion");
        Optional<NorthMacedoniaEntity> armeniaRegion = northMacedoniaRepo.findByRegion(region);

        Optional.ofNullable(armeniaRegion.stream().parallel().filter(armeniaEntity -> armeniaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return NorthMacedoniaModel.toModelRegion(armeniaRegion);
    }

    @Cacheable(value = "armenia_description", key = "#description")
    public List<NorthMacedoniaModel> getNorthMacedoniaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getArmeniaPlatesByDescription");
        List<NorthMacedoniaEntity> armeniaEntityList = northMacedoniaRepo.findByDescription(description);
        armeniaEntityList.stream().parallel().findAny().map(armeniaEntity -> armeniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return armeniaEntityList.stream().map(NorthMacedoniaModel::toModelDescription).toList();
    }

    public Iterable<NorthMacedoniaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return northMacedoniaRepo.findAll();
    }
}
