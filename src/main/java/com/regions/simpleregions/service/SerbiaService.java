package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SerbiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SerbiaModel;
import com.regions.simpleregions.respository.SerbiaRepository;
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
public class SerbiaService {

    private final SerbiaRepository serbiaRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "serbia_region", key = "#region")
    public SerbiaModel getSerbiaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getArmeniaPlatesByRegion");
        Optional<SerbiaEntity> serbiaRegion = serbiaRepository.findByRegion(region);

        Optional.ofNullable(serbiaRegion.stream().parallel().filter(serbiaEntity -> serbiaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return SerbiaModel.toModelRegion(serbiaRegion);
    }

    @Cacheable(value = "serbia_description", key = "#description")
    public List<SerbiaModel> getSerbiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getArmeniaPlatesByDescription");
        List<SerbiaEntity> serbiaEntityList = serbiaRepository.findByDescription(description);
        serbiaEntityList.stream().parallel().findAny().map(serbiaEntity -> serbiaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return serbiaEntityList.stream().map(SerbiaModel::toModelDescription).toList();
    }

    public Iterable<SerbiaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return serbiaRepository.findAll();
    }
}
