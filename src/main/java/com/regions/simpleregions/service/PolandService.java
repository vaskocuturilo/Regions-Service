package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.PolandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
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

    public PolandModel getPolandPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<PolandEntity> polandRegion = polandRepo.findByRegion(region);
        polandRegion.stream().filter(polandEntity -> polandEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return PolandModel.toModel(polandRegion);
    }

    public List<PolandModel> getPolandPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<PolandEntity> polandEntityList = polandRepo.findByDescription(description);
        polandEntityList.stream().findAny().map(polandEntity -> polandEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return polandEntityList.stream().map(PolandModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<PolandEntity> getAllRegions() {
        return polandRepo.findAll();
    }
}
