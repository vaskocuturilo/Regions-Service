package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.FranceEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class FranceModel {
    private String description;
    private String region;

    public static FranceModel toModel(Optional<FranceEntity> entity) {
        FranceModel model = new FranceModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static FranceModel toModelDescription(FranceEntity entity) {
        FranceModel model = new FranceModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }
}
