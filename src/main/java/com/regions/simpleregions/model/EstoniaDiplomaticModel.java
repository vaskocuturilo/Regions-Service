package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.EstoniaDiplomaticEntity;
import com.regions.simpleregions.entity.EstoniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class EstoniaDiplomaticModel {

    private String description;

    private String region;

    public static EstoniaDiplomaticModel toModelByRegion(Optional<EstoniaDiplomaticEntity> entity) {
        EstoniaDiplomaticModel model = new EstoniaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static EstoniaDiplomaticModel toModelByDescription(EstoniaDiplomaticEntity entity) {
        EstoniaDiplomaticModel model = new EstoniaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
