package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BelarusEntity;
import com.regions.simpleRegions.entity.UkraineEntity;

public class BelarusModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static BelarusModel toModel(BelarusEntity entity) {
        BelarusModel model = new BelarusModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
