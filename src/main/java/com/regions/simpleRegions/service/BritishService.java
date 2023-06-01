package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BritishEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BritishModel;
import com.regions.simpleRegions.respository.BritishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BritishService {
    BritishRepo britishRepo;

    @Autowired
    public BritishService(BritishRepo britishRepo) {
        this.britishRepo = britishRepo;
    }

    public BritishModel getByRegion(String region) throws RegionNotFoundException {
        BritishEntity britishRegion = britishRepo.findByRegion(region);
        if (britishRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return BritishModel.toModelRegion(britishRegion);
    }

    public List<BritishModel> getByDescription(String description) throws RegionNotFoundException {
        List<BritishModel> britishModels = new ArrayList<>();
        List<BritishEntity> britishRegion = britishRepo.findByDescription(description);
        if (britishRegion.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        for (BritishEntity britishEntity : britishRegion) {
            britishModels.add(BritishModel.toModelDescription(britishEntity));
        }
        return britishModels;
    }

    public Iterable<BritishEntity> getAllRegions() {
        return britishRepo.findAll();
    }
}
