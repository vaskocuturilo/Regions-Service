package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MontenegroDiplomaticModel;
import com.regions.simpleregions.respository.MontenegroDiplomaticRepo;
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
public class MontenegroDiplomaticService {

    private final MontenegroDiplomaticRepo montenegroDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public MontenegroDiplomaticModel getMontenegroDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getMontenegroDiplomaticPlatesByRegion");
        Optional<MontenegroDiplomaticEntity> montenegroRegion = montenegroDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(montenegroRegion.stream().filter(montenegroEntity -> montenegroEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return MontenegroDiplomaticModel.toModelByRegion(montenegroRegion);
    }

    public List<MontenegroDiplomaticModel> getMontenegroDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getMontenegroDiplomaticPlatesByDescription");
        List<MontenegroDiplomaticEntity> montenegroEntityList = montenegroDiplomaticRepo.findByDescription(description);

        montenegroEntityList.stream().map(montenegroEntity -> montenegroEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return montenegroEntityList.stream().map(MontenegroDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<MontenegroDiplomaticEntity> getAllMontenegroDiplomaticRegions() {
        log.info("Start method getAllMontenegroDiplomaticRegions");
        return montenegroDiplomaticRepo.findAll();
    }
}
