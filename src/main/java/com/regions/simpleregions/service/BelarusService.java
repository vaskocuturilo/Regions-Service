package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BelarusEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BelarusModel;
import com.regions.simpleregions.respository.BelarusRepository;
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
public class BelarusService {

    private final BelarusRepository belarusRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "belarus_region", key = "#region")
    public BelarusModel getBelarusPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getBelarusPlatesByRegion");
        Optional<BelarusEntity> belarusRegion = belarusRepository.findByRegion(region);

        Optional.ofNullable(belarusRegion.stream().parallel().filter(belarusEntity -> belarusEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return BelarusModel.toModel(belarusRegion);
    }

    @Cacheable(value = "belarus_description", key = "#description")
    public List<BelarusModel> getBelarusPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getBelarusPlatesByDescription");
        List<BelarusEntity> belarusEntityList = belarusRepository.findByDescription(description);

        belarusEntityList.stream().parallel().findAny().map(belarusEntity -> belarusEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return belarusEntityList.stream().map(BelarusModel::toDescription).toList();
    }

    public Iterable<BelarusEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return belarusRepository.findAll();
    }
}
