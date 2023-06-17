package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AzerbaijanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AzerbaijanModel;
import com.regions.simpleRegions.respository.AzerbaijanRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class AzerbaijanService {

    private final AzerbaijanRepo azerbaijanRepo;

    @Value("${notification.message}")
    private String REGION_NOT_FOUND;

    public AzerbaijanModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<AzerbaijanEntity> azerbaijanRegion = azerbaijanRepo.findByRegion(region);
        if (!azerbaijanRegion.isPresent()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return AzerbaijanModel.toModel(azerbaijanRegion);
    }

    public List<AzerbaijanModel> getRegionByDescription(String region) throws RegionNotFoundException {
        List<AzerbaijanEntity> azerbaijanEntities = azerbaijanRepo.findByDescription(region);
        if (azerbaijanEntities.isEmpty()) {
            throw new RegionNotFoundException(REGION_NOT_FOUND);
        }
        return azerbaijanEntities.stream().map(AzerbaijanModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<AzerbaijanEntity> getAllRegions() {
        return azerbaijanRepo.findAll();
    }
}
