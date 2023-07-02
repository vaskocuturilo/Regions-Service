package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.BritishAgeEntity;
import com.regions.simpleregions.entity.BritishEntity;
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
