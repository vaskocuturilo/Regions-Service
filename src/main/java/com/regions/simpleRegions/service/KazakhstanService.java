package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.KazakhstanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.KazakhstanModel;
import com.regions.simpleRegions.respository.KazakhstanRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class KazakhstanService {
    private final KazakhstanRepo kazakhstanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KazakhstanModel getPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<KazakhstanEntity> kazakhstanRegion = kazakhstanRepo.findByRegion(region);

        kazakhstanRegion.stream().filter(kazakhstanEntity -> kazakhstanEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });

        return KazakhstanModel.toModelRegion(kazakhstanRegion);
    }

    public List<KazakhstanModel> getPlatesByDescription(final String description) throws RegionNotFoundException {
        List<KazakhstanEntity> kazakhstanEntityList = kazakhstanRepo.findByDescription(description);
        kazakhstanEntityList.stream().findAny().map(kazakhstanEntity -> kazakhstanEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });
        return kazakhstanEntityList.stream().map(KazakhstanModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<KazakhstanEntity> getAllRegions() {
        return kazakhstanRepo.findAll();
    }
}
