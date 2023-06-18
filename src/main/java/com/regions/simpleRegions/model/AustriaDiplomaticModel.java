package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.AustriaDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class AustriaDiplomaticModel {

    private String description;
    private String region;

    public static AustriaDiplomaticModel toModelRegion(Optional<AustriaDiplomaticEntity> entity) {
        AustriaDiplomaticModel model = new AustriaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static AustriaDiplomaticModel toModelDescription(AustriaDiplomaticEntity entity) {
        AustriaDiplomaticModel model = new AustriaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
