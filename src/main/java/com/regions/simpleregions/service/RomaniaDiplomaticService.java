package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.RomaniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.RomaniaDiplomaticModel;
import com.regions.simpleregions.respository.RomaniaDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class RomaniaDiplomaticService {

    private final RomaniaDiplomaticRepo romaniaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public RomaniaDiplomaticModel getRomaniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<RomaniaDiplomaticEntity> romaniaRegion = romaniaDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(romaniaRegion
                .stream()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return RomaniaDiplomaticModel.toModelByRegion(romaniaRegion);
    }

    public List<RomaniaDiplomaticModel> getRomaniaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<RomaniaDiplomaticEntity> romaniaEntityList = romaniaDiplomaticRepo.findByDescription(description);

        romaniaEntityList.stream().map(romaniaEntity -> romaniaEntity.getDescription().equalsIgnoreCase(description)).findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));


        return romaniaEntityList.stream().map(RomaniaDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<RomaniaDiplomaticEntity> getAllRomaniaDiplomaticRegions() {
        return romaniaDiplomaticRepo.findAll();
    }
}
