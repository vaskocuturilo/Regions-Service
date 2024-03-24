package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SloveniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SloveniaModel;
import com.regions.simpleregions.respository.SloveniaRepository;
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
public class SloveniaService {

    private final SloveniaRepository sloveniaRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "slovenia_region", key = "#region")
    public SloveniaModel getSloveniaPlatesRegionByNumber(final String region) throws RegionNotFoundException {
        log.info("Start method getSloveniaPlatesRegionByNumber");
        Optional<SloveniaEntity> sloveniaRegion = sloveniaRepository.findByRegion(region);

        Optional.ofNullable(sloveniaRegion
                .stream().parallel()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SloveniaModel.toModelByRegion(sloveniaRegion);
    }

    @Cacheable(value = "slovenia_description", key = "#description")
    public List<SloveniaModel> getSloveniaRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getSloveniaRegionByDescription");
        List<SloveniaEntity> sloveniaEntityList = sloveniaRepository.findByDescription(description);

        sloveniaEntityList
                .stream().parallel()
                .map(sloveniaEntity -> sloveniaEntity.getDescription().equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return sloveniaEntityList.stream().map(SloveniaModel::toModelByDescription).toList();
    }

    public Iterable<SloveniaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return sloveniaRepository.findAll();
    }
}
