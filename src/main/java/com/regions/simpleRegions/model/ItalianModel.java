package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.ItalianEntity;

public class ItalianModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ItalianModel toModel(ItalianEntity entity) {
        ItalianModel model = new ItalianModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
