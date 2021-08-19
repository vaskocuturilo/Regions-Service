package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.PolandEntity;

public class PolandModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PolandModel toModel(PolandEntity entity) {
        PolandModel model = new PolandModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
