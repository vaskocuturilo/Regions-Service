package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ItalianEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.ItalianModel;
import com.regions.simpleregions.respository.ItalianRepository;
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
public class ItalianService {
    private final ItalianRepository italianRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "italian_region", key = "#region")
    public ItalianModel getItalianPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getItalianPlatesByRegion");
        Optional<ItalianEntity> italianRegion = italianRepository.findByRegion(region);

        Optional.ofNullable(italianRegion.stream().parallel().filter(italianEntity -> italianEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return ItalianModel.toModel(italianRegion);
    }

    @Cacheable(value = "italian_description", key = "#description")
    public List<ItalianModel> getItalianPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getItalianPlatesByDescription");
        List<ItalianEntity> italianEntityList = italianRepository.findByDescription(description);
        italianEntityList.stream().parallel().findAny().map(italianEntity -> italianEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return italianEntityList.stream().map(ItalianModel::toDescription).toList();
    }

    public Iterable<ItalianEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return italianRepository.findAll();
    }
}
