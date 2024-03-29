package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwitzerlandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwitzerlandDiplomaticModel;
import com.regions.simpleregions.respository.SwitzerlandDiplomaticRepository;
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
public class SwitzerlandDiplomaticService {

    private final SwitzerlandDiplomaticRepository switzerlandDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "switzerland_diplomatic_region", key = "#region")
    public SwitzerlandDiplomaticModel getSwitzerlandDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getSwitzerlandDiplomaticPlatesByRegion");
        Optional<SwitzerlandDiplomaticEntity> switzerlandRegion = switzerlandDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(
                switzerlandRegion
                        .stream().parallel()
                        .filter(switzerlandEntity -> switzerlandEntity.getRegion().equalsIgnoreCase(region))
                        .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwitzerlandDiplomaticModel.toModelByRegion(switzerlandRegion);
    }

    @Cacheable(value = "switzerland_diplomatic_description", key = "#description")
    public List<SwitzerlandDiplomaticModel> getSwitzerlandDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getSwitzerlandDiplomaticPlatesByDescription");
        List<SwitzerlandDiplomaticEntity> switzerlandEntityList = switzerlandDiplomaticRepository.findByDescription(description);

        switzerlandEntityList
                .stream().parallel()
                .map(switzerlandEntity -> switzerlandEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return switzerlandEntityList.stream().map(SwitzerlandDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<SwitzerlandDiplomaticEntity> getAllSwitzerlandDiplomaticRegions() {
        log.info("Start method getAllSwitzerlandDiplomaticRegions");
        return switzerlandDiplomaticRepository.findAll();
    }
}
