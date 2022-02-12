package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.FranceEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.FranceModel;
import com.regions.simpleRegions.respository.FranceRepo;
import org.springframework.stereotype.Service;

@Service
public class FranceService {

    FranceRepo franceRepo;

    public FranceService(FranceRepo franceRepo) {
        this.franceRepo = franceRepo;
    }

    public FranceModel getOne(String region) throws RegionNotFoundException {
        FranceEntity franceRegion = franceRepo.findByRegion(region);
        if (franceRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return FranceModel.toModel(franceRegion);
    }

    public Iterable<FranceEntity> getAllRegions() {
        return franceRepo.findAll();
    }
}
