package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GreeceEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GreeceModel;
import com.regions.simpleRegions.respository.GreeceRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class GreeceService {
    private final GreeceRepo greeceRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public GreeceModel getRegionByNumber(final String region) throws RegionNotFoundException {
        Optional<GreeceEntity> greeceRegionExist = greeceRepo.findByRegion(region);

        greeceRegionExist.stream().filter(greeceEntity -> greeceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));
            return regionNotFoundException;
        });

        return GreeceModel.toModelByRegion(greeceRegionExist);
    }

    public List<GreeceModel> getRegionByDescription(final String description) throws RegionNotFoundException {
        List<GreeceEntity> greeceEntityList = greeceRepo.findByDescription(description);

        greeceEntityList.stream().findAny().map(greeceEntity -> greeceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(descriptionNotFound, description));

            return regionNotFoundException;
        });


        return greeceEntityList.stream().map(GreeceModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<GreeceEntity> getAllRegions() {
        return greeceRepo.findAll();
    }
}
