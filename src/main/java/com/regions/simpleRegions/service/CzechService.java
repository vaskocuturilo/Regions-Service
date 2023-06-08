package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.CzechEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.CzechModel;
import com.regions.simpleRegions.respository.CzechRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class CzechService {

    private final CzechRepo czechRepo;
    @Value("${notification.message}")
    private String REGION_NOT_FOUND;

    public CzechModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<CzechEntity> czechRegion = czechRepo.findByRegion(region);
        if (!czechRegion.isPresent()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return CzechModel.toModelRegion(czechRegion);
    }

    public List<CzechModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<CzechEntity> czechEntities = czechRepo.findByDescription(description);
        if (czechEntities.isEmpty()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return czechEntities.stream().map(CzechModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<CzechEntity> getAllRegions() {
        return czechRepo.findAll();
    }
}
