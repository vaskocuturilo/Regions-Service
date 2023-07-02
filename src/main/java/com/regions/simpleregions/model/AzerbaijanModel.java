package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.AzerbaijanEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class AzerbaijanModel {

    private String description;

    private String region;

    public static AzerbaijanModel toModel(Optional<AzerbaijanEntity> entity) {
        AzerbaijanModel model = new AzerbaijanModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static AzerbaijanModel toModelDescription(AzerbaijanEntity entity) {
        AzerbaijanModel model = new AzerbaijanModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
