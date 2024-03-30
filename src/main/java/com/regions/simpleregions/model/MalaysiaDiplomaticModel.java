package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.MalaysiaDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class MalaysiaDiplomaticModel {

    private String description;

    private String region;

    public static MalaysiaDiplomaticModel toModelByRegion(Optional<MalaysiaDiplomaticEntity> entity) {
        MalaysiaDiplomaticModel model = new MalaysiaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static MalaysiaDiplomaticModel toModelByDescription(MalaysiaDiplomaticEntity entity) {
        MalaysiaDiplomaticModel model = new MalaysiaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
