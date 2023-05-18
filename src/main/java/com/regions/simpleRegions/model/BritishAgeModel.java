package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishAgeEntity;

public class BritishAgeModel {

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static BritishAgeModel toModel(BritishAgeEntity entity) {
        BritishAgeModel model = new BritishAgeModel();
        model.setDate(entity.getDate());

        return model;
    }
}
