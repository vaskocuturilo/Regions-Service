package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.CroatiaEntity;

public class CroatiaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CroatiaModel toModel(CroatiaEntity entity) {
        CroatiaModel model = new CroatiaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
