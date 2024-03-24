package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MontenegroDiplomaticModel;
import com.regions.simpleregions.respository.MontenegroDiplomaticRepository;
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
public class MontenegroDiplomaticService {

    private final MontenegroDiplomaticRepository montenegroDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "montenegro_diplomatic_region", key = "#region")
    public MontenegroDiplomaticModel getMontenegroDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getMontenegroDiplomaticPlatesByRegion");
        Optional<MontenegroDiplomaticEntity> montenegroRegion = montenegroDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(montenegroRegion.stream().parallel().filter(montenegroEntity -> montenegroEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return MontenegroDiplomaticModel.toModelByRegion(montenegroRegion);
    }

    @Cacheable(value = "montenegro_diplomatic_description", key = "#description")
    public List<MontenegroDiplomaticModel> getMontenegroDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getMontenegroDiplomaticPlatesByDescription");
        List<MontenegroDiplomaticEntity> montenegroEntityList = montenegroDiplomaticRepository.findByDescription(description);

        montenegroEntityList.stream().parallel().map(montenegroEntity -> montenegroEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return montenegroEntityList.stream().map(MontenegroDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<MontenegroDiplomaticEntity> getAllMontenegroDiplomaticRegions() {
        log.info("Start method getAllMontenegroDiplomaticRegions");
        return montenegroDiplomaticRepository.findAll();
    }
}
