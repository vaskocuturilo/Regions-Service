package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.BulgariaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class BulgariaModel {

    private String description;
    private String region;

    public String getDescription() {
        return description;
    }

    public static BulgariaModel toModelRegion(Optional<BulgariaEntity> entity) {
        BulgariaModel model = new BulgariaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static BulgariaModel toModelDescription(BulgariaEntity entity) {
        BulgariaModel model = new BulgariaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
