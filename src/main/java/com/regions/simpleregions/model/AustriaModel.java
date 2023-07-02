package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.AustriaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class AustriaModel {

    private String description;
    private String region;

    public static AustriaModel toModelRegion(Optional<AustriaEntity> entity) {
        AustriaModel model = new AustriaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static AustriaModel toModelDescription(AustriaEntity entity) {
        AustriaModel model = new AustriaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
