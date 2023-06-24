package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.ArmeniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class ArmeniaModel {
    private String description;

    private String region;

    public static ArmeniaModel toModelRegion(Optional<ArmeniaEntity> entity) {
        ArmeniaModel model = new ArmeniaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static ArmeniaModel toModelDescription(ArmeniaEntity entity) {
        ArmeniaModel model = new ArmeniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
