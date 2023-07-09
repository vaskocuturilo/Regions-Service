package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.FranceDiplomaticEntity;
import com.regions.simpleregions.entity.FranceEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class FranceDiplomaticModel {
    private String description;
    private String region;

    public static FranceDiplomaticModel toModel(Optional<FranceDiplomaticEntity> entity) {
        FranceDiplomaticModel model = new FranceDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static FranceDiplomaticModel toModelDescription(FranceDiplomaticEntity entity) {
        FranceDiplomaticModel model = new FranceDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }
}
