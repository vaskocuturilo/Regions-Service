package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.UzbekistanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.UzbekistanModel;
import com.regions.simpleregions.respository.UzbekistanRepository;
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
public class UzbekistanService {
    private final UzbekistanRepository uzbekistanRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "uzbekistan_region", key = "#region")
    public UzbekistanModel getUzbekistanPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getUzbekistanPlatesByRegion");
        Optional<UzbekistanEntity> uzbekistanRegion = uzbekistanRepository.findByRegion(region);

        Optional.ofNullable(uzbekistanRegion
                .stream().parallel()
                .filter(uzbekistanEntity -> uzbekistanEntity.getRegion().equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return UzbekistanModel.toModelByRegion(uzbekistanRegion);
    }


    @Cacheable(value = "uzbekistan_description", key = "#description")
    public List<UzbekistanModel> getUzbekistanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getUzbekistanPlatesByDescription");
        List<UzbekistanEntity> uzbekistanEntityList = uzbekistanRepository.findByDescription(description);

        uzbekistanEntityList
                .stream().parallel()
                .map(uzbekistanEntity -> uzbekistanEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return uzbekistanEntityList.stream().map(UzbekistanModel::toModelByDescription).toList();
    }

    public Iterable<UzbekistanEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return uzbekistanRepository.findAll();
    }
}
