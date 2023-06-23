package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.EstoniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class EstoniaModel {

    private String description;

    private String region;

    public static EstoniaModel toModelByRegion(Optional<EstoniaEntity> entity) {
        EstoniaModel model = new EstoniaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static EstoniaModel toModelByDescription(EstoniaEntity entity) {
        EstoniaModel model = new EstoniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
