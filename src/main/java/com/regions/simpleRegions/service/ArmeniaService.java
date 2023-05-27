package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.ArmeniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.ArmeniaModel;
import com.regions.simpleRegions.respository.ArmeniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmeniaService {
    ArmeniaRepo armeniaRepo;

    @Autowired
    public ArmeniaService(ArmeniaRepo armeniaRepo) {
        this.armeniaRepo = armeniaRepo;
    }

    public ArmeniaModel getRegionNumber(String region) throws RegionNotFoundException {
        ArmeniaEntity armeniaRegion = armeniaRepo.findByRegion(region);
        if (armeniaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return ArmeniaModel.toModel(armeniaRegion);
    }

    public List<ArmeniaModel> getDescription(String description) throws RegionNotFoundException {
        List<ArmeniaModel> userModel = new ArrayList<>();
        List<ArmeniaEntity> armeniaRegion = armeniaRepo.findByDescription(description);
        if (armeniaRegion.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        for (ArmeniaEntity armeniaEntity : armeniaRegion) {
            userModel.add(ArmeniaModel.toModelDescription(armeniaEntity));
        }
        return userModel;
    }

    public Iterable<ArmeniaEntity> getAllRegions() {
        return armeniaRepo.findAll();
    }
}
