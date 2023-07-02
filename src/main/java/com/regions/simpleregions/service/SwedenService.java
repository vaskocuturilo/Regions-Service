package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.SwedenEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.SwedenModel;
import com.regions.simpleregions.respository.SwedenRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class SwedenService {

    private final SwedenRepo swedenRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public SwedenModel getSwedenPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<SwedenEntity> swedenRegion = swedenRepo.findByRegion(region);

        Optional.ofNullable(swedenRegion
                .stream()
                .filter(romaniaEntity -> romaniaEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return SwedenModel.toModelByRegion(swedenRegion);
    }

    public List<SwedenModel> getSwedenPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<SwedenEntity> swedenEntityList = swedenRepo.findByDescription(description);

        swedenEntityList
                .stream()
                .map(swedenEntity -> swedenEntity.getDescription().equalsIgnoreCase(description))
                .findAny().orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return swedenEntityList.stream().map(SwedenModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<SwedenEntity> getAllRegions() {
        return swedenRepo.findAll();
    }
}
