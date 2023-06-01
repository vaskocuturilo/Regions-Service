package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishEntity;

public class BritishModel {

    private String description;
    private String region;

    public String getDescription() {
        return description;
    }

    public String getRegion() {
        return region;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public static BritishModel toModelRegion(BritishEntity britishEntity) {
        BritishModel model = new BritishModel();
        model.setDescription(britishEntity.getDescription());
        model.setRegion(britishEntity.getRegion());

        return model;
    }

    public static BritishModel toModelDescription(BritishEntity britishEntity) {
        BritishModel model = new BritishModel();
        model.setDescription(britishEntity.getDescription());
        model.setRegion(britishEntity.getRegion());

        return model;
    }
}
