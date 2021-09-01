package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.KosovoEntity;

public class KosovoModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static KosovoModel toModel(KosovoEntity entity) {
        KosovoModel model = new KosovoModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
