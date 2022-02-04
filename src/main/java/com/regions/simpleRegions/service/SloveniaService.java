package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.SloveniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.SloveniaModel;
import com.regions.simpleRegions.respository.SloveniaRepo;
import org.springframework.stereotype.Service;

@Service
public class SloveniaService {

    SloveniaRepo sloveniaRepo;

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
}
