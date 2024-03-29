package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.FranceDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.FranceDiplomaticModel;
import com.regions.simpleregions.respository.FranceDiplomaticRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@Data
public class FranceDiplomaticService {

    private final FranceDiplomaticRepository franceDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;


    @Cacheable(value = "france_diplomatic_region", key = "#region")
    public FranceDiplomaticModel getFranceDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getFranceDiplomaticPlatesByRegion");
        Optional<FranceDiplomaticEntity> franceRegion = franceDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(franceRegion.stream().parallel().filter(franceEntity -> franceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return FranceDiplomaticModel.toModel(franceRegion);
    }

    @Cacheable(value = "france_diplomatic_description", key = "#description")
    public List<FranceDiplomaticModel> getFranceDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getFranceDiplomaticPlatesByDescription");
        List<FranceDiplomaticEntity> franceEntityList = franceDiplomaticRepository.findByDescription(description);

        franceEntityList.stream().parallel().findAny().map(franceEntity -> franceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return franceEntityList.stream().map(FranceDiplomaticModel::toModelDescription).toList();
    }

    public Iterable<FranceDiplomaticEntity> getAllDiplomaticRegions() {
        log.info("Start method getAllDiplomaticRegions");
        return franceDiplomaticRepository.findAll();
    }
}
