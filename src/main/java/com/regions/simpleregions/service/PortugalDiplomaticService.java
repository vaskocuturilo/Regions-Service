package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.PortugalDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.PortugalDiplomaticModel;
import com.regions.simpleregions.respository.PortugalDiplomaticRepository;
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
public class PortugalDiplomaticService {

    private final PortugalDiplomaticRepository portugalDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "portugal_diplomatic_region", key = "#region")
    public PortugalDiplomaticModel getPortugalDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getPortugalDiplomaticPlatesByRegion");
        Optional<PortugalDiplomaticEntity> portugalRegion = portugalDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(portugalRegion
                .stream().parallel()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return PortugalDiplomaticModel.toModelByRegion(portugalRegion);
    }

    @Cacheable(value = "portugal_diplomatic_description", key = "#description")
    public List<PortugalDiplomaticModel> getPortugalDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getPortugalDiplomaticPlatesByDescription");
        List<PortugalDiplomaticEntity> portugalEntityList = portugalDiplomaticRepository.findByDescription(description);

        portugalEntityList.stream().parallel().map(romaniaEntity -> romaniaEntity.getDescription().equalsIgnoreCase(description)).findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));


        return portugalEntityList.stream().map(PortugalDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<PortugalDiplomaticEntity> getAllPortugalDiplomaticRegions() {
        log.info("Start method getAllPortugalDiplomaticRegions");
        return portugalDiplomaticRepository.findAll();
    }
}
