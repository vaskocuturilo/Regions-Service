package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.CroatiaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.CroatiaDiplomaticModel;
import com.regions.simpleregions.respository.CroatiaDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class CroatiaDiplomaticService {
    private final CroatiaDiplomaticRepo croatiaDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public CroatiaDiplomaticModel getCroatiaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<CroatiaDiplomaticEntity> croatiaRegion = croatiaDiplomaticRepo.findByRegion(region);
        croatiaRegion.stream().filter(croatiaEntity -> croatiaEntity.getRegion().equals(region)).findFirst().orElseThrow(
                () -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return CroatiaDiplomaticModel.toModelRegion(croatiaRegion);
    }

    public List<CroatiaDiplomaticModel> getCroatiaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<CroatiaDiplomaticEntity> croatiaEntities = croatiaDiplomaticRepo.findByDescription(description);

        croatiaEntities.stream().findAny().map(croatiaEntity -> croatiaEntity.getDescription()).orElseThrow(
                () -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return croatiaEntities.stream().map(CroatiaDiplomaticModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<CroatiaDiplomaticEntity> getAllCroatiaDiplomaticRegions() {
        return croatiaDiplomaticRepo.findAll();
    }
}
