package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.CroatiaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.CroatiaDiplomaticModel;
import com.regions.simpleregions.respository.CroatiaDiplomaticRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class CroatiaDiplomaticService {
    private final CroatiaDiplomaticRepository croatiaDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "croatia_diplomatic_region", key = "#region")
    public CroatiaDiplomaticModel getCroatiaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getCroatiaDiplomaticPlatesByRegion");
        Optional<CroatiaDiplomaticEntity> croatiaRegion = croatiaDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(croatiaRegion.stream().parallel().filter(croatiaEntity -> croatiaEntity.getRegion().equals(region)).findFirst().orElseThrow(
                () -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return CroatiaDiplomaticModel.toModelRegion(croatiaRegion);
    }

    @Cacheable(value = "croatia_diplomatic_description", key = "#description")
    public List<CroatiaDiplomaticModel> getCroatiaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getCroatiaDiplomaticPlatesByDescription");
        List<CroatiaDiplomaticEntity> croatiaEntities = croatiaDiplomaticRepository.findByDescription(description);

        croatiaEntities.parallelStream().findAny().map(croatiaEntity -> croatiaEntity.getDescription()).orElseThrow(
                () -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return croatiaEntities.stream().map(CroatiaDiplomaticModel::toModelDescription).toList();
    }

    public Iterable<CroatiaDiplomaticEntity> getAllCroatiaDiplomaticRegions() {
        log.info("Start method getAllCroatiaDiplomaticRegions");
        return croatiaDiplomaticRepository.findAll();
    }
}
