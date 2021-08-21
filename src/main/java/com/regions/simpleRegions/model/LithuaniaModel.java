package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.LithuaniaEntity;

public class LithuaniaModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static LithuaniaModel toModel(LithuaniaEntity entity) {
        LithuaniaModel model = new LithuaniaModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
