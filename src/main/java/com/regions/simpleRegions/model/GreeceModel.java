package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.GreeceEntity;

public class GreeceModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static GreeceModel toModel(GreeceEntity entity) {
        GreeceModel model = new GreeceModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
