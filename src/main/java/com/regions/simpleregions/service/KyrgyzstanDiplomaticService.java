package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.KyrgyzstanDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.KyrgyzstanDiplomaticModel;
import com.regions.simpleregions.respository.KyrgyzstanDiplomaticRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class KyrgyzstanDiplomaticService {

    private final KyrgyzstanDiplomaticRepo kyrgyzstanDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KyrgyzstanDiplomaticModel getKyrgyzstanDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getKyrgyzstanDiplomaticPlatesByRegion");
        Optional<KyrgyzstanDiplomaticEntity> kyrgyzstanRegion = kyrgyzstanDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(kyrgyzstanRegion.stream().parallel().filter(kyrgyzstanEntity -> kyrgyzstanEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return KyrgyzstanDiplomaticModel.toModelByRegion(kyrgyzstanRegion);
    }

    public List<KyrgyzstanDiplomaticModel> getKyrgyzstanDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getKyrgyzstanDiplomaticPlatesByDescription");
        List<KyrgyzstanDiplomaticEntity> kyrgyzstanEntityList = kyrgyzstanDiplomaticRepo.findByDescription(description);

        kyrgyzstanEntityList.stream().parallel().findAny().map(kyrgyzstanEntity -> kyrgyzstanEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return kyrgyzstanEntityList.stream().map(KyrgyzstanDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<KyrgyzstanDiplomaticEntity> getAllKyrgyzstanDiplomaticRegions() {
        log.info("Start method getAllKyrgyzstanDiplomaticRegions");
        return kyrgyzstanDiplomaticRepo.findAll();
    }
}
