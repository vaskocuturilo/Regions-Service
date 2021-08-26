package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GermanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GermanModel;
import com.regions.simpleRegions.respository.GermanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GermanService {

    @Autowired
    GermanRepo germanRepo;

    public GermanModel getOne(String region) throws RegionNotFoundException {
        GermanEntity germanRegion = germanRepo.findByRegion(region);
        if (germanRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return GermanModel.toModel(germanRegion);
    }
}
