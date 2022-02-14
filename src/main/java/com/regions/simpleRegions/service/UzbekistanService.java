package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.UzbekistanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.UzbekistanModel;
import com.regions.simpleRegions.respository.UzbekistanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UzbekistanService {

    UzbekistanRepo uzbekistanRepo;

    @Autowired
    public UzbekistanService(UzbekistanRepo uzbekistanRepo) {
        this.uzbekistanRepo = uzbekistanRepo;
    }

    public UzbekistanModel getOne(String region) throws RegionNotFoundException {
        UzbekistanEntity uzbekistanRegion = uzbekistanRepo.findByRegion(region);
        if (uzbekistanRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return UzbekistanModel.toModel(uzbekistanRegion);
    }
}
