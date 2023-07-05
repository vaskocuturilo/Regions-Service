package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.BulgariaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.BulgariaModel;
import com.regions.simpleregions.respository.BulgariaRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class BulgariaService {

    private final BulgariaRepo bulgariaRepo;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    public BulgariaModel getBulgariaPlatesByRegion(String region) throws RegionNotFoundException {
        Optional<BulgariaEntity> bulgariaRegion = bulgariaRepo.findByRegion(region);
        bulgariaRegion.stream().filter(bulgariaEntity -> bulgariaEntity.getRegion().equalsIgnoreCase(region)).findFirst().orElseThrow(() ->
                new RegionNotFoundException(String.format(regionNotFound, region)));

        return BulgariaModel.toModelRegion(bulgariaRegion);
    }

    public List<BulgariaModel> getBulgariaPlatesByDescription(String description) throws DescriptionNotFoundException {
        List<BulgariaEntity> bulgariaEntityList = bulgariaRepo.findByDescription(description);

        bulgariaEntityList.stream().findAny().map(bulgariaEntity -> bulgariaEntity.getDescription().equalsIgnoreCase(description)).orElseThrow(() ->
                new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return bulgariaEntityList.stream().map(BulgariaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<BulgariaEntity> getAllRegions() {
        return bulgariaRepo.findAll();
    }
}
