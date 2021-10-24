package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.ArmeniaEntity;
import com.regions.simpleRegions.entity.AustriaEntity;

public class ArmeniaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArmeniaModel toModel(ArmeniaEntity entity) {
        ArmeniaModel model = new ArmeniaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
