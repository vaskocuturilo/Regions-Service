package com.regions.simpleregions.model;

import com.regions.simpleregions.entity.ItalianEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class ItalianModel {

    private String description;

    private String region;

    public static ItalianModel toModel(Optional<ItalianEntity> entity) {
        ItalianModel model = new ItalianModel();
        model.setDescription(entity.get().getDescription());
        model.setRegion(entity.get().getRegion());

        return model;
    }

    public static ItalianModel toDescription(ItalianEntity entity) {
        ItalianModel model = new ItalianModel();
        model.setDescription(entity.getDescription());
        model.setRegion(entity.getRegion());

        return model;
    }
}
