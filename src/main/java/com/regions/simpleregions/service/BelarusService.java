package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BelarusEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BelarusModel;
import com.regions.simpleregions.respository.BelarusRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class BelarusService {

    private final BelarusRepo belarusRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public BelarusModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<BelarusEntity> belarusRegion = belarusRepo.findByRegion(region);
        belarusRegion.stream().filter(belarusEntity -> belarusEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return BelarusModel.toModel(belarusRegion);
    }

    public List<BelarusModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<BelarusEntity> belarusEntityList = belarusRepo.findByDescription(description);

        belarusEntityList.stream().findAny().map(belarusEntity -> belarusEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });
        return belarusEntityList.stream().map(BelarusModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<BelarusEntity> getAllRegions() {

        return belarusRepo.findAll();
    }
}
