package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.TurkeyEntity;

public class TurkeyModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TurkeyModel toModel(TurkeyEntity entity) {
        TurkeyModel model = new TurkeyModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
