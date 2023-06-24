package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.PolandDiplomaticEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.PolandDiplomaticDescriptionModel;
import com.regions.simpleRegions.model.PolandDiplomaticModel;
import com.regions.simpleRegions.respository.PolandDiplomaticRepo;
import com.regions.simpleRegions.util.DestinationCodePolandDiplomatic;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.regions.simpleRegions.util.DestinationCodePolandDiplomatic.*;

@Data
@Service
public class PolandDiplomaticService {

    private final PolandDiplomaticRepo polandDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public PolandDiplomaticModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<PolandDiplomaticEntity> polandDiplomaticRegion = polandDiplomaticRepo.findByRegion(getFirstThreeSymbols(region));

        polandDiplomaticRegion.stream().filter(polandDiplomaticEntity -> polandDiplomaticEntity.getRegion().equalsIgnoreCase(getFirstThreeSymbols(region))).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, getFirstThreeSymbols(region)));

            return regionNotFoundException;
        });
        return PolandDiplomaticModel.toModel(polandDiplomaticRegion, analyzingDestinationCode(region));
    }

    public List<PolandDiplomaticDescriptionModel> getByDescription(final String description) throws RegionNotFoundException {
        List<PolandDiplomaticEntity> polandEntityList = polandDiplomaticRepo.findByDescription(description);
        polandEntityList.stream().findAny().map(polandDiplomaticEntity -> polandDiplomaticEntity
                .getDescription()
                .equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return polandEntityList.stream().map(PolandDiplomaticDescriptionModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<PolandDiplomaticEntity> getAllRegions() {
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
