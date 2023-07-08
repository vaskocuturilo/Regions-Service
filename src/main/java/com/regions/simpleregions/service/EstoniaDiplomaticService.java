package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.EstoniaDiplomaticEntity;
import com.regions.simpleregions.entity.EstoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.EstoniaDiplomaticModel;
import com.regions.simpleregions.model.EstoniaModel;
import com.regions.simpleregions.respository.EstoniaDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class EstoniaDiplomaticService {

    private final EstoniaDiplomaticRepo estoniaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public EstoniaDiplomaticModel getEstoniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<EstoniaDiplomaticEntity> estoniaRegion = estoniaDiplomaticRepo.findByRegion(region);

        estoniaRegion.stream().filter(estoniaEntity -> estoniaEntity.getRegion().equals(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return EstoniaDiplomaticModel.toModelByRegion(estoniaRegion);
    }

    public List<EstoniaDiplomaticModel> getEstoniaDiplomaticPlatesRegionByDescription(final String description) throws DescriptionNotFoundException {
        List<EstoniaDiplomaticEntity> estoniaEntityList = estoniaDiplomaticRepo.findByDescription(description);

        estoniaEntityList.stream().findAny().map(estoniaEntity -> estoniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return estoniaEntityList.stream().map(EstoniaDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<EstoniaDiplomaticEntity> getAllEstoniaDiplomaticRegions() {
        return estoniaDiplomaticRepo.findAll();
    }
}
