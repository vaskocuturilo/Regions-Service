package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SloveniaEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SloveniaModel;
import com.regions.simpleregions.respository.SloveniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SloveniaService {

    SloveniaRepo sloveniaRepo;

    @Autowired
    public SloveniaService(SloveniaRepo sloveniaRepo) {
        this.sloveniaRepo = sloveniaRepo;
    }

    public SloveniaModel getOne(String region) throws RegionNotFoundException {
        SloveniaEntity sloveniaRegion = sloveniaRepo.findByRegion(region);
        if (sloveniaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return SloveniaModel.toModel(sloveniaRegion);
    }

    public Iterable<SloveniaEntity> getAllRegions() {
        return sloveniaRepo.findAll();
    }
}
