package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.LithuaniaDiplomaticEntity;
import com.regions.simpleregions.entity.LithuaniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class LithuaniaDiplomaticModel {
    private String description;

    private String region;

    public static LithuaniaDiplomaticModel toModelByRegion(Optional<LithuaniaDiplomaticEntity> entity) {
        LithuaniaDiplomaticModel model = new LithuaniaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static LithuaniaDiplomaticModel toModelByDescription(LithuaniaDiplomaticEntity entity) {
        LithuaniaDiplomaticModel model = new LithuaniaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
