package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.GreeceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.GreeceModel;
import com.regions.simpleregions.respository.GreeceRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class GreeceService {
    private final GreeceRepo greeceRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public GreeceModel getGreecePlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getGreecePlatesByRegion");
        Optional<GreeceEntity> greeceRegionExist = greeceRepo.findByRegion(region);

        Optional.ofNullable(greeceRegionExist.stream().parallel().filter(greeceEntity -> greeceEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region))));

        return GreeceModel.toModelByRegion(greeceRegionExist);
    }

    public List<GreeceModel> getGreecePlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getGreecePlatesByDescription");
        List<GreeceEntity> greeceEntityList = greeceRepo.findByDescription(description);

        greeceEntityList.stream().parallel().findAny().map(greeceEntity -> greeceEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));


        return greeceEntityList.stream().map(GreeceModel::toModelByDescription).toList();
    }

    public Iterable<GreeceEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return greeceRepo.findAll();
    }
}
