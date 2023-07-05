package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.EstoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.EstoniaModel;
import com.regions.simpleregions.respository.EstoniaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class EstoniaService {

    private final EstoniaRepo estoniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public EstoniaModel getEstoniaPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<EstoniaEntity> estoniaRegion = estoniaRepo.findByRegion(region);

        estoniaRegion.stream().filter(estoniaEntity -> estoniaEntity.getRegion().equals(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return EstoniaModel.toModelByRegion(estoniaRegion);
    }

    public List<EstoniaModel> getEstoniaPlatesRegionByDescription(final String description) throws DescriptionNotFoundException {
        List<EstoniaEntity> estoniaEntityList = estoniaRepo.findByDescription(description);

        estoniaEntityList.stream().findAny().map(estoniaEntity -> estoniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return estoniaEntityList.stream().map(EstoniaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<EstoniaEntity> getAllRegions() {
        return estoniaRepo.findAll();
    }
}
