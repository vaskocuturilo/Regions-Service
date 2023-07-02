package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.PolandEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class PolandModel {

    private String description;
    private String region;

    public static PolandModel toModel(Optional<PolandEntity> entity) {
        PolandModel model = new PolandModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static PolandModel toDescription(PolandEntity entity) {
        PolandModel model = new PolandModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
