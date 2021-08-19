package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.CzechEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.CzechModel;
import com.regions.simpleRegions.respository.CzechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CzechService {

    @Autowired
    CzechRepo czechRepo;

    public CzechModel getOne(String region) throws RegionNotFoundException {
        CzechEntity czechRegion = czechRepo.findByRegion(region);
        if (czechRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return CzechModel.toModel(czechRegion);
    }
}
