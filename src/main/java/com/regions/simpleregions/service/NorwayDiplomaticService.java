package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.NorwayDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.NorwayDiplomaticModel;
import com.regions.simpleregions.respository.NorwayDiplomaticRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class NorwayDiplomaticService {

    private final NorwayDiplomaticRepo norwayDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public NorwayDiplomaticModel getNorwayDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getNorwayDiplomaticPlatesByRegion");
        Optional<NorwayDiplomaticEntity> norwayRegion = norwayDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(norwayRegion
                .stream().parallel()
                .filter(norwayEntity -> norwayEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return NorwayDiplomaticModel.toModelByRegion(norwayRegion);
    }

    public List<NorwayDiplomaticModel> getNorwayDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getNorwayDiplomaticPlatesByDescription");
        List<NorwayDiplomaticEntity> norwayEntityList = norwayDiplomaticRepo.findByDescription(description);

        norwayEntityList
                .stream().parallel()
                .map(norwayEntity -> norwayEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return norwayEntityList.stream().map(NorwayDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<NorwayDiplomaticEntity> getAllNorwayDiplomaticRegions() {
        log.info("Start method getAllNorwayDiplomaticRegions");
        return norwayDiplomaticRepo.findAll();
    }
}
