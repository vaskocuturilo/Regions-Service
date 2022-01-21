package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.UzbekistanEntity;

public class UzbekistanModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static UzbekistanModel toModel(UzbekistanEntity entity) {
        UzbekistanModel model = new UzbekistanModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
