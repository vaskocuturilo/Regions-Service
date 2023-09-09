package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SerbiaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SerbiaModel {
    private String description;

    private String region;

    public static SerbiaModel toModelRegion(Optional<SerbiaEntity> entity) {
        SerbiaModel model = new SerbiaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static SerbiaModel toModelDescription(SerbiaEntity entity) {
        SerbiaModel model = new SerbiaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
