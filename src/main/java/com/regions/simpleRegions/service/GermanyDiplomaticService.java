package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GermanyDiplomaticEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GermanyDiplomaticModel;
import com.regions.simpleRegions.respository.GermanyDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class GermanyDiplomaticService {

    private final GermanyDiplomaticRepo germanyDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public GermanyDiplomaticModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<GermanyDiplomaticEntity> germanRegion = germanyDiplomaticRepo.findByRegion(region);
        germanRegion.stream().filter(germanyDiplomaticEntity -> germanyDiplomaticEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return GermanyDiplomaticModel.toModelRegion(germanRegion);
    }

    public List<GermanyDiplomaticModel> getRegionByDescription(final String description) throws RegionNotFoundException {
        List<GermanyDiplomaticEntity> germanyDiplomaticEntityList = germanyDiplomaticRepo.findByDescription(description);

        germanyDiplomaticEntityList.stream().findAny().map(germanyDiplomaticEntity -> germanyDiplomaticEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .orElseThrow(() -> {
                    RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

                    return regionNotFoundException;
                });

        return germanyDiplomaticEntityList.stream().map(GermanyDiplomaticModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<GermanyDiplomaticEntity> getAllRegions() {
        return germanyDiplomaticRepo.findAll();
    }
}
