package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GreeceEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GreeceModel;
import com.regions.simpleRegions.respository.GreeceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreeceService {

    @Autowired
    GreeceRepo greeceRepo;

    public GreeceModel getOne(String region) throws RegionNotFoundException {
        GreeceEntity greeceRegion = greeceRepo.findByRegion(region);
        if (greeceRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return GreeceModel.toModel(greeceRegion);
    }
}
