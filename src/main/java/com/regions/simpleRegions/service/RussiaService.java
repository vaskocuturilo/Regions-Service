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

    public RussiaModel getOne(String region) throws RegionNotFoundException {
        RussiaEntity russiaRegion = russiaRepo.findByRegion(region);
        if (russiaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return RussiaModel.toModel(russiaRegion);
    }

    public Iterable<RussiaEntity> getAllRegions() {
        return russiaRepo.findAll();
    }
}
