package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BelarusEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class BelarusModel {

    private String description;

    private String region;

    public static BelarusModel toModel(Optional<BelarusEntity> entity) {
        BelarusModel model = new BelarusModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static BelarusModel toDescription(BelarusEntity entity) {
        BelarusModel model = new BelarusModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
