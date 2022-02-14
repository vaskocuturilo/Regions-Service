package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AustriaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AustriaModel;
import com.regions.simpleRegions.respository.AustriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AustriaService {

    AustriaRepo austriaRepo;

    @Autowired
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

    public Iterable<AustriaEntity> getAllRegions() {
        return austriaRepo.findAll();
    }
}
