package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import com.regions.simpleRegions.entity.BritishEntity;

public class BritishModel {

    private String description;
    private String region;
    private String date;

    private String code;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static BritishModel toModelRegion(BritishEntity city, BritishAgeEntity code) {
        BritishModel britishModel = new BritishModel();

        britishModel.setDescription(city.getDescription());
        britishModel.setCode(code.getCode());
        britishModel.setDate(code.getDate());
        britishModel.setRegion(city.getRegion());

        return britishModel;
    }

    public static BritishModel toModelDescription(BritishEntity britishEntity) {
        BritishModel model = new BritishModel();
        model.setDescription(britishEntity.getDescription());
        model.setRegion(britishEntity.getRegion());
        model.setDate(britishEntity.getRegion());
        model.setCode(britishEntity.getDescription());

        return model;
    }
}
