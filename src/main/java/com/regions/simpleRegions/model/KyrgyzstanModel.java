package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.KyrgyzstanEntity;

public class KyrgyzstanModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static KyrgyzstanModel toModel(KyrgyzstanEntity entity) {
        KyrgyzstanModel model = new KyrgyzstanModel();
        model.setDescription(entity.getDescription());

        return model;
    }
}
