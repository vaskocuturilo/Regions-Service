package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.MontenegroEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.MontenegroModel;
import com.regions.simpleRegions.respository.MontenegroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MontenegroService {

    MontenegroRepo montenegroRepo;

    @Autowired
    public MontenegroService(MontenegroRepo montenegroRepo) {
        this.montenegroRepo = montenegroRepo;
    }

    public MontenegroModel getOne(String region) throws RegionNotFoundException {
        MontenegroEntity montenegroRegion = montenegroRepo.findByRegion(region);
        if (montenegroRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return MontenegroModel.toModel(montenegroRegion);
    }
}
