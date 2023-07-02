package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.RomaniaEntity;

public class RomaniaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static RomaniaModel toModel(RomaniaEntity entity) {
        RomaniaModel model = new RomaniaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
