package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.FranceEntity;

public class FranceModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static FranceModel toModel(FranceEntity entity) {
        FranceModel model = new FranceModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
