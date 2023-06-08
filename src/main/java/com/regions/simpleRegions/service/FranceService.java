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
    @Value("${notification.message}")
    private String regionNotFound;

    public FranceModel getByRegion(final String region) throws RegionNotFoundException {
        Optional<FranceEntity> franceRegion = franceRepo.findByRegion(region);
        if (!franceRegion.isPresent()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return FranceModel.toModel(franceRegion);
    }

    public List<FranceModel> getByDescription(final String description) throws RegionNotFoundException {
        List<FranceEntity> franceEntities = franceRepo.findByDescription(description);
        if (franceEntities.isEmpty()) {
            throw new RegionNotFoundException(regionNotFound);
        }

        return franceEntities.stream().map(FranceModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<FranceEntity> getAllRegions() {
        return franceRepo.findAll();
    }
}
