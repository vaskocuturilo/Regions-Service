package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.MontenegroEntity;

public class MontenegroModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static MontenegroModel toModel(MontenegroEntity entity) {
        MontenegroModel model = new MontenegroModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
