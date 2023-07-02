package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.MoldovaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class MoldovaModel {

    private String description;

    private String region;

    public static MoldovaModel toModelByRegion(Optional<MoldovaEntity> entity) {
        MoldovaModel model = new MoldovaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static MoldovaModel toModelByDescription(MoldovaEntity entity) {
        MoldovaModel model = new MoldovaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
