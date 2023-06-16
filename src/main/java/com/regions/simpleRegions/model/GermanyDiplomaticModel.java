package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.GermanyDiplomaticEntity;
import com.regions.simpleRegions.entity.GermanyEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class GermanyDiplomaticModel {
    private String region;
    private String description;

    public static GermanyDiplomaticModel toModelRegion(Optional<GermanyDiplomaticEntity> entity) {
        GermanyDiplomaticModel model = new GermanyDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static GermanyDiplomaticModel toModelDescription(GermanyDiplomaticEntity entity) {
        GermanyDiplomaticModel model = new GermanyDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
