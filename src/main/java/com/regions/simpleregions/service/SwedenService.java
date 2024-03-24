package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwedenEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwedenModel;
import com.regions.simpleregions.respository.SwedenRepository;
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
public class SwedenService {

    private final SwedenRepository swedenRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "sweden_region", key = "#region")
    public SwedenModel getSwedenPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getSwedenPlatesByRegion");
        Optional<SwedenEntity> swedenRegion = swedenRepository.findByRegion(region);

        Optional.ofNullable(swedenRegion
                .stream().parallel()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwedenModel.toModelByRegion(swedenRegion);
    }

    @Cacheable(value = "sweden_description", key = "#description")
    public List<SwedenModel> getSwedenPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getSwedenPlatesByDescription");
        List<SwedenEntity> swedenEntityList = swedenRepository.findByDescription(description);

        swedenEntityList
                .stream().parallel()
                .map(swedenEntity -> swedenEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return swedenEntityList.stream().map(SwedenModel::toModelByDescription).toList();
    }

    public Iterable<SwedenEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return swedenRepository.findAll();
    }
}
