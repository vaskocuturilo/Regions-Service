package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.EstoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.EstoniaModel;
import com.regions.simpleregions.respository.EstoniaRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Data
@Service
public class EstoniaService {

    private final EstoniaRepo estoniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public EstoniaModel getEstoniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getEstoniaDiplomaticPlatesByRegion");
        Optional<EstoniaEntity> estoniaRegion = estoniaRepo.findByRegion(region);

        estoniaRegion.stream().filter(estoniaEntity -> estoniaEntity.getRegion().equals(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return EstoniaModel.toModelByRegion(estoniaRegion);
    }

    public List<EstoniaModel> getEstoniaDiplomaticPlatesRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getEstoniaDiplomaticPlatesRegionByDescription");
        List<EstoniaEntity> estoniaEntityList = estoniaRepo.findByDescription(description);

        estoniaEntityList.stream().findAny().map(estoniaEntity -> estoniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return estoniaEntityList.stream().map(EstoniaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<EstoniaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return estoniaRepo.findAll();
    }
}