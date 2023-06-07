package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import com.regions.simpleRegions.entity.BritishEntity;
import lombok.Data;

@Data
public class BritishRegionModel {

    private String description;
    private String region;
    private String date;

    private String code;

    public static BritishRegionModel toModelRegion(BritishEntity city, BritishAgeEntity code) {
        BritishRegionModel britishRegionModel = new BritishRegionModel();

        britishRegionModel.setDescription(city.getDescription());
        britishRegionModel.setCode(code.getCode());
        britishRegionModel.setDate(code.getDate());
        britishRegionModel.setRegion(city.getRegion());

        return britishRegionModel;
    }
}
