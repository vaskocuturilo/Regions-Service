package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ArmeniaEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.ArmeniaModel;
import com.regions.simpleregions.respository.ArmeniaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class ArmeniaService {

    private final ArmeniaRepo armeniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public ArmeniaModel getArmeniaPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<ArmeniaEntity> armeniaRegion = armeniaRepo.findByRegion(region);
        armeniaRegion.stream().filter(armeniaEntity -> armeniaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return ArmeniaModel.toModelRegion(armeniaRegion);
    }

    public List<ArmeniaModel> getArmeniaPlatesByDescription(final String description) throws RegionNotFoundException {
        List<ArmeniaEntity> armeniaEntityList = armeniaRepo.findByDescription(description);
        armeniaEntityList.stream().findAny().map(armeniaEntity -> armeniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new RegionNotFoundException(String.format(descriptionNotFound, description)));

        return armeniaEntityList.stream().map(ArmeniaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<ArmeniaEntity> getAllRegions() {
        return armeniaRepo.findAll();
    }
}
