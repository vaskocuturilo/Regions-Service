package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.HungaryEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.HungaryModel;
import com.regions.simpleregions.respository.HungaryRepo;
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
public class HungaryService {

    private final HungaryRepo hungaryRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public HungaryModel getHungaryPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getHungaryPlatesByRegion");
        Optional<HungaryEntity> hungaryRegion = hungaryRepo.findByRegion(region);

        hungaryRegion.stream().filter(hungaryEntity -> hungaryEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return HungaryModel.toModelByRegion(hungaryRegion);
    }

    public List<HungaryModel> getHungaryPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getHungaryPlatesByDescription");
        List<HungaryEntity> hungaryEntities = hungaryRepo.findByDescription(description);

        hungaryEntities.stream().findAny().map(hungaryEntity -> hungaryEntity.getDescription()).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(String.format(descriptionNotFound, description))));

        return hungaryEntities.stream().map(HungaryModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<HungaryEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return hungaryRepo.findAll();
    }
}
