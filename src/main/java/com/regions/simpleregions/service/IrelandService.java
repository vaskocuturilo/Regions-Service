package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.IrelandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.IrelandModel;
import com.regions.simpleregions.respository.IrelandRepository;
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
public class IrelandService {
    private final IrelandRepository irelandRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "ireland_region", key = "#region")
    public IrelandModel getPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getPlatesByRegion");
        Optional<IrelandEntity> irelandRegion = irelandRepository.findByRegion(region);

        Optional.ofNullable(irelandRegion.stream().parallel().filter(irelandEntity -> irelandEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return IrelandModel.toModelByRegion(irelandRegion);
    }

    @Cacheable(value = "ireland_description", key = "#description")
    public List<IrelandModel> getPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getPlatesByDescription");
        List<IrelandEntity> irelandEntityList = irelandRepository.findByDescription(description);

        irelandEntityList.stream().parallel().findAny().map(irelandEntity -> irelandEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return irelandEntityList.stream().map(IrelandModel::toModelByDescription).toList();
    }

    public Iterable<IrelandEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return irelandRepository.findAll();
    }
}
