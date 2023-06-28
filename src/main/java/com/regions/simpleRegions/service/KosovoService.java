package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.KosovoEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.KosovoModel;
import com.regions.simpleRegions.respository.KosovoRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class KosovoService {

    private final KosovoRepo kosovoRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public KosovoModel getKosovoPlatesByRegion(String region) throws RegionNotFoundException {
        Optional<KosovoEntity> kosovoRegion = kosovoRepo.findByRegion(region);

        kosovoRegion.stream().filter(kosovoEntity -> kosovoEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });

        return KosovoModel.toModelByRegion(kosovoRegion);
    }

    public List<KosovoModel> getKosovoPlatesByDescription(String description) throws RegionNotFoundException {
        List<KosovoEntity> kosovoEntityList = kosovoRepo.findByDescription(description);

        kosovoEntityList.stream().findAny().map(kosovoEntity -> kosovoEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return kosovoEntityList.stream().map(KosovoModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<KosovoEntity> getAllRegions() {
        return kosovoRepo.findAll();
    }
}
