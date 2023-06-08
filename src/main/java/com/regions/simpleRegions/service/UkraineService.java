package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.UkraineEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.UkraineModel;
import com.regions.simpleRegions.respository.UkraineRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UkraineService {

    private final UkraineRepo ukraineRepo;
    @Value("${notification.message}")
    private String regionNotFound;

    public UkraineModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<UkraineEntity> ukraineRegion = ukraineRepo.findByRegion(region);
        if (!ukraineRegion.isPresent()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return UkraineModel.toModel(ukraineRegion);
    }

    public List<UkraineModel> getRegionByDescription(final String description) throws RegionNotFoundException {
        List<UkraineEntity> ukraineEntityList = ukraineRepo.findByDescription(description);
        if (ukraineEntityList.isEmpty()) {
            throw new RegionNotFoundException(regionNotFound);
        }
        return ukraineEntityList.stream().map(UkraineModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<UkraineEntity> getAllRegions() {
        return ukraineRepo.findAll();
    }
}
