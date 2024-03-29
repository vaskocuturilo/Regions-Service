package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BritishAgeEntity;
import com.regions.simpleregions.entity.BritishEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BritishDescriptionModel;
import com.regions.simpleregions.model.BritishRegionModel;
import com.regions.simpleregions.respository.BritishAgeRepository;
import com.regions.simpleregions.respository.BritishRepository;
import com.regions.simpleregions.util.RegionParse;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.regions.simpleregions.util.DetailPlate.getPlateDetail;
import static com.regions.simpleregions.util.Utils.getFirstTwoSymbols;
import static com.regions.simpleregions.util.Utils.getLastTwoSymbols;

@Log4j2
@Data
@Service
public class BritishService {
    private final BritishRepository britishRepository;

    private final BritishAgeRepository britishAgeRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "british_region", key = "#region")
    public BritishRegionModel getBritishPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<BritishEntity> britishRegion = getOptionalBritishEntity();
        Optional<BritishAgeEntity> britishAgeEntity = getOptionalBritishAgeEntity();

        log.info("Start method getBritishPlatesByRegion");

        final RegionParse details = getPlateDetail(region);
        if (details.getLetter() == 5 && details.getNumber() == 2 && details.getSpace() == 1) {
            britishRegion = britishRepository.findByRegion(getFirstTwoSymbols(region));
            britishAgeEntity = britishAgeRepository.findByCode(getLastTwoSymbols(region));

            if (britishRegion.isEmpty()) {
                throw new RegionNotFoundException(String.format(regionNotFound, region));
            }

            if (britishAgeEntity.isEmpty()) {
                throw new RegionNotFoundException(String.format(regionNotFound, region));
            }
        }

        return BritishRegionModel.toModelRegion(britishRegion, britishAgeEntity);
    }

    @Cacheable(value = "british_description", key = "#description")
    public List<BritishDescriptionModel> getBritishPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getBritishPlatesByDescription");
        List<BritishEntity> britishEntities = britishRepository.findByDescription(description);

        britishEntities.parallelStream().findAny().map(britishEntity -> britishEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return britishEntities.stream().map(BritishDescriptionModel::toModelDescription).toList();
    }

    public Iterable<BritishEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return britishRepository.findAll();
    }

    public Optional<BritishEntity> getOptionalBritishEntity() {
        return Optional.empty();
    }

    public Optional<BritishAgeEntity> getOptionalBritishAgeEntity() {
        return Optional.empty();
    }
}
