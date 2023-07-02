package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.MontenegroEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class MontenegroModel {

    private String description;

    private String region;

    public static MontenegroModel toModelByRegion(Optional<MontenegroEntity> entity) {
        MontenegroModel model = new MontenegroModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static MontenegroModel toModelByDescription(MontenegroEntity entity) {
        MontenegroModel model = new MontenegroModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
