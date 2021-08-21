package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.MoldovaEntity;

public class MoldovaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static MoldovaModel toModel(MoldovaEntity entity) {
        MoldovaModel model = new MoldovaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
