package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.IrelandEntity;

public class IrelandModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static IrelandModel toModel(IrelandEntity entity) {
        IrelandModel model = new IrelandModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
