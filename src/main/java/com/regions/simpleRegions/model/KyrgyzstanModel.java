package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.KyrgyzstanEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class KyrgyzstanModel {

    private String description;

    private String region;

    public static KyrgyzstanModel toModelByRegion(Optional<KyrgyzstanEntity> entity) {
        KyrgyzstanModel model = new KyrgyzstanModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static KyrgyzstanModel toModelByDescription(KyrgyzstanEntity entity) {
        KyrgyzstanModel model = new KyrgyzstanModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
