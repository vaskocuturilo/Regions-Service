package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.CroatiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.CroatiaModel;
import com.regions.simpleRegions.respository.CroatiaRepo;
import org.springframework.stereotype.Service;

@Service
public class CroatiaService {

    CroatiaRepo croatiaRepo;

    public CroatiaService(CroatiaRepo croatiaRepo) {
        this.croatiaRepo = croatiaRepo;
    }

    public CroatiaModel getOne(String region) throws RegionNotFoundException {
        CroatiaEntity croatiaRegion = croatiaRepo.findByRegion(region);
        if (croatiaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return CroatiaModel.toModel(croatiaRegion);
    }
}
