package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.NorwayEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.NorwayModel;
import com.regions.simpleregions.respository.NorwayRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Data
@Service
public class NorwayService {

    private final NorwayRepo norwayRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public NorwayModel getNorwayPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getNorwayPlatesByRegion");
        Optional<NorwayEntity> norwayRegion = norwayRepo.findByRegion(region);

        Optional.ofNullable(norwayRegion
                .stream()
                .filter(norwayEntity -> norwayEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return NorwayModel.toModelByRegion(norwayRegion);
    }

    public List<NorwayModel> getNorwayPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getNorwayPlatesByDescription");
        List<NorwayEntity> norwayEntityList = norwayRepo.findByDescription(description);

        norwayEntityList
                .stream()
                .map(norwayEntity -> norwayEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return norwayEntityList.stream().map(NorwayModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<NorwayEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return norwayRepo.findAll();
    }
}
