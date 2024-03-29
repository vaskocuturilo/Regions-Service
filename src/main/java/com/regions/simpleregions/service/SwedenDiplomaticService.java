package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwedenDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwedenDiplomaticModel;
import com.regions.simpleregions.respository.SwedenDiplomaticRepository;
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
public class SwedenDiplomaticService {

    private final SwedenDiplomaticRepository swedenDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "sweden_diplomatic_region", key = "#region")
    public SwedenDiplomaticModel getSwedenDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getSwedenDiplomaticPlatesByRegion");
        Optional<SwedenDiplomaticEntity> swedenRegion = swedenDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(swedenRegion
                .stream().parallel()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwedenDiplomaticModel.toModelByRegion(swedenRegion);
    }

    @Cacheable(value = "sweden_diplomatic_description", key = "#description")
    public List<SwedenDiplomaticModel> getSwedenDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getSwedenDiplomaticPlatesByDescription");
        List<SwedenDiplomaticEntity> swedenEntityList = swedenDiplomaticRepository.findByDescription(description);

        swedenEntityList
                .stream().parallel()
                .map(swedenEntity -> swedenEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return swedenEntityList.stream().map(SwedenDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<SwedenDiplomaticEntity> getAllSwedenDiplomaticRegions() {
        log.info("Start method getAllSwedenDiplomaticRegions");
        return swedenDiplomaticRepository.findAll();
    }
}
