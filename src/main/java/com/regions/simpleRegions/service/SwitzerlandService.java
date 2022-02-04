package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.SwitzerlandEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.SwitzerlandModel;
import com.regions.simpleRegions.respository.SwitzerlandRepo;
import org.springframework.stereotype.Service;

@Service
public class SwitzerlandService {

    SwitzerlandRepo switzerlandRepo;

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
}
