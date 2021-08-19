package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.PolandEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.PolandModel;
import com.regions.simpleRegions.respository.PolandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolandService {

    @Autowired
    PolandRepo polandRepo;

    public PolandModel getOne(String region) throws RegionNotFoundException {
        PolandEntity polandRegion = polandRepo.findByRegion(region);
        if (polandRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return PolandModel.toModel(polandRegion);
    }
}
