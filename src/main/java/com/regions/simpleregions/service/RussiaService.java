package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.RussiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.RussiaModel;
import com.regions.simpleregions.respository.RussiaRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@Data
public class RussiaService {

    private final RussiaRepo russiaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public RussiaModel getRussiaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getRussiaPlatesByRegion");
        Optional<RussiaEntity> russiaRegion = russiaRepo.findByRegion(region);

        Optional.ofNullable(russiaRegion.stream().parallel().filter(russiaEntity -> russiaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return RussiaModel.toModelRegion(russiaRegion);
    }

    public List<RussiaModel> getRussiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getRussiaPlatesByDescription");
        List<RussiaEntity> russiaEntityList = russiaRepo.findByDescription(description);

        russiaEntityList.stream().parallel().findAny().map(russiaEntity -> russiaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return russiaEntityList.stream().map(RussiaModel::toModelDescription).toList();
    }

    public Iterable<RussiaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return russiaRepo.findAll();
    }
}
