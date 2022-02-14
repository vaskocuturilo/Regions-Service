package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.ArmeniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.ArmeniaModel;
import com.regions.simpleRegions.respository.ArmeniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArmeniaService {
    ArmeniaRepo armeniaRepo;

    @Autowired
    public ArmeniaService(ArmeniaRepo armeniaRepo) {
        this.armeniaRepo = armeniaRepo;
    }

    public ArmeniaModel getOne(String region) throws RegionNotFoundException {
        ArmeniaEntity armeniaRegion = armeniaRepo.findByRegion(region);
        if (armeniaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return ArmeniaModel.toModel(armeniaRegion);
    }
}
