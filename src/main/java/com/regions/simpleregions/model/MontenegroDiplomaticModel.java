package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class MontenegroDiplomaticModel {

    private String description;

    private String region;

    public static MontenegroDiplomaticModel toModelByRegion(Optional<MontenegroDiplomaticEntity> entity) {
        MontenegroDiplomaticModel model = new MontenegroDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static MontenegroDiplomaticModel toModelByDescription(MontenegroDiplomaticEntity entity) {
        MontenegroDiplomaticModel model = new MontenegroDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
