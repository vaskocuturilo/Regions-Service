package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.RussiaModel;
import com.regions.simpleRegions.respository.RussiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RussiaService {

    RussiaRepo russiaRepo;

    @Autowired
    public RussiaService(RussiaRepo russiaRepo) {
        this.russiaRepo = russiaRepo;
    }

    public RussiaModel getRegionNumber(String region) throws RegionNotFoundException {
        RussiaEntity russiaRegion = russiaRepo.findByRegion(region);
        if (russiaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return RussiaModel.toModelRegion(russiaRegion);
    }

    public List<RussiaModel> getDescription(String description) throws RegionNotFoundException {
        List<RussiaModel> userModel = new ArrayList<>();
        List<RussiaEntity> russiaRegion = russiaRepo.findByDescription(description);
        if (russiaRegion.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        for (RussiaEntity russiaEntity : russiaRegion) {
            userModel.add(RussiaModel.toModelDescription(russiaEntity));
        }
        return userModel;
    }

    public Iterable<RussiaEntity> getAllRegions() {
        return russiaRepo.findAll();
    }
}
