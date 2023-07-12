package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MontenegroDiplomaticModel;
import com.regions.simpleregions.respository.MontenegroDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class MontenegroDiplomaticService {

    private final MontenegroDiplomaticRepo montenegroDiplomaticRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public MontenegroDiplomaticModel getMontenegroDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<MontenegroDiplomaticEntity> montenegroRegion = montenegroDiplomaticRepo.findByRegion(region);

        Optional.ofNullable(montenegroRegion.stream().filter(montenegroEntity -> montenegroEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return MontenegroDiplomaticModel.toModelByRegion(montenegroRegion);
    }

    public List<MontenegroDiplomaticModel> getMontenegroDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<MontenegroDiplomaticEntity> montenegroEntityList = montenegroDiplomaticRepo.findByDescription(description);

        montenegroEntityList.stream().map(montenegroEntity -> montenegroEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return montenegroEntityList.stream().map(MontenegroDiplomaticModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<MontenegroDiplomaticEntity> getAllMontenegroDiplomaticRegions() {
        return montenegroDiplomaticRepo.findAll();
    }
}
