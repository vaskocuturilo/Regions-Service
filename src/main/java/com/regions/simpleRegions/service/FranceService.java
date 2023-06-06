package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.FranceEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.FranceModel;
import com.regions.simpleRegions.respository.FranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FranceService {

    FranceRepo franceRepo;

    @Autowired
    public FranceService(FranceRepo franceRepo) {
        this.franceRepo = franceRepo;
    }

    public FranceModel getByRegion(String region) throws RegionNotFoundException {
        FranceEntity franceRegion = franceRepo.findByRegion(region);
        if (franceRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return FranceModel.toModel(franceRegion);
    }

    public List<FranceModel> getByDescription(String description) throws RegionNotFoundException {
        List<FranceModel> userModel = new ArrayList<>();
        List<FranceEntity> franceEntities = franceRepo.findByDescription(description);
        if (franceEntities.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        for (FranceEntity franceEntity : franceEntities) {
            userModel.add(FranceModel.toModelDescription(franceEntity));
        }
        return userModel;
    }

    public Iterable<FranceEntity> getAllRegions() {
        return franceRepo.findAll();
    }
}
