package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GreeceEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GreeceModel;
import com.regions.simpleRegions.respository.GreeceRepo;
import org.springframework.stereotype.Service;

@Service
public class GreeceService {

    GreeceRepo greeceRepo;

    public GreeceService(GreeceRepo greeceRepo) {
        this.greeceRepo = greeceRepo;
    }

    public GreeceModel getOne(String region) throws RegionNotFoundException {
        GreeceEntity greeceRegion = greeceRepo.findByRegion(region);
        if (greeceRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return GreeceModel.toModel(greeceRegion);
    }
}
