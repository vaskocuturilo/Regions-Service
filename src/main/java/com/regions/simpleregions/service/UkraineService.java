package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.UkraineEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.UkraineModel;
import com.regions.simpleregions.respository.UkraineRepository;
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
public class UkraineService {

    private final UkraineRepository ukraineRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "ukraine_region", key = "#region")
    public UkraineModel getUkrainePlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getUkrainePlatesByRegion");
        Optional<UkraineEntity> ukraineRegion = ukraineRepository.findByRegion(region);

        Optional.ofNullable(ukraineRegion.stream().parallel().filter(ukraineEntity -> ukraineEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return UkraineModel.toModel(ukraineRegion);
    }

    @Cacheable(value = "ukraine_description", key = "#description")
    public List<UkraineModel> getUkrainePlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getUkrainePlatesByDescription");
        List<UkraineEntity> ukraineEntityList = ukraineRepository.findByDescription(description);
        ukraineEntityList.stream().parallel().findAny().map(ukraineEntity -> ukraineEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return ukraineEntityList.stream().map(UkraineModel::toModelDescription).toList();
    }

    public Iterable<UkraineEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return ukraineRepository.findAll();
    }
}
