package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.HungaryEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.HungaryModel;
import com.regions.simpleregions.respository.HungaryRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class HungaryService {

    private final HungaryRepo hungaryRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public HungaryModel getHungaryPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<HungaryEntity> hungaryRegion = hungaryRepo.findByRegion(region);

        hungaryRegion.stream().filter(hungaryEntity -> hungaryEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return HungaryModel.toModelByRegion(hungaryRegion);
    }

    public List<HungaryModel> getHungaryPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<HungaryEntity> hungaryEntities = hungaryRepo.findByDescription(description);

        hungaryEntities.stream().findAny().map(hungaryEntity -> hungaryEntity.getDescription()).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(String.format(descriptionNotFound, description))));

        return hungaryEntities.stream().map(HungaryModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<HungaryEntity> getAllRegions() {
        return hungaryRepo.findAll();
    }
}
