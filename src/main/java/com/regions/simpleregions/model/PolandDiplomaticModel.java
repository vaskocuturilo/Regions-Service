package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class PolandDiplomaticModel {

    private String description;
    private String region;

    private String destinationCode;

    public static PolandDiplomaticModel toModel(Optional<PolandDiplomaticEntity> entity, String destinationCode) {
        PolandDiplomaticModel model = new PolandDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        model.setDestinationCode(destinationCode);

        return model;
    }
}
