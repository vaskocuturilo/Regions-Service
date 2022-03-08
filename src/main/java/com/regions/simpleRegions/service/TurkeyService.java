package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.TurkeyEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.TurkeyModel;
import com.regions.simpleRegions.respository.TurkeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurkeyService {

    TurkeyRepo turkeyRepo;

    @Autowired
    public TurkeyService(TurkeyRepo turkeyRepo) {
        this.turkeyRepo = turkeyRepo;
    }

    public TurkeyModel getOne(String region) throws RegionNotFoundException {
        TurkeyEntity turkeyRegion = turkeyRepo.findByRegion(region);
        if (turkeyRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return TurkeyModel.toModel(turkeyRegion);
    }

    public Iterable<TurkeyEntity> getAllRegions() {
        return turkeyRepo.findAll();
    }
}
