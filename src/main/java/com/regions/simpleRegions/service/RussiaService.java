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
    @Value("${notification.message}")
    private String regionNotFound;

    public RussiaModel getRegionNumber(final String region) throws RegionNotFoundException {
        Optional<RussiaEntity> russiaRegion = russiaRepo.findByRegion(region);
        if (!russiaRegion.isPresent()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return RussiaModel.toModelRegion(russiaRegion);
    }

    public List<RussiaModel> getDescription(final String description) throws RegionNotFoundException {
        List<RussiaEntity> russiaEntityList = russiaRepo.findByDescription(description);
        if (russiaEntityList.isEmpty()) {
            throw new RegionNotFoundException(regionNotFound);
        }

        return russiaEntityList.stream().map(RussiaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<RussiaEntity> getAllRegions() {
        return russiaRepo.findAll();
    }
}
