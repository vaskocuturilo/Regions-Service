package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.GermanyEntity;

public class GermanModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static GermanModel toModel(GermanyEntity entity) {
        GermanModel model = new GermanModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
