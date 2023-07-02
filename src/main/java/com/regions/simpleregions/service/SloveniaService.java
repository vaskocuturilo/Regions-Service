package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SloveniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SloveniaModel;
import com.regions.simpleregions.respository.SloveniaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class SloveniaService {

    private final SloveniaRepo sloveniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SloveniaModel getSlovakiaPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<SloveniaEntity> sloveniaRegion = sloveniaRepo.findByRegion(region);

        sloveniaRegion
                .stream()
                .filter(sloveniaEntity -> sloveniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return SloveniaModel.toModelByRegion(sloveniaRegion);
    }

    public List<SloveniaModel> getSlovakiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<SloveniaEntity> sloveniaEntityList = sloveniaRepo.findByDescription(description);

        sloveniaEntityList
                .stream()
                .map(sloveniaEntity -> sloveniaEntity.getDescription().equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return sloveniaEntityList.stream().map(SloveniaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SloveniaEntity> getAllRegions() {
        return sloveniaRepo.findAll();
    }
}
