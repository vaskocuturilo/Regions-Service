package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BritishAgeEntity;
import com.regions.simpleregions.entity.BritishEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BritishDescriptionModel;
import com.regions.simpleregions.model.BritishRegionModel;
import com.regions.simpleregions.respository.BritishAgeRepo;
import com.regions.simpleregions.respository.BritishRepo;
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

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public BritishRegionModel getByRegion(String region) throws RegionNotFoundException {
        Optional<BritishEntity> britishRegion = britishRepo.findByRegion(getFirstTwoSymbols(region));
        Optional<BritishAgeEntity> britishAgeEntity = britishAgeRepo.findByCode(getLastTwoSymbols(region));

        if (!britishRegion.isPresent()) {
            throw new RegionNotFoundException(String.format(regionNotFound, region));
        }

        if (!britishAgeEntity.isPresent()) {
            throw new RegionNotFoundException(String.format(regionNotFound, region));
        }

        return BritishRegionModel.toModelRegion(britishRegion, britishAgeEntity);
    }

    public List<BritishDescriptionModel> getByDescription(String description) throws RegionNotFoundException {
        List<BritishEntity> britishEntities = britishRepo.findByDescription(description);

        britishEntities.stream().findAny().map(britishEntity -> britishEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });


        return britishEntities.stream().map(BritishDescriptionModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<BritishEntity> getAllRegions() {
        return britishRepo.findAll();
    }

    private String getFirstTwoSymbols(String text) {
        return text.length() < 2 ? text : text.substring(0, 2);
    }

    private String getLastTwoSymbols(String text) {
        return text.substring(Math.max(text.length() - 2, 0));
    }
}
