package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SlovakiaEntity;

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
