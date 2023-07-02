package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SwitzerlandEntity;

public class SwitzerlandModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SwitzerlandModel toModel(SwitzerlandEntity entity) {
        SwitzerlandModel model = new SwitzerlandModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
