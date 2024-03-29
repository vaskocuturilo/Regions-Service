package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.GermanyDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.GermanyDiplomaticModel;
import com.regions.simpleregions.respository.GermanyDiplomaticRepository;
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
public class GermanyDiplomaticService {

    private final GermanyDiplomaticRepository germanyDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "germany_diplomatic_region", key = "#region")
    public GermanyDiplomaticModel getGermanPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getGermanPlatesByRegion");
        Optional<GermanyDiplomaticEntity> germanRegion = germanyDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(germanRegion.stream().parallel().filter(germanyDiplomaticEntity -> germanyDiplomaticEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return GermanyDiplomaticModel.toModelRegion(germanRegion);
    }

    @Cacheable(value = "germany_diplomatic_description", key = "#description")
    public List<GermanyDiplomaticModel> getGermanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getGermanPlatesByDescription");
        List<GermanyDiplomaticEntity> germanyDiplomaticEntityList = germanyDiplomaticRepository.findByDescription(description);

        germanyDiplomaticEntityList.stream().parallel().findAny().map(germanyDiplomaticEntity -> germanyDiplomaticEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return germanyDiplomaticEntityList.stream().map(GermanyDiplomaticModel::toModelDescription).toList();
    }

    public Iterable<GermanyDiplomaticEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return germanyDiplomaticRepository.findAll();
    }
}
