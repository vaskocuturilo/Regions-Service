package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.RomaniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.RomaniaModel;
import com.regions.simpleRegions.respository.RomaniaRepo;
import org.springframework.stereotype.Service;

@Service
public class RomaniaService {

    RomaniaRepo romaniaRepo;

    public RomaniaService(RomaniaRepo romaniaRepo) {
        this.romaniaRepo = romaniaRepo;
    }

    public RomaniaModel getOne(String region) throws RegionNotFoundException {
        RomaniaEntity romaniaRegion = romaniaRepo.findByRegion(region);
        if (romaniaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return RomaniaModel.toModel(romaniaRegion);
    }
}
