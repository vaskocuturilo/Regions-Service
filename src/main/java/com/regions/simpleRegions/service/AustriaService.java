package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AustriaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AustriaModel;
import com.regions.simpleRegions.respository.AustriaRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class AustriaService {
    private final AustriaRepo austriaRepo;

    public AustriaModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<AustriaEntity> austriaRegion = austriaRepo.findByRegion(region);
        if (!austriaRegion.isPresent()) {
            throw new RegionNotFoundException("Region not found.");
        }
        return AustriaModel.toModelRegion(austriaRegion);
    }

    public List<AustriaModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<AustriaEntity> austriaRegions = austriaRepo.findByDescription(description);
        if (austriaRegions.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }
        return austriaRegions.stream().map(AustriaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AustriaEntity> getAllRegions() {
        return austriaRepo.findAll();
    }
}
