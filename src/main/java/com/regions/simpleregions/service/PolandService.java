package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.PolandEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.PolandModel;
import com.regions.simpleregions.respository.PolandRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class PolandService {

    private final PolandRepo polandRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public PolandModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<PolandEntity> polandRegion = polandRepo.findByRegion(region);
        polandRegion.stream().filter(polandEntity -> polandEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return PolandModel.toModel(polandRegion);
    }

    public List<PolandModel> getByDescription(final String description) throws RegionNotFoundException {
        List<PolandEntity> polandEntityList = polandRepo.findByDescription(description);
        polandEntityList.stream().findAny().map(polandEntity -> polandEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return polandEntityList.stream().map(PolandModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<PolandEntity> getAllRegions() {
        return polandRepo.findAll();
    }
}
