package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SloveniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SloveniaModel {

    private String description;

    private String region;

    public static SloveniaModel toModelByRegion(Optional<SloveniaEntity> entity) {
        SloveniaModel model = new SloveniaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static SloveniaModel toModelByDescription(SloveniaEntity entity) {
        SloveniaModel model = new SloveniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
