package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.CroatiaDiplomaticEntity;
import com.regions.simpleregions.entity.CroatiaEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class CroatiaDiplomaticModel {
    private String description;
    private String region;

    public static CroatiaDiplomaticModel toModelRegion(Optional<CroatiaDiplomaticEntity> entity) {
        CroatiaDiplomaticModel model = new CroatiaDiplomaticModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static CroatiaDiplomaticModel toModelDescription(CroatiaDiplomaticEntity entity) {
        CroatiaDiplomaticModel model = new CroatiaDiplomaticModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
