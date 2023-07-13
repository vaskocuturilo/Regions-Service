package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.RomaniaDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class RomaniaDiplomaticModel {

    private String description;

    private String region;

    public static RomaniaDiplomaticModel toModelByRegion(Optional<RomaniaDiplomaticEntity> entity) {
        RomaniaDiplomaticModel model = new RomaniaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static RomaniaDiplomaticModel toModelByDescription(RomaniaDiplomaticEntity entity) {
        RomaniaDiplomaticModel model = new RomaniaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
