package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.KazakhstanEntity;

public class KazakhstanModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static KazakhstanModel toModel(KazakhstanEntity entity) {
        KazakhstanModel model = new KazakhstanModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
