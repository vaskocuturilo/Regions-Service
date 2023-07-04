package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.AzerbaijanEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.AzerbaijanModel;
import com.regions.simpleregions.respository.AzerbaijanRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class AzerbaijanService {

    private final AzerbaijanRepo azerbaijanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public AzerbaijanModel getAzerbaijanPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<AzerbaijanEntity> azerbaijanRegion = azerbaijanRepo.findByRegion(region);
        azerbaijanRegion.stream().filter(azerbaijanEntity -> azerbaijanEntity
                        .getRegion()
                        .equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return AzerbaijanModel.toModel(azerbaijanRegion);
    }

    public List<AzerbaijanModel> getAzerbaijanPlatesByDescription(final String description) throws RegionNotFoundException {
        List<AzerbaijanEntity> azerbaijanEntities = azerbaijanRepo.findByDescription(description);

        azerbaijanEntities.stream().findAny().map(azerbaijanEntity -> azerbaijanEntity
                .getDescription()
                .equalsIgnoreCase(description)).orElseThrow(() -> new RegionNotFoundException(String.format(descriptionNotFound, description)));

        return azerbaijanEntities.stream().map(AzerbaijanModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AzerbaijanEntity> getAllRegions() {
        return azerbaijanRepo.findAll();
    }
}
