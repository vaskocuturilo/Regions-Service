package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.IrelandEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class IrelandModel {
    private String description;

    private String region;

    public static IrelandModel toModelByRegion(Optional<IrelandEntity> entity) {
        IrelandModel model = new IrelandModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static IrelandModel toModelByDescription(IrelandEntity entity) {
        IrelandModel model = new IrelandModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
