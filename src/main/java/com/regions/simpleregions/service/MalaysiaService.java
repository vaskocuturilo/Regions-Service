package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MalaysiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MalaysiaModel;
import com.regions.simpleregions.respository.MalaysiaRepository;
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
public class MalaysiaService {

    private final MalaysiaRepository malaysiaRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "moldova_region", key = "#region")
    public MalaysiaModel getMalaysiaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getMoldovaPlatesByRegion");
        Optional<MalaysiaEntity> malaysiaRegion = malaysiaRepository.findByRegion(region);

        Optional.ofNullable(malaysiaRegion.stream().parallel().filter(malaysiaEntity -> malaysiaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->

                new RegionNotFoundException(String.format(regionNotFound, region))));

        return MalaysiaModel.toModelByRegion(malaysiaRegion);
    }

    @Cacheable(value = "moldova_description", key = "#description")
    public List<MalaysiaModel> getMalaysiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getMoldovaPlatesByDescription");
        List<MalaysiaEntity> malaysiaEntityList = malaysiaRepository.findByDescription(description);

        malaysiaEntityList.stream().parallel().map(malaysiaEntity -> malaysiaEntity.getDescription().equalsIgnoreCase(description)).findAny().orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return malaysiaEntityList.stream().map(MalaysiaModel::toModelByDescription).toList();
    }

    public Iterable<MalaysiaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return malaysiaRepository.findAll();
    }
}
