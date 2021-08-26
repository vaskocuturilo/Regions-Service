package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.GermanEntity;

public class GermanModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static GermanModel toModel(GermanEntity entity) {
        GermanModel model = new GermanModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
