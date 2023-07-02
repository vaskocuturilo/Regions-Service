package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.LithuaniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class LithuaniaModel {
    private String description;

    private String region;

    public static LithuaniaModel toModelByRegion(Optional<LithuaniaEntity> entity) {
        LithuaniaModel model = new LithuaniaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static LithuaniaModel toModelByDescription(LithuaniaEntity entity) {
        LithuaniaModel model = new LithuaniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
