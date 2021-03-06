package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.SloveniaEntity;

public class SloveniaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SloveniaModel toModel(SloveniaEntity entity) {
        SloveniaModel model = new SloveniaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
