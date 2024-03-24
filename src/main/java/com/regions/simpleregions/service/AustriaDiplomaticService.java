package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.AustriaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.AustriaDiplomaticModel;
import com.regions.simpleregions.respository.AustriaDiplomaticRepository;
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
public class AustriaDiplomaticService {
    private final AustriaDiplomaticRepository austriaDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "austria_diplomatic_region", key = "#region")
    public AustriaDiplomaticModel getAustriaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getAustriaPlatesByRegion");
        Optional<AustriaDiplomaticEntity> austriaRegion = austriaDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(austriaRegion.stream().parallel().filter(austriaDiplomaticEntity -> austriaDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return AustriaDiplomaticModel.toModelRegion(austriaRegion);
    }


    @Cacheable(value = "austria_diplomatic_description", key = "#description")
    public List<AustriaDiplomaticModel> getAustriaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getAustriaPlatesByDescription");
        List<AustriaDiplomaticEntity> austriaDiplomaticEntityList = austriaDiplomaticRepository.findByDescription(description);

        austriaDiplomaticEntityList.stream().findAny().map(austriaDiplomaticEntity -> austriaDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(description))
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return austriaDiplomaticEntityList.stream().parallel().map(AustriaDiplomaticModel::toModelDescription).toList();
    }

    public Iterable<AustriaDiplomaticEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return austriaDiplomaticRepository.findAll();
    }
}
