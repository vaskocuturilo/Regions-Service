package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.AzerbaijanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.AzerbaijanModel;
import com.regions.simpleregions.respository.AzerbaijanRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class AzerbaijanService {

    private final AzerbaijanRepo azerbaijanRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "azerbaijan_region", key = "#region")
    public AzerbaijanModel getAzerbaijanPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getAzerbaijanPlatesByRegion");
        Optional<AzerbaijanEntity> azerbaijanRegion = azerbaijanRepo.findByRegion(region);

        Optional.ofNullable(azerbaijanRegion.stream().parallel().filter(azerbaijanEntity -> azerbaijanEntity
                        .getRegion()
                        .equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return AzerbaijanModel.toModel(azerbaijanRegion);
    }

    @Cacheable(value = "azerbaijan_description", key = "#description")
    public List<AzerbaijanModel> getAzerbaijanPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getAzerbaijanPlatesByDescription");
        List<AzerbaijanEntity> azerbaijanEntities = azerbaijanRepo.findByDescription(description);

        azerbaijanEntities.stream().parallel().findAny().map(azerbaijanEntity -> azerbaijanEntity
                .getDescription()
                .equalsIgnoreCase(description)).orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return azerbaijanEntities.stream().map(AzerbaijanModel::toModelDescription).toList();
    }

    public Iterable<AzerbaijanEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return azerbaijanRepo.findAll();
    }
}
