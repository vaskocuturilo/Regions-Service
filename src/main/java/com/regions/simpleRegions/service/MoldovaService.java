package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.MoldovaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.MoldovaModel;
import com.regions.simpleRegions.respository.MoldovaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoldovaService {

    MoldovaRepo moldovaRepo;

    @Autowired
    public MoldovaService(MoldovaRepo moldovaRepo) {
        this.moldovaRepo = moldovaRepo;
    }

    public MoldovaModel getOne(String region) throws RegionNotFoundException {
        MoldovaEntity moldovaRegion = moldovaRepo.findByRegion(region);
        if (moldovaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return MoldovaModel.toModel(moldovaRegion);
    }
}
