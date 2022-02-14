package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.SwedenEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.SwedenModel;
import com.regions.simpleRegions.respository.SwedenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwedenService {

    SwedenRepo swedenRepo;

    @Autowired
    public SwedenService(SwedenRepo swedenRepo) {
        this.swedenRepo = swedenRepo;
    }

    public SwedenModel getOne(String region) throws RegionNotFoundException {
        SwedenEntity swedenRegion = swedenRepo.findByRegion(region);
        if (swedenRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return SwedenModel.toModel(swedenRegion);
    }
}
