package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.AustriaEntity;

public class AustriaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static AustriaModel toModel(AustriaEntity entity) {
        AustriaModel model = new AustriaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
