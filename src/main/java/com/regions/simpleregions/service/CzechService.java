package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.CzechEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.CzechModel;
import com.regions.simpleregions.respository.CzechRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.regions.simpleregions.util.Utils.getSecondSymbol;

@Log4j2
@Service
@Data
public class CzechService {

    private final CzechRepo czechRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "czech_region", key = "#region")
    public CzechModel getCzechPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getCzechPlatesByRegion");

        Optional<CzechEntity> czechRegion = czechRepo.findByRegion(getSecondSymbol(region));

        Optional.ofNullable(czechRegion
                .stream()
                .parallel()
                .filter(czechEntity -> czechEntity.getRegion().equalsIgnoreCase(getSecondSymbol(region)))
                .findFirst()
                .orElseThrow(() ->
                        new RegionNotFoundException(String.format(regionNotFound, getSecondSymbol(region)))));

        return CzechModel.toModelRegion(czechRegion);
    }

    @Cacheable(value = "czech_description", key = "#description")
    public List<CzechModel> getCzechPlatesRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getCzechPlatesRegionByDescription");
        List<CzechEntity> czechEntityList = czechRepo.findByDescription(description);

        czechEntityList.stream().parallel().findAny().map(czechEntity -> czechEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return czechEntityList.stream().map(CzechModel::toModelDescription).toList();
    }

    public Iterable<CzechEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return czechRepo.findAll();
    }
}
