package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.LithuaniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.LithuaniaModel;
import com.regions.simpleregions.respository.LithuaniaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class LithuaniaService {

    private final LithuaniaRepo lithuaniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public LithuaniaModel getLithuaniaPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<LithuaniaEntity> lithuaniaRegion = lithuaniaRepo.findByRegion(region);

        lithuaniaRegion.stream().filter(lithuaniaEntity -> lithuaniaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return LithuaniaModel.toModelByRegion(lithuaniaRegion);
    }

    public List<LithuaniaModel> getLithuaniaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<LithuaniaEntity> lithuaniaEntityList = lithuaniaRepo.findByDescription(description);

        lithuaniaEntityList.stream().findAny().map(lithuaniaEntity -> lithuaniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));
        return lithuaniaEntityList.stream().map(LithuaniaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<LithuaniaEntity> getAllRegions() {
        return lithuaniaRepo.findAll();
    }
}
