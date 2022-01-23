package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.SwedenEntity;

public class SwedenModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SwedenModel toModel(SwedenEntity entity) {
        SwedenModel model = new SwedenModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
