package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.KyrgyzstanEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.KyrgyzstanModel;
import com.regions.simpleregions.respository.KyrgyzstanRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class KyrgyzstanService {

    private final KyrgyzstanRepo kyrgyzstanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KyrgyzstanModel getKyrgyzstanPlatesByRegion(String region) throws RegionNotFoundException {
        Optional<KyrgyzstanEntity> kyrgyzstanRegion = kyrgyzstanRepo.findByRegion(region);

        kyrgyzstanRegion.stream().filter(kyrgyzstanEntity -> kyrgyzstanEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });

        return KyrgyzstanModel.toModelByRegion(kyrgyzstanRegion);
    }

    public List<KyrgyzstanModel> getKyrgyzstanPlatesByDescription(String description) throws RegionNotFoundException {
        List<KyrgyzstanEntity> kyrgyzstanEntityList = kyrgyzstanRepo.findByDescription(description);

        kyrgyzstanEntityList.stream().findAny().map(kyrgyzstanEntity -> kyrgyzstanEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return kyrgyzstanEntityList.stream().map(KyrgyzstanModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<KyrgyzstanEntity> getAllRegions() {
        return kyrgyzstanRepo.findAll();
    }
}
