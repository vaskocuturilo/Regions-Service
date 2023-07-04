package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.GermanyEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.GermanyModel;
import com.regions.simpleregions.respository.GermanyRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class GermanyService {

    private final GermanyRepo germanyRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public GermanyModel getGermanPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<GermanyEntity> germanRegion = germanyRepo.findByRegion(region);
        germanRegion.stream().filter(germanyEntity -> germanyEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return GermanyModel.toModelRegion(germanRegion);
    }

    public List<GermanyModel> getGermanPlatesByDescription(final String description) throws RegionNotFoundException {
        List<GermanyEntity> germanyEntityList = germanyRepo.findByDescription(description);

        germanyEntityList.stream().findAny().map(germanyEntity -> germanyEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new RegionNotFoundException(String.format(descriptionNotFound, description)));

        return germanyEntityList.stream().map(GermanyModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<GermanyEntity> getAllRegions() {
        return germanyRepo.findAll();
    }
}
