package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.RussiaDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class RussiaDiplomaticModel {
    private String description;
    private String region;

    public static RussiaDiplomaticModel toModelRegion(Optional<RussiaDiplomaticEntity> entity) {
        RussiaDiplomaticModel model = new RussiaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static RussiaDiplomaticModel toModelDescription(RussiaDiplomaticEntity entity) {
        RussiaDiplomaticModel model = new RussiaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());
        return model;
    }
}
