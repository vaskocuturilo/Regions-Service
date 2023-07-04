package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.GreeceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.GreeceModel;
import com.regions.simpleregions.respository.GreeceRepo;
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

    public GreeceModel getGreecePlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<GreeceEntity> greeceRegionExist = greeceRepo.findByRegion(region);

        greeceRegionExist.stream().filter(greeceEntity -> greeceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return GreeceModel.toModelByRegion(greeceRegionExist);
    }

    public List<GreeceModel> getGreecePlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<GreeceEntity> greeceEntityList = greeceRepo.findByDescription(description);

        greeceEntityList.stream().findAny().map(greeceEntity -> greeceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));


        return greeceEntityList.stream().map(GreeceModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<GreeceEntity> getAllRegions() {
        return greeceRepo.findAll();
    }
}
