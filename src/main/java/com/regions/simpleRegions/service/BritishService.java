package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BritishEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BritishModel;
import com.regions.simpleRegions.respository.BritishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BritishService {

    BritishRepo britishRepo;

    @Autowired
    public BritishService(BritishRepo britishRepo) {
        this.britishRepo = britishRepo;
    }

    public BritishModel getOne(String region) throws RegionNotFoundException {
        BritishEntity britishRegion = britishRepo.findByRegion(region);
        if (britishRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return BritishModel.toModel(britishRegion);
    }

    public Iterable<BritishEntity> getAllRegions() {
        return britishRepo.findAll();
    }
}
