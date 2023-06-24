package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AustriaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AustriaModel;
import com.regions.simpleRegions.respository.AustriaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class AustriaService {
    private final AustriaRepo austriaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public AustriaModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<AustriaEntity> austriaRegion = austriaRepo.findByRegion(region);

        austriaRegion.stream().filter(austriaEntity -> austriaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));
            return regionNotFoundException;
        });

        return AustriaModel.toModelRegion(austriaRegion);
    }

    public List<AustriaModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<AustriaEntity> austriaEntityList = austriaRepo.findByDescription(description);

        austriaEntityList.stream().findAny().map(austriaEntity -> austriaEntity.getDescription()).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return austriaEntityList.stream().map(AustriaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AustriaEntity> getAllRegions() {
        return austriaRepo.findAll();
    }
}
