package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BelarusEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.BelarusModel;
import com.regions.simpleRegions.respository.BelarusRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class BelarusService {

    private final BelarusRepo belarusRepo;
    @Value("${notification.message}")
    private String REGION_NOT_FOUND;

    public BelarusModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<BelarusEntity> belarusRegion = belarusRepo.findByRegion(region);
        if (!belarusRegion.isPresent()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return BelarusModel.toModel(belarusRegion);
    }

    public List<BelarusModel> getRegionByDescription(String description) throws RegionNotFoundException {
        List<BelarusEntity> belarusRegion = belarusRepo.findByDescription(description);
        if (belarusRegion.isEmpty()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }

        return belarusRegion.stream().map(BelarusModel::toDescription).collect(Collectors.toList());
    }

    public Iterable<BelarusEntity> getAllRegions() {

        return belarusRepo.findAll();
    }
}
