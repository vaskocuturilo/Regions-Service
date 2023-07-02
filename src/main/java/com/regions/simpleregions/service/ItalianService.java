package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ItalianEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.ItalianModel;
import com.regions.simpleregions.respository.ItalianRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class ItalianService {
    private final ItalianRepo italianRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public ItalianModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<ItalianEntity> italianRegion = italianRepo.findByRegion(region);
        italianRegion.stream().filter(italianEntity -> italianEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return ItalianModel.toModel(italianRegion);
    }

    public List<ItalianModel> getRegionByDescription(final String description) throws RegionNotFoundException {
        List<ItalianEntity> italianEntityList = italianRepo.findByDescription(description);
        italianEntityList.stream().findAny().map(italianEntity -> italianEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return italianEntityList.stream().map(ItalianModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<ItalianEntity> getAllRegions() {
        return italianRepo.findAll();
    }
}
