package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AustriaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AustriaModel;
import com.regions.simpleRegions.respository.AustriaRepo;
import org.springframework.stereotype.Service;

@Service
public class AustriaService {

    AustriaRepo austriaRepo;

    public AustriaService(AustriaRepo austriaRepo) {
        this.austriaRepo = austriaRepo;
    }

    public AustriaModel getOne(String region) throws RegionNotFoundException {
        AustriaEntity austriaRegion = austriaRepo.findByRegion(region);
        if (austriaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return AustriaModel.toModel(austriaRegion);
    }
}
