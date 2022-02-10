package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.UkraineEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.UkraineModel;
import com.regions.simpleRegions.respository.UkraineRepo;
import org.springframework.stereotype.Service;

@Service
public class UkraineService {

    UkraineRepo ukraineRepo;

    public UkraineService(UkraineRepo ukraineRepo) {
        this.ukraineRepo = ukraineRepo;
    }

    public UkraineModel getOne(String region) throws RegionNotFoundException {
        UkraineEntity ukraineRegion = ukraineRepo.findByRegion(region);
        if (ukraineRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return UkraineModel.toModel(ukraineRegion);
    }

    public Iterable<UkraineEntity> getAllRegions() {
        return ukraineRepo.findAll();
    }
}
