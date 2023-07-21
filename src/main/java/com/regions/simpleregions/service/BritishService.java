package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BritishAgeEntity;
import com.regions.simpleregions.entity.BritishEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BritishDescriptionModel;
import com.regions.simpleregions.model.BritishRegionModel;
import com.regions.simpleregions.respository.BritishAgeRepo;
import com.regions.simpleregions.respository.BritishRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.regions.simpleregions.util.Utils.getFirstTwoSymbols;
import static com.regions.simpleregions.util.Utils.getLastTwoSymbols;

@Log4j2
@Data
@Service
public class BritishService {
    private final BritishRepo britishRepo;

    private final BritishAgeRepo britishAgeRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public BritishRegionModel getBritishPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getBritishPlatesByRegion");
        Optional<BritishEntity> britishRegion = britishRepo.findByRegion(getFirstTwoSymbols(region));
        Optional<BritishAgeEntity> britishAgeEntity = britishAgeRepo.findByCode(getLastTwoSymbols(region));

        if (britishRegion.isEmpty()) {
            throw new RegionNotFoundException(String.format(regionNotFound, region));
        }

        if (britishAgeEntity.isEmpty()) {
            throw new RegionNotFoundException(String.format(regionNotFound, region));
        }

        return BritishRegionModel.toModelRegion(britishRegion, britishAgeEntity);
    }

    public List<BritishDescriptionModel> getBritishPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getBritishPlatesByDescription");
        List<BritishEntity> britishEntities = britishRepo.findByDescription(description);

        britishEntities.stream().findAny().map(britishEntity -> britishEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return britishEntities.stream().map(BritishDescriptionModel::toModelDescription).toList();
    }

    public Iterable<BritishEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return britishRepo.findAll();
    }
}
