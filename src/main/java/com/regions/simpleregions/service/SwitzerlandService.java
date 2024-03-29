package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwitzerlandModel;
import com.regions.simpleregions.respository.SwitzerlandRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class SwitzerlandService {

    private final SwitzerlandRepository switzerlandRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "switzerland_region", key = "#region")
    public SwitzerlandModel getSwitzerlandPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getSwitzerlandPlatesByRegion");
        Optional<SwitzerlandEntity> switzerlandRegion = switzerlandRepository.findByRegion(region);

        Optional.ofNullable(
                switzerlandRegion
                        .stream().parallel()
                        .filter(switzerlandEntity -> switzerlandEntity.getRegion().equalsIgnoreCase(region))
                        .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwitzerlandModel.toModelByRegion(switzerlandRegion);
    }

    @Cacheable(value = "switzerland_description", key = "#description")
    public List<SwitzerlandModel> getSwitzerlandPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getSwitzerlandPlatesByDescription");
        List<SwitzerlandEntity> switzerlandEntityList = switzerlandRepository.findByDescription(description);

        switzerlandEntityList
                .stream().parallel()
                .map(switzerlandEntity -> switzerlandEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return switzerlandEntityList.stream().map(SwitzerlandModel::toModelByDescription).toList();
    }

    public Iterable<SwitzerlandEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return switzerlandRepository.findAll();
    }
}
