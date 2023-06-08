package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.RussiaEntity;

import java.util.Optional;

public class RussiaModel {
    private String description;
    private String region;

    public RussiaModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public static RussiaModel toModelDescription(RussiaEntity entity) {
        RussiaModel model = new RussiaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }

    public static RussiaModel toModelRegion(Optional<RussiaEntity> entity) {
        RussiaModel model = new RussiaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }
}
