package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.HungaryEntity;

public class HungaryModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static HungaryModel toModel(HungaryEntity entity) {
        HungaryModel model = new HungaryModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
