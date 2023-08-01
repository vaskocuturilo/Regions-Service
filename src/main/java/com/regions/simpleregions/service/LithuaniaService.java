package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.LithuaniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.LithuaniaModel;
import com.regions.simpleregions.respository.LithuaniaRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class LithuaniaService {

    private final LithuaniaRepo lithuaniaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public LithuaniaModel getLithuaniaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getLithuaniaPlatesByRegion");
        Optional<LithuaniaEntity> lithuaniaRegion = lithuaniaRepo.findByRegion(region);

        Optional.ofNullable(lithuaniaRegion.stream().parallel().filter(lithuaniaEntity -> lithuaniaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return LithuaniaModel.toModelByRegion(lithuaniaRegion);
    }

    public List<LithuaniaModel> getLithuaniaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getLithuaniaPlatesByDescription");
        List<LithuaniaEntity> lithuaniaEntityList = lithuaniaRepo.findByDescription(description);

        lithuaniaEntityList.stream().parallel().findAny().map(lithuaniaEntity -> lithuaniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));
        return lithuaniaEntityList.stream().map(LithuaniaModel::toModelByDescription).toList();
    }

    public Iterable<LithuaniaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return lithuaniaRepo.findAll();
    }
}
