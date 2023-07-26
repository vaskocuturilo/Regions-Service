package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.EstoniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.EstoniaDiplomaticModel;
import com.regions.simpleregions.respository.EstoniaDiplomaticRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class EstoniaDiplomaticService {

    private final EstoniaDiplomaticRepo estoniaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public EstoniaDiplomaticModel getEstoniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getEstoniaDiplomaticPlatesByRegion");
        Optional<EstoniaDiplomaticEntity> estoniaRegion = estoniaDiplomaticRepo.findByRegion(region);

        estoniaRegion.stream().parallel().filter(estoniaEntity -> estoniaEntity.getRegion().equals(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return EstoniaDiplomaticModel.toModelByRegion(estoniaRegion);
    }

    public List<EstoniaDiplomaticModel> getEstoniaDiplomaticPlatesRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getEstoniaDiplomaticPlatesRegionByDescription");
        List<EstoniaDiplomaticEntity> estoniaEntityList = estoniaDiplomaticRepo.findByDescription(description);

        estoniaEntityList.stream().parallel().findAny().map(estoniaEntity -> estoniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return estoniaEntityList.stream().map(EstoniaDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<EstoniaDiplomaticEntity> getAllEstoniaDiplomaticRegions() {
        log.info("Start method getAllEstoniaDiplomaticRegions");
        return estoniaDiplomaticRepo.findAll();
    }
}
