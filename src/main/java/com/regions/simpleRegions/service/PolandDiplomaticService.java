package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.PolandDiplomaticEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.PolandDiplomaticModel;
import com.regions.simpleRegions.respository.PolandDiplomaticRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class PolandDiplomaticService {
    private final PolandDiplomaticRepo polandDiplomaticRepo;

    public PolandDiplomaticModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<PolandDiplomaticEntity> polandDiplomaticRegion = polandDiplomaticRepo.findByRegion(region);
        if (!polandDiplomaticRegion.isPresent()) {
            throw new RegionNotFoundException("Region not found.");
        }
        return PolandDiplomaticModel.toModel(polandDiplomaticRegion);
    }

    public List<PolandDiplomaticModel> getByDescription(final String description) throws RegionNotFoundException {
        List<PolandDiplomaticEntity> polandEntityList = polandDiplomaticRepo.findByDescription(description);
        if (polandEntityList.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        return polandEntityList.stream().map(PolandDiplomaticModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<PolandDiplomaticEntity> getAllRegions() {
        return polandDiplomaticRepo.findAll();
    }
}
