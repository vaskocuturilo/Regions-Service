package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwedenEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwedenModel;
import com.regions.simpleregions.respository.SwedenRepo;
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

    public Iterable<SwedenEntity> getAllRegions() {
        return swedenRepo.findAll();
    }
}
