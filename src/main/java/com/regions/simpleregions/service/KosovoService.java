package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.KosovoEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.KosovoModel;
import com.regions.simpleregions.respository.KosovoRepo;
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

    public KosovoModel getKosovoPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<KosovoEntity> kosovoRegion = kosovoRepo.findByRegion(region);

        kosovoRegion.stream().filter(kosovoEntity -> kosovoEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return KosovoModel.toModelByRegion(kosovoRegion);
    }

    public List<KosovoModel> getKosovoPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<KosovoEntity> kosovoEntityList = kosovoRepo.findByDescription(description);

        kosovoEntityList.stream().findAny().map(kosovoEntity -> kosovoEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return kosovoEntityList.stream().map(KosovoModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<KosovoEntity> getAllRegions() {
        return kosovoRepo.findAll();
    }
}
