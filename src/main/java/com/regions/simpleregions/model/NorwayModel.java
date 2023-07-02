package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.NorwayEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class NorwayModel {
    private String description;

    private String region;

    public static NorwayModel toModelByRegion(Optional<NorwayEntity> entity) {
        NorwayModel model = new NorwayModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static NorwayModel toModelByDescription(NorwayEntity entity) {
        NorwayModel model = new NorwayModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
