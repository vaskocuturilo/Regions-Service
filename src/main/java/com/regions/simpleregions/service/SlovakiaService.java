package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SlovakiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SlovakiaModel;
import com.regions.simpleregions.respository.SlovakiaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class SlovakiaService {

    private final SlovakiaRepo slovakiaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SlovakiaModel getSlovakiaPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<SlovakiaEntity> slovakiaRegion = slovakiaRepo.findByRegion(region);

        slovakiaRegion
                .stream()
                .filter(slovakiaEntity -> slovakiaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst().orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region)));

        return SlovakiaModel.toModelByRegion(slovakiaRegion);
    }

    public List<SlovakiaModel> getSlovakiaPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<SlovakiaEntity> slovakiaEntityList = slovakiaRepo.findByDescription(description);

        slovakiaEntityList
                .stream()
                .map(slovakiaEntity -> slovakiaEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return slovakiaEntityList.stream().map(SlovakiaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SlovakiaEntity> getAllRegions() {
        return slovakiaRepo.findAll();
    }
}
