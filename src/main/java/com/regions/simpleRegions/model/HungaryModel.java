package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.HungaryEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class HungaryModel {
    private String description;

    private String region;

    public static HungaryModel toModelByRegion(Optional<HungaryEntity> entity) {
        HungaryModel model = new HungaryModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static HungaryModel toModelByDescription(HungaryEntity entity) {
        HungaryModel model = new HungaryModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }
}
