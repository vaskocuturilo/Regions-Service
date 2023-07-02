package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SlovakiaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SlovakiaModel {

    private String description;

    private String region;

    public static SlovakiaModel toModelByRegion(Optional<SlovakiaEntity> entity) {
        SlovakiaModel model = new SlovakiaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static SlovakiaModel toModelByDescription(SlovakiaEntity entity) {
        SlovakiaModel model = new SlovakiaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
