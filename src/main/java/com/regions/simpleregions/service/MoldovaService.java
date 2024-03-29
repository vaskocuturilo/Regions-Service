package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MoldovaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MoldovaModel;
import com.regions.simpleregions.respository.MoldovaRepository;
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
public class MoldovaService {

    private final MoldovaRepository moldovaRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "moldova_region", key = "#region")
    public MoldovaModel getMoldovaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getMoldovaPlatesByRegion");
        Optional<MoldovaEntity> moldovaRegion = moldovaRepository.findByRegion(region);

        Optional.ofNullable(moldovaRegion.stream().parallel().filter(moldovaEntity -> moldovaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->

                new RegionNotFoundException(String.format(regionNotFound, region))));

        return MoldovaModel.toModelByRegion(moldovaRegion);
    }

    @Cacheable(value = "moldova_description", key = "#description")
    public List<MoldovaModel> getMoldovaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getMoldovaPlatesByDescription");
        List<MoldovaEntity> moldovaEntityList = moldovaRepository.findByDescription(description);

        moldovaEntityList.stream().parallel().map(moldovaEntity -> moldovaEntity.getDescription().equalsIgnoreCase(description)).findAny().orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return moldovaEntityList.stream().map(MoldovaModel::toModelByDescription).toList();
    }

    public Iterable<MoldovaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return moldovaRepository.findAll();
    }
}
