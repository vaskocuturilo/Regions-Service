package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.HungaryEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.HungaryModel;
import com.regions.simpleRegions.respository.HungaryRepo;
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

    public HungaryModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<HungaryEntity> hungaryRegion = hungaryRepo.findByRegion(region);
        hungaryRegion.stream().filter(hungaryEntity -> hungaryEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));
            return regionNotFoundException;
        });

        return HungaryModel.toModelByRegion(hungaryRegion);
    }

    public List<HungaryModel> getRegionByDescription(final String description) throws RegionNotFoundException {
        List<HungaryEntity> hungaryEntities = hungaryRepo.findByDescription(description);

        hungaryEntities.stream().findAny().map(hungaryEntity -> hungaryEntity.getDescription()).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(String.format(descriptionNotFound, description)));
            return regionNotFoundException;
        });

        return hungaryEntities.stream().map(HungaryModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<HungaryEntity> getAllRegions() {
        return hungaryRepo.findAll();
    }
}
