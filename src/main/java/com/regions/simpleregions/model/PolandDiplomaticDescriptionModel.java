package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import lombok.Data;

@Data
public class PolandDiplomaticDescriptionModel {

    private String description;
    private String region;

    public static PolandDiplomaticDescriptionModel toDescription(PolandDiplomaticEntity entity) {
        PolandDiplomaticDescriptionModel model = new PolandDiplomaticDescriptionModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
