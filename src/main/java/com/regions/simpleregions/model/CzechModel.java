package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.CzechEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class CzechModel {
    private String description;
    private String region;

    public static CzechModel toModelRegion(Optional<CzechEntity> entity) {
        CzechModel model = new CzechModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static CzechModel toModelDescription(CzechEntity entity) {
        CzechModel model = new CzechModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
