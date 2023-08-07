package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ItalianDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.ItalianDiplomaticModel;
import com.regions.simpleregions.respository.ItalianDiplomaticRepo;
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
public class ItalianDiplomaticService {
    private final ItalianDiplomaticRepo italianDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "italian_diplomatic_region", key = "#region")
    public ItalianDiplomaticModel getItalianDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getItalianDiplomaticPlatesByRegion");
        Optional<ItalianDiplomaticEntity> italianRegion = italianDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(italianRegion.stream().parallel().filter(italianEntity -> italianEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return ItalianDiplomaticModel.toModel(italianRegion);
    }

    @Cacheable(value = "italian_diplomatic_description", key = "#description")
    public List<ItalianDiplomaticModel> getItalianDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getItalianDiplomaticPlatesByDescription");
        List<ItalianDiplomaticEntity> italianEntityList = italianDiplomaticRepo.findByDescription(description);
        italianEntityList.stream().parallel().findAny().map(italianEntity -> italianEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return italianEntityList.stream().map(ItalianDiplomaticModel::toDescription).toList();
    }

    public Iterable<ItalianDiplomaticEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return italianDiplomaticRepo.findAll();
    }
}
