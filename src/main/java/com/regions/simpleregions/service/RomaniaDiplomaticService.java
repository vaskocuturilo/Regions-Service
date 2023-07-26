package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.RomaniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.RomaniaDiplomaticModel;
import com.regions.simpleregions.respository.RomaniaDiplomaticRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class RomaniaDiplomaticService {

    private final RomaniaDiplomaticRepo romaniaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public RomaniaDiplomaticModel getRomaniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getRomaniaDiplomaticPlatesByRegion");
        Optional<RomaniaDiplomaticEntity> romaniaRegion = romaniaDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(romaniaRegion
                .stream().parallel()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return RomaniaDiplomaticModel.toModelByRegion(romaniaRegion);
    }

    public List<RomaniaDiplomaticModel> getRomaniaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getRomaniaDiplomaticPlatesByDescription");
        List<RomaniaDiplomaticEntity> romaniaEntityList = romaniaDiplomaticRepo.findByDescription(description);

        romaniaEntityList.stream().parallel().map(romaniaEntity -> romaniaEntity.getDescription().equalsIgnoreCase(description)).findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));


        return romaniaEntityList.stream().map(RomaniaDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<RomaniaDiplomaticEntity> getAllRomaniaDiplomaticRegions() {
        log.info("Start method getAllRomaniaDiplomaticRegions");
        return romaniaDiplomaticRepo.findAll();
    }
}
