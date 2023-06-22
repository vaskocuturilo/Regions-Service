package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.CroatiaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class CroatiaModel {
    private String description;
    private String region;

    public static CroatiaModel toModelRegion(Optional<CroatiaEntity> entity) {
        CroatiaModel model = new CroatiaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static CroatiaModel toModelDescription(CroatiaEntity entity) {
        CroatiaModel model = new CroatiaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
