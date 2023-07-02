package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MontenegroEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MontenegroModel;
import com.regions.simpleregions.respository.MontenegroRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class MontenegroService {

    private final MontenegroRepo montenegroRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public MontenegroModel getMontenegroPlatesByRegion(final String region) throws RegionNotFoundException {
        Optional<MontenegroEntity> montenegroRegion = montenegroRepo.findByRegion(region);

        Optional.ofNullable(montenegroRegion.stream().filter(montenegroEntity -> montenegroEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return MontenegroModel.toModelByRegion(montenegroRegion);
    }

    public List<MontenegroModel> getMontenegroPlatesByDescription(final String description) throws DescriptionNotFoundException {
        List<MontenegroEntity> montenegroEntityList = montenegroRepo.findByDescription(description);

        montenegroEntityList.stream().map(montenegroEntity -> montenegroEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return montenegroEntityList.stream().map(MontenegroModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<MontenegroEntity> getAllRegions() {
        return montenegroRepo.findAll();
    }
}
