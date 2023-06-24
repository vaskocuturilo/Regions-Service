package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.RussiaModel;
import com.regions.simpleRegions.respository.RussiaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class RussiaService {

    private final RussiaRepo russiaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public RussiaModel getRegionNumber(final String region) throws RegionNotFoundException {
        Optional<RussiaEntity> russiaRegion = russiaRepo.findByRegion(region);
        russiaRegion.stream().filter(russiaEntity -> russiaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        });
        return RussiaModel.toModelRegion(russiaRegion);
    }

    public List<RussiaModel> getDescription(final String description) throws RegionNotFoundException {
        List<RussiaEntity> russiaEntityList = russiaRepo.findByDescription(description);

        russiaEntityList.stream().findAny().map(russiaEntity -> russiaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });

        return russiaEntityList.stream().map(RussiaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<RussiaEntity> getAllRegions() {
        return russiaRepo.findAll();
    }
}
