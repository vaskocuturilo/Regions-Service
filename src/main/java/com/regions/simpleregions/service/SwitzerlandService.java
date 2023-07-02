package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwitzerlandModel;
import com.regions.simpleregions.respository.SwitzerlandRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class SwitzerlandService {

    private final SwitzerlandRepo switzerlandRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SwitzerlandModel getSwitzerlandPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<SwitzerlandEntity> switzerlandRegion = switzerlandRepo.findByRegion(region);
        Optional.ofNullable(
                switzerlandRegion
                        .stream()
                        .filter(switzerlandEntity -> switzerlandEntity.getRegion().equalsIgnoreCase(region))
                        .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwitzerlandModel.toModelByRegion(switzerlandRegion);
    }

    public List<SwitzerlandModel> getSwitzerlandPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<SwitzerlandEntity> switzerlandEntityList = switzerlandRepo.findByDescription(description);

        switzerlandEntityList
                .stream()
                .map(switzerlandEntity -> switzerlandEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return switzerlandEntityList.stream().map(SwitzerlandModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SwitzerlandEntity> getAllRegions() {
        return switzerlandRepo.findAll();
    }
}
