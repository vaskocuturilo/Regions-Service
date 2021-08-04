package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.RussiaEntity;

public class RussiaModel {
    private String description;

    public static RussiaModel toModel(RussiaEntity entity) {
        RussiaModel model = new RussiaModel();
        model.setDescription(entity.getDescription());

        return model;
    }

    public RussiaModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
