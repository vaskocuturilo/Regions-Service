package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.RomaniaEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.RomaniaModel;
import com.regions.simpleregions.respository.RomaniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RomaniaService {

    RomaniaRepo romaniaRepo;

    @Autowired
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

    public Iterable<RomaniaEntity> getAllRegions() {
        return romaniaRepo.findAll();
    }
}
