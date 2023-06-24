package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.EstoniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.EstoniaModel;
import com.regions.simpleRegions.respository.EstoniaRepo;
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

    public EstoniaModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<EstoniaEntity> estoniaRegion = estoniaRepo.findByRegion(region);

        estoniaRegion.stream().filter(estoniaEntity -> estoniaEntity.getRegion().equals(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));
            return regionNotFoundException;
        });


        return EstoniaModel.toModelByRegion(estoniaRegion);
    }

    public List<EstoniaModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<EstoniaEntity> estoniaEntityList = estoniaRepo.findByDescription(description);
        estoniaEntityList.stream().findAny().map(estoniaEntity -> estoniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });
        return estoniaEntityList.stream().map(EstoniaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<EstoniaEntity> getAllRegions() {
        return estoniaRepo.findAll();
    }
}
