package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.AzerbaijanEntity;

public class AzerbaijanModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static AzerbaijanModel toModel(AzerbaijanEntity entity) {
        AzerbaijanModel model = new AzerbaijanModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
