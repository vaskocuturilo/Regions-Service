package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BulgariaEntity;

public class BulgariaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static BulgariaModel toModel(BulgariaEntity entity) {
        BulgariaModel model = new BulgariaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
