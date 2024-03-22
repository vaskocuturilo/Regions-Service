package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.PortugalDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class PortugalDiplomaticModel {

    private String description;

    private String region;

    public static PortugalDiplomaticModel toModelByRegion(Optional<PortugalDiplomaticEntity> entity) {
        PortugalDiplomaticModel model = new PortugalDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static PortugalDiplomaticModel toModelByDescription(PortugalDiplomaticEntity entity) {
        PortugalDiplomaticModel model = new PortugalDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
