package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.SlovakiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.SlovakiaModel;
import com.regions.simpleRegions.respository.SlovakiaRepo;
import org.springframework.stereotype.Service;

@Service
public class SlovakiaService {

    SlovakiaRepo slovakiaRepo;

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
}
