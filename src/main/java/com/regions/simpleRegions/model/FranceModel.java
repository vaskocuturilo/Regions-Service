package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.FranceEntity;

import java.util.Optional;

public class FranceModel {

    private String description;
    private String region;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

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
