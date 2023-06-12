package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.PolandDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class PolandDiplomaticModel {

    private String description;
    private String region;

    public static PolandDiplomaticModel toModel(Optional<PolandDiplomaticEntity> entity) {
        PolandDiplomaticModel model = new PolandDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static PolandDiplomaticModel toDescription(PolandDiplomaticEntity entity) {
        PolandDiplomaticModel model = new PolandDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
