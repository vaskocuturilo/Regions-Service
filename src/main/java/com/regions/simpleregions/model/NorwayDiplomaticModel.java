package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.NorwayDiplomaticEntity;
import com.regions.simpleregions.entity.NorwayEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class NorwayDiplomaticModel {
    private String description;

    private String region;

    public static NorwayDiplomaticModel toModelByRegion(Optional<NorwayDiplomaticEntity> entity) {
        NorwayDiplomaticModel model = new NorwayDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static NorwayDiplomaticModel toModelByDescription(NorwayDiplomaticEntity entity) {
        NorwayDiplomaticModel model = new NorwayDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
