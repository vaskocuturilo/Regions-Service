package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SwitzerlandModel {

    private String description;

    private String region;

    public static SwitzerlandModel toModelByRegion(Optional<SwitzerlandEntity> entity) {
        SwitzerlandModel model = new SwitzerlandModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static SwitzerlandModel toModelByDescription(SwitzerlandEntity entity) {
        SwitzerlandModel model = new SwitzerlandModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
