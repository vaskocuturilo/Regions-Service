package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.GermanyEntity;

import java.util.Optional;

public class GermanyModel {
    private String region;
    private String description;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static GermanyModel toModelRegion(Optional<GermanyEntity> entity) {
        GermanyModel model = new GermanyModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static GermanyModel toModelDescription(GermanyEntity entity) {
        GermanyModel model = new GermanyModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
