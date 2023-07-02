package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.RomaniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class RomaniaModel {

    private String description;

    private String region;

    public static RomaniaModel toModelByRegion(Optional<RomaniaEntity> entity) {
        RomaniaModel model = new RomaniaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static RomaniaModel toModelByDescription(RomaniaEntity entity) {
        RomaniaModel model = new RomaniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
