package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.PolandEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.PolandModel;
import com.regions.simpleRegions.respository.PolandRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class PolandService {
    private final PolandRepo polandRepo;

    public PolandModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<PolandEntity> polandRegion = polandRepo.findByRegion(region);
        if (!polandRegion.isPresent()) {
            throw new RegionNotFoundException("Region not found.");
        }
        return PolandModel.toModel(polandRegion);
    }

    public List<PolandModel> getByDescription(final String description) throws RegionNotFoundException {
        List<PolandEntity> polandEntityList = polandRepo.findByDescription(description);
        if (polandEntityList.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        return polandEntityList.stream().map(PolandModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<PolandEntity> getAllRegions() {
        return polandRepo.findAll();
    }
}
