package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import com.regions.simpleRegions.entity.BritishEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BritishDescriptionModel;
import com.regions.simpleRegions.model.BritishRegionModel;
import com.regions.simpleRegions.respository.BritishAgeRepo;
import com.regions.simpleRegions.respository.BritishRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class BritishService {
    private final BritishRepo britishRepo;
    private final BritishAgeRepo britishAgeRepo;
    @Value("${notification.message}")
    private String REGION_NOT_FOUND;

    public BritishRegionModel getByRegion(String region) throws RegionNotFoundException {
        Optional<BritishEntity> britishRegion = britishRepo.findByRegion(getFirstTwoSymbols(region));
        Optional<BritishAgeEntity> britishAgeEntity = britishAgeRepo.findByCode(getLastTwoSymbols(region));

        if (!britishRegion.isPresent()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }

        if (!britishAgeEntity.isPresent()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }

        return BritishRegionModel.toModelRegion(britishRegion, britishAgeEntity);
    }

    public List<BritishDescriptionModel> getByDescription(String description) throws RegionNotFoundException {
        List<BritishDescriptionModel> britishDescriptionModels;
        List<BritishEntity> britishEntities = britishRepo.findByDescription(description);
        if (britishEntities.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        britishDescriptionModels = britishEntities.stream().map(BritishDescriptionModel::toModelDescription).collect(Collectors.toList());
        return britishDescriptionModels;
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
