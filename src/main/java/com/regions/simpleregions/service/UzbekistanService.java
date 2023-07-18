package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.UzbekistanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.UzbekistanModel;
import com.regions.simpleregions.respository.UzbekistanRepo;
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
public class UzbekistanService {
    private final UzbekistanRepo uzbekistanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public UzbekistanModel getUzbekistanPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getUzbekistanPlatesByRegion");
        Optional<UzbekistanEntity> uzbekistanRegion = uzbekistanRepo.findByRegion(region);

        uzbekistanRegion
                .stream()
                .filter(uzbekistanEntity -> uzbekistanEntity.getRegion().equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return UzbekistanModel.toModelByRegion(uzbekistanRegion);
    }

    public List<UzbekistanModel> getUzbekistanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getUzbekistanPlatesByDescription");
        List<UzbekistanEntity> uzbekistanEntityList = uzbekistanRepo.findByDescription(description);

        uzbekistanEntityList
                .stream()
                .map(uzbekistanEntity -> uzbekistanEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return uzbekistanEntityList.stream().map(UzbekistanModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<UzbekistanEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return uzbekistanRepo.findAll();
    }
}
