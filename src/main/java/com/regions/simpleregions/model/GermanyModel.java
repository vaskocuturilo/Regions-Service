package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.GermanyEntity;
import lombok.Data;

@Data
public class GermanyModel {
    private String region;
    private String description;

    public static GermanyModel toModelRegion(GermanyEntity entity) {
        GermanyModel model = new GermanyModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }

    public static GermanyModel toModelDescription(GermanyEntity entity) {
        GermanyModel model = new GermanyModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
