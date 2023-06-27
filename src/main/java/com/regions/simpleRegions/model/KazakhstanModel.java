package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.KazakhstanEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class KazakhstanModel {

    private String description;

    private String region;

    public static KazakhstanModel toModelRegion(Optional<KazakhstanEntity> entity) {
        KazakhstanModel model = new KazakhstanModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static KazakhstanModel toModelDescription(KazakhstanEntity entity) {
        KazakhstanModel model = new KazakhstanModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
