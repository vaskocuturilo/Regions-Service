package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SlovakiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SlovakiaModel;
import com.regions.simpleregions.respository.SlovakiaRepo;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Data
@Service
public class SlovakiaService {

    private final SlovakiaRepo slovakiaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SlovakiaModel getSlovakiaPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getSlovakiaPlatesByRegion");
        Optional<SlovakiaEntity> slovakiaRegion = slovakiaRepo.findByRegion(region);

        Optional.ofNullable(slovakiaRegion
                .stream()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SlovakiaModel.toModelByRegion(slovakiaRegion);
    }

    public List<SlovakiaModel> getSlovakiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getSlovakiaPlatesByDescription");
        List<SlovakiaEntity> slovakiaEntityList = slovakiaRepo.findByDescription(description);

        slovakiaEntityList
                .stream()
                .map(slovakiaEntity -> slovakiaEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return slovakiaEntityList.stream().map(SlovakiaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SlovakiaEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return slovakiaRepo.findAll();
    }
}
