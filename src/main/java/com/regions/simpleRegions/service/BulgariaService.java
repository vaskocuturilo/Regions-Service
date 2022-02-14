package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BulgariaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BulgariaModel;
import com.regions.simpleRegions.respository.BulgariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BulgariaService {

    BulgariaRepo bulgariaRepo;

    @Autowired
    public BulgariaService(BulgariaRepo bulgariaRepo) {
        this.bulgariaRepo = bulgariaRepo;
    }

    public BulgariaModel getOne(String region) throws RegionNotFoundException {
        BulgariaEntity bulgariaRegion = bulgariaRepo.findByRegion(region);
        if (bulgariaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return BulgariaModel.toModel(bulgariaRegion);
    }

    public Iterable<BulgariaEntity> getAllRegions() {
        return bulgariaRepo.findAll();
    }
}
