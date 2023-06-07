package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.ItalianEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.ItalianModel;
import com.regions.simpleRegions.respository.ItalianRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class ItalianService {
    private final ItalianRepo italianRepo;

    public ItalianModel getRegionByNumber(String region) throws RegionNotFoundException {
        ItalianEntity italianRegion = italianRepo.findByRegion(region);
        if (italianRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return ItalianModel.toModel(italianRegion);
    }

    public List<ItalianModel> getRegionByDescription(String region) throws RegionNotFoundException {
        List<ItalianModel> italianModels;
        List<ItalianEntity> italianEntities = italianRepo.findByDescription(region);
        if (italianEntities.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        italianModels = italianEntities.stream().map(ItalianModel::toDescription).collect(Collectors.toList());

        return italianModels;
    }

    public Iterable<ItalianEntity> getAllRegions() {
        return italianRepo.findAll();
    }
}
