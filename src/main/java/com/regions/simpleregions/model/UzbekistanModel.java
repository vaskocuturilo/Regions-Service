package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.UzbekistanEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class UzbekistanModel {

    private String description;

    private String region;

    public static UzbekistanModel toModelByRegion(Optional<UzbekistanEntity> entity) {
        UzbekistanModel model = new UzbekistanModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static UzbekistanModel toModelByDescription(UzbekistanEntity entity) {
        UzbekistanModel model = new UzbekistanModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
