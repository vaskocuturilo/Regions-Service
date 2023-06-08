package com.regions.simpleRegions.model;

import com.regions.simpleRegions.entity.UkraineEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class UkraineModel {

    private String description;
    private String region;

    public static UkraineModel toModel(Optional<UkraineEntity> entity) {
        UkraineModel model = new UkraineModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static UkraineModel toModelDescription(UkraineEntity ukraineEntity) {
        UkraineModel model = new UkraineModel();
        model.setDescription(ukraineEntity.getDescription());
        model.setRegion(ukraineEntity.getRegion());

        return model;
    }
}
