package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.ArmeniaEntity;

public class ArmeniaModel {
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

    public static ArmeniaModel toModel(ArmeniaEntity entity) {
        ArmeniaModel model = new ArmeniaModel();
        model.setDescription(entity.getDescription());

        return model;
    }

    public static ArmeniaModel toModelDescription(ArmeniaEntity entity) {
        ArmeniaModel model = new ArmeniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
