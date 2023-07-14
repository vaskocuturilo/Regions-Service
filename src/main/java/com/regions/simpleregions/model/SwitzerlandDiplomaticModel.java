package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SwitzerlandDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SwitzerlandDiplomaticModel {

    private String description;

    private String region;

    public static SwitzerlandDiplomaticModel toModelByRegion(Optional<SwitzerlandDiplomaticEntity> entity) {
        SwitzerlandDiplomaticModel model = new SwitzerlandDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static SwitzerlandDiplomaticModel toModelByDescription(SwitzerlandDiplomaticEntity entity) {
        SwitzerlandDiplomaticModel model = new SwitzerlandDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
