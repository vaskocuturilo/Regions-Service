package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.RomaniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.RomaniaModel;
import com.regions.simpleregions.respository.RomaniaRepo;
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
public class RomaniaService {

    private final RomaniaRepo romaniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "romania_region", key = "#region")
    public RomaniaModel getRomaniaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getRomaniaPlatesByRegion");
        Optional<RomaniaEntity> romaniaRegion = romaniaRepo.findByRegion(region);

        Optional.ofNullable(romaniaRegion
                .stream().parallel()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return RomaniaModel.toModelByRegion(romaniaRegion);
    }

    @Cacheable(value = "romania_description", key = "#description")
    public List<RomaniaModel> getRomaniaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getRomaniaPlatesByDescription");
        List<RomaniaEntity> romaniaEntityList = romaniaRepo.findByDescription(description);

        romaniaEntityList.stream().parallel().map(romaniaEntity -> romaniaEntity.getDescription().equalsIgnoreCase(description)).findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));


        return romaniaEntityList.stream().map(RomaniaModel::toModelByDescription).toList();
    }

    public Iterable<RomaniaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return romaniaRepo.findAll();
    }
}
