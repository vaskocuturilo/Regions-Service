package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.NorthMacedoniaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class NorthMacedoniaModel {
    private String description;

    private String region;

    public static NorthMacedoniaModel toModelRegion(Optional<NorthMacedoniaEntity> entity) {
        NorthMacedoniaModel model = new NorthMacedoniaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());
        return model;
    }

    public static NorthMacedoniaModel toModelDescription(NorthMacedoniaEntity entity) {
        NorthMacedoniaModel model = new NorthMacedoniaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
