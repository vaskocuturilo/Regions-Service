package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.ItalianEntity;
import lombok.Data;

@Data
public class ItalianModel {

    private String description;

    private String region;

    public static ItalianModel toModel(ItalianEntity entity) {
        ItalianModel model = new ItalianModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }

    public static ItalianModel toDescription(ItalianEntity entity) {
        ItalianModel model = new ItalianModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
