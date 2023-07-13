package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.SwedenDiplomaticEntity;
import com.regions.simpleregions.entity.SwedenEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class SwedenDiplomaticModel {

    private String description;

    private String region;

    public static SwedenDiplomaticModel toModelByRegion(Optional<SwedenDiplomaticEntity> entity) {
        SwedenDiplomaticModel model = new SwedenDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static SwedenDiplomaticModel toModelByDescription(SwedenDiplomaticEntity entity) {
        SwedenDiplomaticModel model = new SwedenDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
