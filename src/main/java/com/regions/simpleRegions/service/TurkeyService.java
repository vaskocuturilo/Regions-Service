package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.TurkeyEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.TurkeyModel;
import com.regions.simpleRegions.respository.TurkeyRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class TurkeyService {

    private final TurkeyRepo turkeyRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public TurkeyModel getTurkeyPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<TurkeyEntity> turkeyRegion = turkeyRepo.findByRegion(region);

        turkeyRegion.stream().filter(turkeyEntity -> turkeyEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });


        return TurkeyModel.toModelByRegion(turkeyRegion);
    }

    public List<TurkeyModel> getTurkeyPlatesByDescription(final String description) throws RegionNotFoundException {
        List<TurkeyEntity> turkeyEntityList = turkeyRepo.findByDescription(description);

        turkeyEntityList.stream().findAny().map(turkeyEntity -> turkeyEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return turkeyEntityList.stream().map(TurkeyModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<TurkeyEntity> getAllRegions() {
        return turkeyRepo.findAll();
    }
}
