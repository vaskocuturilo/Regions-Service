package com.regions.simpleregions.util;

import lombok.experimental.UtilityClass;

import static com.regions.simpleregions.util.DestinationCodePolandDiplomatic.*;
import static com.regions.simpleregions.util.Utils.getLastThreeSymbols;

@UtilityClass
public class DestinationCode {
    public static String getDestinationCode(String destinationCode) {
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
                throw new IllegalStateException(String.format("You destinationCode = %s is incorrect", destinationCode));
        }
        return destinationCode;
    }

}
