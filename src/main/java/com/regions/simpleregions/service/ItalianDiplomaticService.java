package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ItalianDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.ItalianDiplomaticModel;
import com.regions.simpleregions.respository.ItalianDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class ItalianDiplomaticService {
    private final ItalianDiplomaticRepo italianDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public ItalianDiplomaticModel getItalianDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<ItalianDiplomaticEntity> italianRegion = italianDiplomaticRepo.findByRegion(region);
        italianRegion.stream().filter(italianEntity -> italianEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return ItalianDiplomaticModel.toModel(italianRegion);
    }

    public List<ItalianDiplomaticModel> getItalianDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<ItalianDiplomaticEntity> italianEntityList = italianDiplomaticRepo.findByDescription(description);
        italianEntityList.stream().findAny().map(italianEntity -> italianEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return italianEntityList.stream().map(ItalianDiplomaticModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<ItalianDiplomaticEntity> getAllRegions() {
        return italianDiplomaticRepo.findAll();
    }
}
