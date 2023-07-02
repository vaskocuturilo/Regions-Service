package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.BritishEntity;
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
