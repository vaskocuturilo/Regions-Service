package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.KosovoEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.KosovoModel;
import com.regions.simpleregions.respository.KosovoRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class KosovoService {

    private final KosovoRepo kosovoRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KosovoModel getKosovoPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getKosovoPlatesByRegion");
        Optional<KosovoEntity> kosovoRegion = kosovoRepo.findByRegion(region);

        kosovoRegion.stream().parallel().filter(kosovoEntity -> kosovoEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return KosovoModel.toModelByRegion(kosovoRegion);
    }

    public List<KosovoModel> getKosovoPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getKosovoPlatesByDescription");
        List<KosovoEntity> kosovoEntityList = kosovoRepo.findByDescription(description);

        kosovoEntityList.stream().parallel().findAny().map(kosovoEntity -> kosovoEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return kosovoEntityList.stream().map(KosovoModel::toModelByDescription).toList();
    }

    public Iterable<KosovoEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return kosovoRepo.findAll();
    }
}
