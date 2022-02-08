package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.exception.RegionAlreadyExistException;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.RussiaModel;
import com.regions.simpleRegions.respository.RussiaRepo;
import org.springframework.stereotype.Service;

@Service
public class RussiaService {

    RussiaRepo russiaRepo;

    public RussiaService(RussiaRepo russiaRepo) {
        this.russiaRepo = russiaRepo;
    }

    public RussiaEntity createRegion(RussiaEntity russiaEntity) throws RegionAlreadyExistException {
        if (russiaRepo.findByRegion(russiaEntity.getRegion()) != null) {
            throw new RegionAlreadyExistException("Region is exist.");
        }
        return russiaRepo.save(russiaEntity);
    }

    public RussiaModel getDescription(String region) throws RegionNotFoundException {
        RussiaEntity russiaDescription = russiaRepo.findByRegion(region);
        if (russiaDescription == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return RussiaModel.toModelDescription(russiaDescription);
    }

    public RussiaModel getRegionNumber(String description) throws RegionNotFoundException {
        RussiaEntity russiaRegion = russiaRepo.findByDescription(description);
        if (russiaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return RussiaModel.toModelRegion(russiaRegion);
    }

    public Iterable<RussiaEntity> getAllRegions() {
        return russiaRepo.findAll();
    }
}
