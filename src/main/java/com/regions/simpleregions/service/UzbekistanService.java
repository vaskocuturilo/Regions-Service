package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.UzbekistanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.UzbekistanModel;
import com.regions.simpleregions.respository.UzbekistanRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UzbekistanService {
    private final UzbekistanRepo uzbekistanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public UzbekistanModel getUzbekistanPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<UzbekistanEntity> uzbekistanRegion = uzbekistanRepo.findByRegion(region);

        uzbekistanRegion
                .stream()
                .filter(uzbekistanEntity -> uzbekistanEntity.getRegion().equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return UzbekistanModel.toModelByRegion(uzbekistanRegion);
    }

    public List<UzbekistanModel> getUzbekistanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<UzbekistanEntity> uzbekistanEntityList = uzbekistanRepo.findByDescription(description);

        uzbekistanEntityList
                .stream()
                .map(uzbekistanEntity -> uzbekistanEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return uzbekistanEntityList.stream().map(UzbekistanModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<UzbekistanEntity> getAllRegions() {
        return uzbekistanRepo.findAll();
    }
}
