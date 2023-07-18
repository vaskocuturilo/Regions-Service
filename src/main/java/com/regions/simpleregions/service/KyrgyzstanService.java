package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.KyrgyzstanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.KyrgyzstanModel;
import com.regions.simpleregions.respository.KyrgyzstanRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Data
@Service
public class KyrgyzstanService {

    private final KyrgyzstanRepo kyrgyzstanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KyrgyzstanModel getKyrgyzstanPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getKyrgyzstanPlatesByRegion");
        Optional<KyrgyzstanEntity> kyrgyzstanRegion = kyrgyzstanRepo.findByRegion(region);

        kyrgyzstanRegion.stream().filter(kyrgyzstanEntity -> kyrgyzstanEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return KyrgyzstanModel.toModelByRegion(kyrgyzstanRegion);
    }

    public List<KyrgyzstanModel> getKyrgyzstanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getKyrgyzstanPlatesByDescription");
        List<KyrgyzstanEntity> kyrgyzstanEntityList = kyrgyzstanRepo.findByDescription(description);

        kyrgyzstanEntityList.stream().findAny().map(kyrgyzstanEntity -> kyrgyzstanEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return kyrgyzstanEntityList.stream().map(KyrgyzstanModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<KyrgyzstanEntity> getAllRegions() {
        log.info("Start method getKyrgyzstanPlatesByDescription");
        return kyrgyzstanRepo.findAll();
    }
}
