package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.TurkeyEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class TurkeyModel {
    private String description;

    private String region;

    public static TurkeyModel toModelByRegion(Optional<TurkeyEntity> entity) {
        TurkeyModel model = new TurkeyModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static TurkeyModel toModelByDescription(TurkeyEntity entity) {
        TurkeyModel model = new TurkeyModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
