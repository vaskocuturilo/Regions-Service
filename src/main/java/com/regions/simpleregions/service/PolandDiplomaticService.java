package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.PolandDiplomaticDescriptionModel;
import com.regions.simpleregions.model.PolandDiplomaticModel;
import com.regions.simpleregions.respository.PolandDiplomaticRepo;
import com.regions.simpleregions.util.DestinationCodePolandDiplomatic;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.regions.simpleregions.util.DestinationCodePolandDiplomatic.*;

@Log4j2
@Data
@Service
public class PolandDiplomaticService {

    private final PolandDiplomaticRepo polandDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public PolandDiplomaticModel getPolandPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getPolandPlatesByRegion");
        Optional<PolandDiplomaticEntity> polandDiplomaticRegion = polandDiplomaticRepo.findByRegion(getFirstThreeSymbols(region));

        polandDiplomaticRegion.stream().filter(polandDiplomaticEntity -> polandDiplomaticEntity.getRegion().equalsIgnoreCase(getFirstThreeSymbols(region))).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, getFirstThreeSymbols(region))));

        return PolandDiplomaticModel.toModel(polandDiplomaticRegion, analyzingDestinationCode(region));
    }

    public List<PolandDiplomaticDescriptionModel> getPolandRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getPolandRegionByDescription");
        List<PolandDiplomaticEntity> polandEntityList = polandDiplomaticRepo.findByDescription(description);
        polandEntityList.stream().findAny().map(polandDiplomaticEntity -> polandDiplomaticEntity
                .getDescription()
                .equalsIgnoreCase(description)).orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return polandEntityList.stream().map(PolandDiplomaticDescriptionModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<PolandDiplomaticEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return polandDiplomaticRepo.findAll();
    }

    private String getFirstThreeSymbols(String text) {
        return text.length() < 3 ? text : text.substring(0, 3);
    }

    private String getLastThreeSymbols(String text) {
        return text.substring(Math.max(text.length() - 3, 0));
    }

    private String analyzingDestinationCode(String destinationCode) {
        Integer number = Integer.parseInt(getLastThreeSymbols(destinationCode));
        switch (DestinationCodePolandDiplomatic.from(number)) {
            case PRIVATE_VEHICLES:
                destinationCode = PRIVATE_VEHICLES.toString();
                break;

            case PRIVATE_VEHICLE_MILITARY:
                destinationCode = PRIVATE_VEHICLE_MILITARY.toString();
                break;

            case PRIVATE_VEHICLE_NON_DIPLOMATIC:
                destinationCode = PRIVATE_VEHICLE_NON_DIPLOMATIC.toString();
                break;

            case OFFICIAL_VEHICLES_AMBASSADOR:
                destinationCode = OFFICIAL_VEHICLES_AMBASSADOR.toString();
                break;

            case EMBASSY_VEHICLES:
                destinationCode = EMBASSY_VEHICLES.toString();
                break;

            case PRIVATE_VEHICLE_DIPLOMATIC_STAFF_CONSULATE_GENERAL:
                destinationCode = PRIVATE_VEHICLE_DIPLOMATIC_STAFF_CONSULATE_GENERAL.toString();
                break;

            case PRIVATE_VEHICLE_NON_DIPLOMATIC_STAFF_CONSULATE_GENERAL:
                destinationCode = PRIVATE_VEHICLE_NON_DIPLOMATIC_STAFF_CONSULATE_GENERAL.toString();
                break;

            case CONSUL_GENERAL_OFFICIAL_VEHICLE:
                destinationCode = CONSUL_GENERAL_OFFICIAL_VEHICLE.toString();
                break;

            case CONSULATE_GENERAL_SERVICE_VEHICLES:
                destinationCode = CONSULATE_GENERAL_SERVICE_VEHICLES.toString();
                break;

            default:
                throw new IllegalStateException("You number is incorrect");
        }
        return destinationCode;
    }
}
