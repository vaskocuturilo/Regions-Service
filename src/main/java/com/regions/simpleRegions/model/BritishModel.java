package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishEntity;

public class BritishModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static BritishModel toModel(BritishEntity entity) {
        BritishModel model = new BritishModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
