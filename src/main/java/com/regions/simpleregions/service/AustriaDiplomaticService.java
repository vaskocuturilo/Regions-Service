package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.AustriaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.AustriaDiplomaticModel;
import com.regions.simpleregions.respository.AustriaDiplomaticRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Data
@Service
public class AustriaDiplomaticService {
    private final AustriaDiplomaticRepo austriaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public AustriaDiplomaticModel getAustriaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getAustriaPlatesByRegion");
        Optional<AustriaDiplomaticEntity> austriaRegion = austriaDiplomaticRepo.findByRegion(region);
        austriaRegion.stream().filter(austriaDiplomaticEntity -> austriaDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return AustriaDiplomaticModel.toModelRegion(austriaRegion);
    }

    public List<AustriaDiplomaticModel> getAustriaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getAustriaPlatesByDescription");
        List<AustriaDiplomaticEntity> austriaDiplomaticEntityList = austriaDiplomaticRepo.findByDescription(description);

        austriaDiplomaticEntityList.stream().findAny().map(austriaDiplomaticEntity -> austriaDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(description))
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return austriaDiplomaticEntityList.stream().map(AustriaDiplomaticModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AustriaDiplomaticEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return austriaDiplomaticRepo.findAll();
    }
}