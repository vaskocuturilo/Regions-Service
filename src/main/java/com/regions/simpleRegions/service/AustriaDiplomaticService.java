package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AustriaDiplomaticEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AustriaDiplomaticModel;
import com.regions.simpleRegions.respository.AustriaDiplomaticRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class AustriaDiplomaticService {
    private final AustriaDiplomaticRepo austriaDiplomaticRepo;

    @Value("${notification.message}")
    private String REGION_NOT_FOUND;

    public AustriaDiplomaticModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<AustriaDiplomaticEntity> austriaRegion = austriaDiplomaticRepo.findByRegion(region);
        if (!austriaRegion.isPresent()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return AustriaDiplomaticModel.toModelRegion(austriaRegion);
    }

    public List<AustriaDiplomaticModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<AustriaDiplomaticEntity> austriaRegions = austriaDiplomaticRepo.findByDescription(description);
        if (austriaRegions.isEmpty()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return austriaRegions.stream().map(AustriaDiplomaticModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AustriaDiplomaticEntity> getAllRegions() {
        return austriaDiplomaticRepo.findAll();
    }
}
