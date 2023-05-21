package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GermanyEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GermanModel;
import com.regions.simpleRegions.respository.GermanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GermanyService {

    GermanyRepo germanyRepo;

    @Autowired
    public GermanyService(GermanyRepo germanyRepo) {
        this.germanyRepo = germanyRepo;
    }

    public GermanModel getOne(String region) throws RegionNotFoundException {
        GermanyEntity germanRegion = germanyRepo.findByRegion(region);
        if (germanRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return GermanModel.toModel(germanRegion);
    }

    public Iterable<GermanyEntity> getAllRegions() {
        return germanyRepo.findAll();
    }
}
