package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.entity.UkraineEntity;

public class UkraineModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static UkraineModel toModel(UkraineEntity entity) {
        UkraineModel model = new UkraineModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
