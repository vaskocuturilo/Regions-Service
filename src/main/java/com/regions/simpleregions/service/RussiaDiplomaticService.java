package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.RussiaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.RussiaDiplomaticModel;
import com.regions.simpleregions.respository.RussiaDiplomaticRepository;
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
public class RussiaDiplomaticService {

    private final RussiaDiplomaticRepository russiaDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "russia_diplomatic_region", key = "#region")
    public RussiaDiplomaticModel getRussiaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getRussiaDiplomaticPlatesByRegion");
        Optional<RussiaDiplomaticEntity> russiaDiplomaticRegion = russiaDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(russiaDiplomaticRegion.stream().parallel().filter(russiaDiplomaticEntity -> russiaDiplomaticEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return RussiaDiplomaticModel.toModelRegion(russiaDiplomaticRegion);
    }

    @Cacheable(value = "russia_diplomatic_description", key = "#description")
    public List<RussiaDiplomaticModel> getRussiaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getRussiaDiplomaticPlatesByDescription");
        List<RussiaDiplomaticEntity> russiaDiplomaticEntityList = russiaDiplomaticRepository.findByDescription(description);

        russiaDiplomaticEntityList.stream().parallel().findAny().map(russiaDiplomaticEntity -> russiaDiplomaticEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return russiaDiplomaticEntityList.stream().map(RussiaDiplomaticModel::toModelDescription).toList();
    }

    public Iterable<RussiaDiplomaticEntity> getAllDiplomaticRegions() {
        log.info("Start method getAllRegions");
        return russiaDiplomaticRepository.findAll();
    }
}
