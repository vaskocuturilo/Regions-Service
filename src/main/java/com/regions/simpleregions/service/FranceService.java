package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.FranceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.FranceModel;
import com.regions.simpleregions.respository.FranceRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class FranceService {

    private final FranceRepo franceRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public FranceModel getFrancePlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<FranceEntity> franceRegion = franceRepo.findByRegion(region);
        franceRegion.stream().filter(franceEntity -> franceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));
        return FranceModel.toModel(franceRegion);
    }

    public List<FranceModel> getFrancePlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<FranceEntity> franceEntityList = franceRepo.findByDescription(description);

        franceEntityList.stream().findAny().map(franceEntity -> franceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return franceEntityList.stream().map(FranceModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<FranceEntity> getAllRegions() {
        return franceRepo.findAll();
    }
}
