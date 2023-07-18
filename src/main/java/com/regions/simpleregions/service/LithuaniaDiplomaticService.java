package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.LithuaniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.LithuaniaDiplomaticModel;
import com.regions.simpleregions.respository.LithuaniaDiplomaticRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Data
@Service
public class LithuaniaDiplomaticService {

    private final LithuaniaDiplomaticRepo lithuaniaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public LithuaniaDiplomaticModel getLithuaniaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getLithuaniaDiplomaticPlatesByRegion");
        Optional<LithuaniaDiplomaticEntity> lithuaniaRegion = lithuaniaDiplomaticRepo.findByRegion(region);

        lithuaniaRegion.stream().filter(lithuaniaEntity -> lithuaniaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return LithuaniaDiplomaticModel.toModelByRegion(lithuaniaRegion);
    }

    public List<LithuaniaDiplomaticModel> getLithuaniaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getLithuaniaDiplomaticPlatesByDescription");
        List<LithuaniaDiplomaticEntity> lithuaniaEntityList = lithuaniaDiplomaticRepo.findByDescription(description);

        lithuaniaEntityList.stream().findAny().map(lithuaniaEntity -> lithuaniaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));
        return lithuaniaEntityList.stream().map(LithuaniaDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<LithuaniaDiplomaticEntity> getAllLithuaniaDiplomaticRegions() {
        log.info("Start method getAllLithuaniaDiplomaticRegions");
        return lithuaniaDiplomaticRepo.findAll();
    }
}
