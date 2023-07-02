package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.UzbekistanEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.UzbekistanModel;
import com.regions.simpleregions.respository.UzbekistanRepo;
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

    public Iterable<UzbekistanEntity> getAllRegions() {
        return uzbekistanRepo.findAll();
    }
}
