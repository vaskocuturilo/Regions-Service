package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.KyrgyzstanDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class KyrgyzstanDiplomaticModel {

    private String description;

    private String region;

    public static KyrgyzstanDiplomaticModel toModelByRegion(Optional<KyrgyzstanDiplomaticEntity> entity) {
        KyrgyzstanDiplomaticModel model = new KyrgyzstanDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static KyrgyzstanDiplomaticModel toModelByDescription(KyrgyzstanDiplomaticEntity entity) {
        KyrgyzstanDiplomaticModel model = new KyrgyzstanDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
