package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.KazakhstanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.KazakhstanModel;
import com.regions.simpleRegions.respository.KazakhstanRepo;
import org.springframework.stereotype.Service;

@Service
public class KazakhstanService {

    KazakhstanRepo kazakhstanRepo;

    public KazakhstanService(KazakhstanRepo kazakhstanRepo) {
        this.kazakhstanRepo = kazakhstanRepo;
    }

    public KazakhstanModel getOne(String region) throws RegionNotFoundException {
        KazakhstanEntity kazakhstanRegion = kazakhstanRepo.findByRegion(region);
        if (kazakhstanRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return KazakhstanModel.toModel(kazakhstanRegion);
    }
}
