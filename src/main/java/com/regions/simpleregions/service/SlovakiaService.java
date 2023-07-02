package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SlovakiaEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SlovakiaModel;
import com.regions.simpleregions.respository.SlovakiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlovakiaService {

    SlovakiaRepo slovakiaRepo;

    @Autowired
    public SlovakiaService(SlovakiaRepo slovakiaRepo) {
        this.slovakiaRepo = slovakiaRepo;
    }

    public SlovakiaModel getOne(String region) throws RegionNotFoundException {
        SlovakiaEntity slovakiaRegion = slovakiaRepo.findByRegion(region);
        if (slovakiaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return SlovakiaModel.toModel(slovakiaRegion);
    }

    public Iterable<SlovakiaEntity> getAllRegions() {
        return slovakiaRepo.findAll();
    }
}
