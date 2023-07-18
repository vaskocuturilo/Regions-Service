package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.UkraineEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.UkraineModel;
import com.regions.simpleregions.respository.UkraineRepo;
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
public class UkraineService {

    private final UkraineRepo ukraineRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public UkraineModel getUkrainePlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getUkrainePlatesByRegion");
        Optional<UkraineEntity> ukraineRegion = ukraineRepo.findByRegion(region);
        ukraineRegion.stream().filter(ukraineEntity -> ukraineEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return UkraineModel.toModel(ukraineRegion);
    }

    public List<UkraineModel> getUkrainePlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getUkrainePlatesByDescription");
        List<UkraineEntity> ukraineEntityList = ukraineRepo.findByDescription(description);
        ukraineEntityList.stream().findAny().map(ukraineEntity -> ukraineEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return ukraineEntityList.stream().map(UkraineModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<UkraineEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return ukraineRepo.findAll();
    }
}
