package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.EstoniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.EstoniaDiplomaticModel;
import com.regions.simpleregions.respository.EstoniaDiplomaticRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class EstoniaDiplomaticService {

    private final EstoniaDiplomaticRepository estoniaDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "estonia_diplomatic_region", key = "#region")
    public EstoniaDiplomaticModel getEstoniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getEstoniaDiplomaticPlatesByRegion");
        Optional<EstoniaDiplomaticEntity> estoniaRegion = estoniaDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(estoniaRegion.stream().parallel().filter(estoniaEntity -> estoniaEntity.getRegion().equals(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return EstoniaDiplomaticModel.toModelByRegion(estoniaRegion);
    }

    @Cacheable(value = "estonia_diplomatic_description", key = "#description")
    public List<EstoniaDiplomaticModel> getEstoniaDiplomaticPlatesRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getEstoniaDiplomaticPlatesRegionByDescription");
        List<EstoniaDiplomaticEntity> estoniaEntityList = estoniaDiplomaticRepository.findByDescription(description);

        estoniaEntityList.stream().parallel().findAny().map(estoniaEntity -> estoniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return estoniaEntityList.stream().map(EstoniaDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<EstoniaDiplomaticEntity> getAllEstoniaDiplomaticRegions() {
        log.info("Start method getAllEstoniaDiplomaticRegions");
        return estoniaDiplomaticRepository.findAll();
    }
}
