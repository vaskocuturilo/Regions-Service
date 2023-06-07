package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BritishEntity;
import lombok.Data;

@Data
public class BritishDescriptionModel {

    private String description;
    private String region;

    public static BritishDescriptionModel toModelDescription(BritishEntity britishEntity) {
        BritishDescriptionModel model = new BritishDescriptionModel();
        model.setDescription(britishEntity.getDescription());
        model.setRegion(britishEntity.getRegion());

        return model;
    }
}
