package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AzerbaijanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AzerbaijanModel;
import com.regions.simpleRegions.respository.AzerbaijanRepo;
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

    public AzerbaijanModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<AzerbaijanEntity> azerbaijanRegion = azerbaijanRepo.findByRegion(region);
        azerbaijanRegion.stream().filter(azerbaijanEntity -> azerbaijanEntity
                        .getRegion()
                        .equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> {
                    RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

                    return regionNotFoundException;
                });
        return AzerbaijanModel.toModel(azerbaijanRegion);
    }

    public List<AzerbaijanModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<AzerbaijanEntity> azerbaijanEntities = azerbaijanRepo.findByDescription(description);

        azerbaijanEntities.stream().findAny().map(azerbaijanEntity -> azerbaijanEntity
                .getDescription()
                .equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;

        });
        return azerbaijanEntities.stream().map(AzerbaijanModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AzerbaijanEntity> getAllRegions() {
        return azerbaijanRepo.findAll();
    }
}
