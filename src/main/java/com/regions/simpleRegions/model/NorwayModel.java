package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.NorwayEntity;

public class NorwayModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static NorwayModel toModel(NorwayEntity entity) {
        NorwayModel model = new NorwayModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
