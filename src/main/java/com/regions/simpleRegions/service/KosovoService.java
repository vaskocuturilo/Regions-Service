package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.KosovoEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.KosovoModel;
import com.regions.simpleRegions.respository.KosovoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KosovoService {

    KosovoRepo kosovoRepo;

    @Autowired
    public KosovoService(KosovoRepo kosovoRepo) {
        this.kosovoRepo = kosovoRepo;
    }

    public KosovoModel getOne(String region) throws RegionNotFoundException {
        KosovoEntity kosovoRegion = kosovoRepo.findByRegion(region);
        if (kosovoRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return KosovoModel.toModel(kosovoRegion);
    }

    public Iterable<KosovoEntity> getAllRegions() {
        return kosovoRepo.findAll();
    }
}
