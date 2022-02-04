package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.HungaryEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.HungaryModel;
import com.regions.simpleRegions.respository.HungaryRepo;
import org.springframework.stereotype.Service;

@Service
public class HungaryService {

    HungaryRepo hungaryRepo;

    public HungaryService(HungaryRepo hungaryRepo) {
        this.hungaryRepo = hungaryRepo;
    }

    public HungaryModel getOne(String region) throws RegionNotFoundException {
        HungaryEntity hungaryRegion = hungaryRepo.findByRegion(region);
        if (hungaryRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return HungaryModel.toModel(hungaryRegion);
    }
}
