package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.RussiaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class RussiaModel {
    private String description;
    private String region;
    public static RussiaModel toModelRegion(Optional<RussiaEntity> entity) {
        RussiaModel model = new RussiaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static RussiaModel toModelDescription(RussiaEntity entity) {
        RussiaModel model = new RussiaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }
}
