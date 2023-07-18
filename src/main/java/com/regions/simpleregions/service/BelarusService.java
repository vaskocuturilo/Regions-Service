package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BelarusEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BelarusModel;
import com.regions.simpleregions.respository.BelarusRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@Data
public class BelarusService {

    private final BelarusRepo belarusRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public BelarusModel getBelarusPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getBelarusPlatesByRegion");
        Optional<BelarusEntity> belarusRegion = belarusRepo.findByRegion(region);
        belarusRegion.stream().filter(belarusEntity -> belarusEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return BelarusModel.toModel(belarusRegion);
    }

    public List<BelarusModel> getBelarusPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getBelarusPlatesByDescription");
        List<BelarusEntity> belarusEntityList = belarusRepo.findByDescription(description);

        belarusEntityList.stream().findAny().map(belarusEntity -> belarusEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return belarusEntityList.stream().map(BelarusModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<BelarusEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return belarusRepo.findAll();
    }
}
