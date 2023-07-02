package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.CzechEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.CzechModel;
import com.regions.simpleregions.respository.CzechRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class CzechService {

    private final CzechRepo czechRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public CzechModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<CzechEntity> czechRegion = czechRepo.findByRegion(region);
        czechRegion.stream().filter(czechEntity -> czechEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return CzechModel.toModelRegion(czechRegion);
    }

    public List<CzechModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<CzechEntity> czechEntityList = czechRepo.findByDescription(description);

        czechEntityList.stream().findAny().map(czechEntity -> czechEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });
        return czechEntityList.stream().map(CzechModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<CzechEntity> getAllRegions() {
        return czechRepo.findAll();
    }
}
