package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwitzerlandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwitzerlandDiplomaticModel;
import com.regions.simpleregions.respository.SwitzerlandDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class SwitzerlandDiplomaticService {

    private final SwitzerlandDiplomaticRepo switzerlandDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SwitzerlandDiplomaticModel getSwitzerlandDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<SwitzerlandDiplomaticEntity> switzerlandRegion = switzerlandDiplomaticRepo.findByRegion(region);
        Optional.ofNullable(
                switzerlandRegion
                        .stream()
                        .filter(switzerlandEntity -> switzerlandEntity.getRegion().equalsIgnoreCase(region))
                        .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwitzerlandDiplomaticModel.toModelByRegion(switzerlandRegion);
    }

    public List<SwitzerlandDiplomaticModel> getSwitzerlandDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<SwitzerlandDiplomaticEntity> switzerlandEntityList = switzerlandDiplomaticRepo.findByDescription(description);

        switzerlandEntityList
                .stream()
                .map(switzerlandEntity -> switzerlandEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return switzerlandEntityList.stream().map(SwitzerlandDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SwitzerlandDiplomaticEntity> getAllSwitzerlandDiplomaticRegions() {
        return switzerlandDiplomaticRepo.findAll();
    }
}
