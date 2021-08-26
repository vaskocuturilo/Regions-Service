package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.SlovakiaEntity;

public class SlovakiaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SlovakiaModel toModel(SlovakiaEntity entity) {
        SlovakiaModel model = new SlovakiaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
