package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.NorwayDiplomaticEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.NorwayDiplomaticModel;
import com.regions.simpleregions.respository.NorwayDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class NorwayDiplomaticService {

    private final NorwayDiplomaticRepo norwayDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public NorwayDiplomaticModel getNorwayDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<NorwayDiplomaticEntity> norwayRegion = norwayDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(norwayRegion
                .stream()
                .filter(norwayEntity -> norwayEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return NorwayDiplomaticModel.toModelByRegion(norwayRegion);
    }

    public List<NorwayDiplomaticModel> getNorwayDiplomaticPlatesByDescription(final String description) throws RegionNotFoundException {
        List<NorwayDiplomaticEntity> norwayEntityList = norwayDiplomaticRepo.findByDescription(description);

        norwayEntityList
                .stream()
                .map(norwayEntity -> norwayEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new RegionNotFoundException(String.format(descriptionNotFound, description)));

        return norwayEntityList.stream().map(NorwayDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<NorwayDiplomaticEntity> getAllNorwayDiplomaticRegions() {
        return norwayDiplomaticRepo.findAll();
    }
}
