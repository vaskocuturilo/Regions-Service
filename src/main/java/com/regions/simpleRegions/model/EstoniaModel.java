package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.EstoniaEntity;

public class EstoniaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static EstoniaModel toModel(EstoniaEntity entity) {
        EstoniaModel model = new EstoniaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
