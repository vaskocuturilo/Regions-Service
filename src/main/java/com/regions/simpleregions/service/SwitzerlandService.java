package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwitzerlandModel;
import com.regions.simpleregions.respository.SwitzerlandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwitzerlandService {

    SwitzerlandRepo switzerlandRepo;

    @Autowired
    public SwitzerlandService(SwitzerlandRepo switzerlandRepo) {
        this.switzerlandRepo = switzerlandRepo;
    }

    public SwitzerlandModel getOne(String region) throws RegionNotFoundException {
        SwitzerlandEntity switzerlandRegion = switzerlandRepo.findByRegion(region);
        if (switzerlandRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return SwitzerlandModel.toModel(switzerlandRegion);
    }

    public Iterable<SwitzerlandEntity> getAllRegions() {
        return switzerlandRepo.findAll();
    }
}
