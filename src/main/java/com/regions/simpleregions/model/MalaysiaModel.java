package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.MalaysiaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class MalaysiaModel {

    private String description;

    private String region;

    public static MalaysiaModel toModelByRegion(Optional<MalaysiaEntity> entity) {
        MalaysiaModel model = new MalaysiaModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static MalaysiaModel toModelByDescription(MalaysiaEntity entity) {
        MalaysiaModel model = new MalaysiaModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
