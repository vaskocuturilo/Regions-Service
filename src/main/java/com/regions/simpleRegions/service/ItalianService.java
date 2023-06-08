package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.ItalianEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.ItalianModel;
import com.regions.simpleRegions.respository.ItalianRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class ItalianService {
    private final ItalianRepo italianRepo;
    @Value("${notification.message}")
    private String regionNotFound;

    public ItalianModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<ItalianEntity> italianRegion = italianRepo.findByRegion(region);
        if (!italianRegion.isPresent()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return ItalianModel.toModel(italianRegion);
    }

    public List<ItalianModel> getRegionByDescription(final String region) throws RegionNotFoundException {
        List<ItalianEntity> italianEntities = italianRepo.findByDescription(region);
        if (italianEntities.isEmpty()) {
            throw new RegionNotFoundException(regionNotFound);
        }

        return italianEntities.stream().map(ItalianModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<ItalianEntity> getAllRegions() {
        return italianRepo.findAll();
    }
}
