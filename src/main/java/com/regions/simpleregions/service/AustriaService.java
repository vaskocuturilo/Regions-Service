package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.AustriaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.AustriaModel;
import com.regions.simpleregions.respository.AustriaRepository;
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
public class AustriaService {
    private final AustriaRepository austriaRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "austria_region", key = "#region")
    public AustriaModel getAustriaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getAustriaPlatesByRegion");

        Optional<AustriaEntity> austriaRegion = austriaRepository.findByRegion(region);

        Optional.ofNullable(austriaRegion.stream().parallel().filter(austriaEntity -> austriaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return AustriaModel.toModelRegion(austriaRegion);
    }

    @Cacheable(value = "austria_description", key = "#description")
    public List<AustriaModel> getAustriaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getAustriaPlatesByDescription");
        List<AustriaEntity> austriaEntityList = austriaRepository.findByDescription(description);

        austriaEntityList.stream().parallel().findAny().map(austriaEntity -> austriaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(
                () -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return austriaEntityList.stream().map(AustriaModel::toModelDescription).toList();
    }

    public Iterable<AustriaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return austriaRepository.findAll();
    }
}
