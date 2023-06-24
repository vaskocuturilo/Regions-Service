package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.FranceEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.FranceModel;
import com.regions.simpleRegions.respository.FranceRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class FranceService {

    private final FranceRepo franceRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public FranceModel getByRegion(final String region) throws RegionNotFoundException {
        Optional<FranceEntity> franceRegion = franceRepo.findByRegion(region);
        franceRegion.stream().filter(franceEntity -> franceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return FranceModel.toModel(franceRegion);
    }

    public List<FranceModel> getByDescription(final String description) throws RegionNotFoundException {
        List<FranceEntity> franceEntityList = franceRepo.findByDescription(description);

        franceEntityList.stream().findAny().map(franceEntity -> franceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return franceEntityList.stream().map(FranceModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<FranceEntity> getAllRegions() {
        return franceRepo.findAll();
    }
}
