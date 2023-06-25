package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.IrelandEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.IrelandModel;
import com.regions.simpleRegions.respository.IrelandRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class IrelandService {
    private final IrelandRepo irelandRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public IrelandModel getPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<IrelandEntity> irelandRegion = irelandRepo.findByRegion(region);

        irelandRegion.stream().filter(irelandEntity -> irelandEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));
            return regionNotFoundException;
        });

        return IrelandModel.toModelByRegion(irelandRegion);
    }

    public List<IrelandModel> getPlatesByDescription(final String description) throws RegionNotFoundException {
        List<IrelandEntity> irelandEntityList = irelandRepo.findByDescription(description);

        irelandEntityList.stream().findAny().map(irelandEntity -> irelandEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return irelandEntityList.stream().map(IrelandModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<IrelandEntity> getAllRegions() {
        return irelandRepo.findAll();
    }
}
