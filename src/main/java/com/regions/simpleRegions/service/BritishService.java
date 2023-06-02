package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import com.regions.simpleRegions.entity.BritishEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BritishModel;
import com.regions.simpleRegions.respository.BritishAgeRepo;
import com.regions.simpleRegions.respository.BritishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BritishService {
    private final BritishRepo britishRepo;
    private final BritishAgeRepo britishAgeRepo;

    @Autowired
    public BritishService(BritishRepo britishRepo, BritishAgeRepo britishAgeRepo) {
        this.britishRepo = britishRepo;
        this.britishAgeRepo = britishAgeRepo;
    }

    public BritishModel getByRegion(String region) throws RegionNotFoundException {
        String city = getFirstTwoSymbols(region);
        String code = getLastTwoSymbols(region);

        BritishEntity britishRegion = britishRepo.findByRegion(city);
        BritishAgeEntity britishAgeEntity = britishAgeRepo.findByCode(code);

        if (britishRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }

        if (britishAgeEntity == null) {
            throw new RegionNotFoundException("Region not found.");
        }

        return BritishModel.toModelRegion(britishRegion, britishAgeEntity);
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

    public String getFirstTwoSymbols(String text) {
        return text.length() < 2 ? text : text.substring(0, 2);
    }

    public String getLastTwoSymbols(String text) {
        return text.substring(Math.max(text.length() - 2, 0));
    }
}
