package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.GreeceEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class GreeceModel {
    private String description;
    private String region;

    public static GreeceModel toModelByRegion(Optional<GreeceEntity> entity) {
        GreeceModel model = new GreeceModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static GreeceModel toModelByDescription(GreeceEntity entity) {
        GreeceModel model = new GreeceModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }
}
