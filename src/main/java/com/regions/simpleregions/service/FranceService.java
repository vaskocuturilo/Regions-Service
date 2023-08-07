package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.FranceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.FranceModel;
import com.regions.simpleregions.respository.FranceRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@Data
public class FranceService {

    private final FranceRepo franceRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "france_region", key = "#region")
    public FranceModel getFrancePlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getFrancePlatesByRegion");
        Optional<FranceEntity> franceRegion = franceRepo.findByRegion(region);

        Optional.ofNullable(franceRegion.stream().parallel().filter(franceEntity -> franceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return FranceModel.toModel(franceRegion);
    }

    @Cacheable(value = "france_description", key = "#description")
    public List<FranceModel> getFrancePlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getFrancePlatesByDescription");
        List<FranceEntity> franceEntityList = franceRepo.findByDescription(description);

        franceEntityList.stream().parallel().findAny().map(franceEntity -> franceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return franceEntityList.stream().map(FranceModel::toModelDescription).toList();
    }

    public Iterable<FranceEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return franceRepo.findAll();
    }
}
