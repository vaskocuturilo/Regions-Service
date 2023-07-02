package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.CroatiaEntity;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.model.CroatiaModel;
import com.regions.simpleregions.respository.CroatiaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class CroatiaService {
    private final CroatiaRepo croatiaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public CroatiaModel getRegionByName(String region) {
        Optional<CroatiaEntity> croatiaRegion = croatiaRepo.findByRegion(region);
        croatiaRegion.stream().filter(croatiaEntity -> croatiaEntity.getRegion().equals(region)).findFirst().orElseThrow(
                () -> {
                    RegionsNotFoundException regionsNotFoundException = new RegionsNotFoundException(String.format(regionNotFound, region));
                    return regionsNotFoundException;
                });

        return CroatiaModel.toModelRegion(croatiaRegion);
    }

    public List<CroatiaModel> getRegionByDescription(String description) throws RegionsNotFoundException {
        List<CroatiaEntity> croatiaEntities = croatiaRepo.findByDescription(description);

        croatiaEntities.stream().findAny().map(croatiaEntity -> croatiaEntity.getDescription()).orElseThrow(
                () -> {
                    RegionsNotFoundException regionsNotFoundException = new RegionsNotFoundException(String.format(descriptionNotFound, description));
                    return regionsNotFoundException;
                });
        return croatiaEntities.stream().map(CroatiaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<CroatiaEntity> getAllRegions() {
        return croatiaRepo.findAll();
    }
}