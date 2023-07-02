package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SwedenEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SwedenModel {

    private String description;

    private String region;

    public static SwedenModel toModelByRegion(Optional<SwedenEntity> entity) {
        SwedenModel model = new SwedenModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static SwedenModel toModelByDescription(SwedenEntity entity) {
        SwedenModel model = new SwedenModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
