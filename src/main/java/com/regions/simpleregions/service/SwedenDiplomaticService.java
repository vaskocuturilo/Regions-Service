package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwedenDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwedenDiplomaticModel;
import com.regions.simpleregions.respository.SwedenDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class SwedenDiplomaticService {

    private final SwedenDiplomaticRepo swedenDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SwedenDiplomaticModel getSwedenDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<SwedenDiplomaticEntity> swedenRegion = swedenDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(swedenRegion
                .stream()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwedenDiplomaticModel.toModelByRegion(swedenRegion);
    }

    public List<SwedenDiplomaticModel> getSwedenDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<SwedenDiplomaticEntity> swedenEntityList = swedenDiplomaticRepo.findByDescription(description);

        swedenEntityList
                .stream()
                .map(swedenEntity -> swedenEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return swedenEntityList.stream().map(SwedenDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SwedenDiplomaticEntity> getAllSwedenDiplomaticRegions() {
        return swedenDiplomaticRepo.findAll();
    }
}
