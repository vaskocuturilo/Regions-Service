package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BulgariaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BulgariaModel;
import com.regions.simpleRegions.respository.BulgariaRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class BulgariaService {

    private final BulgariaRepo bulgariaRepo;

    public BulgariaModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<BulgariaEntity> bulgariaRegion = bulgariaRepo.findByRegion(region);
        if (!bulgariaRegion.isPresent()) {
            throw new RegionNotFoundException("Region not found.");
        }

        return BulgariaModel.toModelRegion(bulgariaRegion);
    }

    public List<BulgariaModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<BulgariaEntity> bulgariaEntities = bulgariaRepo.findByDescription(description);
        if (bulgariaEntities.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }
        return bulgariaEntities.stream().map(BulgariaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<BulgariaEntity> getAllRegions() {
        return bulgariaRepo.findAll();
    }
}
