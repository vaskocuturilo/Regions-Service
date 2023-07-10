package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.ItalianDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class ItalianDiplomaticModel {

    private String description;

    private String region;

    public static ItalianDiplomaticModel toModel(Optional<ItalianDiplomaticEntity> entity) {
        ItalianDiplomaticModel model = new ItalianDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static ItalianDiplomaticModel toDescription(ItalianDiplomaticEntity entity) {
        ItalianDiplomaticModel model = new ItalianDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
