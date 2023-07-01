package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.MoldovaEntity;
import com.regions.simpleRegions.exception.DescriptionNotFoundException;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.MoldovaModel;
import com.regions.simpleRegions.respository.MoldovaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class MoldovaService {

    private final MoldovaRepo moldovaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public MoldovaModel getMoldovaPlatesByRegion(String region) throws RegionNotFoundException {
        Optional<MoldovaEntity> moldovaRegion = moldovaRepo.findByRegion(region);

        Optional.ofNullable(moldovaRegion.stream().filter(moldovaEntity -> moldovaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() -> {
            RegionNotFoundException regionNotFoundException = new RegionNotFoundException(String.format(regionNotFound, region));

            return regionNotFoundException;
        }));

        return MoldovaModel.toModelByRegion(moldovaRegion);
    }

    public List<MoldovaModel> getMoldovaPlatesByDescription(String description) throws DescriptionNotFoundException {
        List<MoldovaEntity> moldovaEntityList = moldovaRepo.findByDescription(description);

        moldovaEntityList.stream().map(moldovaEntity -> moldovaEntity.getDescription().equalsIgnoreCase(description)).findAny().orElseThrow(() -> {
            DescriptionNotFoundException descriptionNotFoundException = new DescriptionNotFoundException(String.format(descriptionNotFound, description));

            return descriptionNotFoundException;
        });


        return moldovaEntityList.stream().map(MoldovaModel::toModelByDescription).collect(Collectors.toList());
    }

    public Iterable<MoldovaEntity> getAllRegions() {
        return moldovaRepo.findAll();
    }
}
