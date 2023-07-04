package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.AustriaDiplomaticEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.AustriaDiplomaticModel;
import com.regions.simpleregions.respository.AustriaDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class AustriaDiplomaticService {
    private final AustriaDiplomaticRepo austriaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public AustriaDiplomaticModel getAustriaPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<AustriaDiplomaticEntity> austriaRegion = austriaDiplomaticRepo.findByRegion(region);
        austriaRegion.stream().filter(austriaDiplomaticEntity -> austriaDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return AustriaDiplomaticModel.toModelRegion(austriaRegion);
    }

    public List<AustriaDiplomaticModel> getAustriaPlatesByDescription(final String description) throws RegionNotFoundException {
        List<AustriaDiplomaticEntity> austriaDiplomaticEntityList = austriaDiplomaticRepo.findByDescription(description);

        austriaDiplomaticEntityList.stream().findAny().map(austriaDiplomaticEntity -> austriaDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(description))
                .orElseThrow(() -> new RegionNotFoundException(String.format(descriptionNotFound, description)));

        return austriaDiplomaticEntityList.stream().map(AustriaDiplomaticModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AustriaDiplomaticEntity> getAllRegions() {
        return austriaDiplomaticRepo.findAll();
    }
}
