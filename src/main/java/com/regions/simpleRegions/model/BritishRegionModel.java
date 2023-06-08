package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import com.regions.simpleRegions.entity.BritishEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class BritishRegionModel {

    private String description;
    private String region;
    private String date;

    private String code;

    public static BritishRegionModel toModelRegion(Optional<BritishEntity> city, Optional<BritishAgeEntity> code) {
        BritishRegionModel britishRegionModel = new BritishRegionModel();

        britishRegionModel.setDescription(city.get().getDescription());
        britishRegionModel.setCode(code.get().getCode());
        britishRegionModel.setDate(code.get().getDate());
        britishRegionModel.setRegion(city.get().getRegion());

        return britishRegionModel;
    }
}
