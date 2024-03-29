package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MontenegroEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MontenegroModel;
import com.regions.simpleregions.respository.MontenegroRepository;
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
public class MontenegroService {

    private final MontenegroRepository montenegroRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "montenegro_region", key = "#region")
    public MontenegroModel getMontenegroPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getMontenegroPlatesByRegion");
        Optional<MontenegroEntity> montenegroRegion = montenegroRepository.findByRegion(region);

        Optional.ofNullable(montenegroRegion.stream().parallel().filter(montenegroEntity -> montenegroEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return MontenegroModel.toModelByRegion(montenegroRegion);
    }

    @Cacheable(value = "montenegro_description", key = "#description")
    public List<MontenegroModel> getMontenegroPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getMontenegroPlatesByDescription");
        List<MontenegroEntity> montenegroEntityList = montenegroRepository.findByDescription(description);

        montenegroEntityList.stream().parallel().map(montenegroEntity -> montenegroEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return montenegroEntityList.stream().map(MontenegroModel::toModelByDescription).toList();
    }

    public Iterable<MontenegroEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return montenegroRepository.findAll();
    }
}
