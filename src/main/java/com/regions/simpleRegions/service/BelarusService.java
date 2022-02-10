package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BelarusEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BelarusModel;
import com.regions.simpleRegions.respository.BelarusRepo;
import org.springframework.stereotype.Service;

@Service
public class BelarusService {

    BelarusRepo belarusRepo;

    public BelarusService(BelarusRepo belarusRepo) {
        this.belarusRepo = belarusRepo;
    }

    public BelarusModel getOne(String region) throws RegionNotFoundException {
        BelarusEntity belarusRegion = belarusRepo.findByRegion(region);
        if (belarusRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return BelarusModel.toModel(belarusRegion);
    }

    public Iterable<BelarusEntity> getAllRegions() {
        return belarusRepo.findAll();
    }
}
