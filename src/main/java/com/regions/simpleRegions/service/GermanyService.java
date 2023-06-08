package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GermanyEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GermanyModel;
import com.regions.simpleRegions.respository.GermanyRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class GermanyService {

    private final GermanyRepo germanyRepo;
    @Value("${notification.message}")
    private String regionNotFound;

    public GermanyModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<GermanyEntity> germanRegion = germanyRepo.findByRegion(region);
        if (!germanRegion.isPresent()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return GermanyModel.toModelRegion(germanRegion);
    }

    public List<GermanyModel> getRegionByDescription(final String region) throws RegionNotFoundException {
        List<GermanyEntity> germanRegion = germanyRepo.findByDescription(region);

        if (germanRegion.isEmpty()) {
            throw new RegionNotFoundException(regionNotFound);
        }

        return germanRegion.stream().map(GermanyModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<GermanyEntity> getAllRegions() {
        return germanyRepo.findAll();
    }
}
