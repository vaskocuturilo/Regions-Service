package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.KosovoEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class KosovoModel {

    private String description;

    private String region;

    public static KosovoModel toModelByRegion(Optional<KosovoEntity> entity) {
        KosovoModel model = new KosovoModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static KosovoModel toModelByDescription(KosovoEntity entity) {
        KosovoModel model = new KosovoModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
