package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.NorwayDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.NorwayDiplomaticModel;
import com.regions.simpleregions.respository.NorwayDiplomaticRepository;
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
public class NorwayDiplomaticService {

    private final NorwayDiplomaticRepository norwayDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "norway_diplomatic_region", key = "#region")
    public NorwayDiplomaticModel getNorwayDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getNorwayDiplomaticPlatesByRegion");
        Optional<NorwayDiplomaticEntity> norwayRegion = norwayDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(norwayRegion
                .stream().parallel()
                .filter(norwayEntity -> norwayEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return NorwayDiplomaticModel.toModelByRegion(norwayRegion);
    }

    @Cacheable(value = "norway_diplomatic_description", key = "#description")
    public List<NorwayDiplomaticModel> getNorwayDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getNorwayDiplomaticPlatesByDescription");
        List<NorwayDiplomaticEntity> norwayEntityList = norwayDiplomaticRepository.findByDescription(description);

        norwayEntityList
                .stream().parallel()
                .map(norwayEntity -> norwayEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return norwayEntityList.stream().map(NorwayDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<NorwayDiplomaticEntity> getAllNorwayDiplomaticRegions() {
        log.info("Start method getAllNorwayDiplomaticRegions");
        return norwayDiplomaticRepository.findAll();
    }
}
