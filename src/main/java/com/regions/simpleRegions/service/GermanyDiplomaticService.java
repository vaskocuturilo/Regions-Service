package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GermanyDiplomaticEntity;
import com.regions.simpleRegions.entity.GermanyEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GermanyDiplomaticModel;
import com.regions.simpleRegions.model.GermanyModel;
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
    @Value("${notification.message}")
    private String regionNotFound;

    public GermanyDiplomaticModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<GermanyDiplomaticEntity> germanRegion = germanyDiplomaticRepo.findByRegion(region);
        if (!germanRegion.isPresent()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return GermanyDiplomaticModel.toModelRegion(germanRegion);
    }

    public List<GermanyDiplomaticModel> getRegionByDescription(final String region) throws RegionNotFoundException {
        List<GermanyDiplomaticEntity> germanRegion = germanyDiplomaticRepo.findByDescription(region);

        if (germanRegion.isEmpty()) {
            throw new RegionNotFoundException(regionNotFound);
        }

        return germanRegion.stream().map(GermanyDiplomaticModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<GermanyDiplomaticEntity> getAllRegions() {
        return germanyDiplomaticRepo.findAll();
    }
}
