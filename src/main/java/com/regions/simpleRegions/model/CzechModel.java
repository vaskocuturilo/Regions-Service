package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.CzechEntity;

public class CzechModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CzechModel toModel(CzechEntity entity) {
        CzechModel model = new CzechModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
