package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.CroatiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.CroatiaModel;
import com.regions.simpleregions.respository.CroatiaRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class CroatiaService {
    private final CroatiaRepo croatiaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public CroatiaModel getCroatiaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getCroatiaPlatesByRegion");
        Optional<CroatiaEntity> croatiaRegion = croatiaRepo.findByRegion(region);
        croatiaRegion.stream().parallel().filter(croatiaEntity -> croatiaEntity.getRegion().equals(region)).findFirst().orElseThrow(
                () -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return CroatiaModel.toModelRegion(croatiaRegion);
    }

    public List<CroatiaModel> getCroatiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getCroatiaPlatesByDescription");
        List<CroatiaEntity> croatiaEntities = croatiaRepo.findByDescription(description);

        croatiaEntities.stream().parallel().findAny().map(croatiaEntity -> croatiaEntity.getDescription()).orElseThrow(
                () -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return croatiaEntities.stream().map(CroatiaModel::toModelDescription).toList();
    }

    public Iterable<CroatiaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return croatiaRepo.findAll();
    }
}
