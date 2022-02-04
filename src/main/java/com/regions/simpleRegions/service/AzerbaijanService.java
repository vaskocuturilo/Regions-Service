package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.AzerbaijanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.AzerbaijanModel;
import com.regions.simpleRegions.respository.AzerbaijanRepo;
import org.springframework.stereotype.Service;

@Service
public class AzerbaijanService {

    AzerbaijanRepo azerbaijanRepo;

    public AzerbaijanService(AzerbaijanRepo azerbaijanRepo) {
        this.azerbaijanRepo = azerbaijanRepo;
    }

    public AzerbaijanModel getOne(String region) throws RegionNotFoundException {
        AzerbaijanEntity azerbaijanRegion = azerbaijanRepo.findByRegion(region);
        if (azerbaijanRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return AzerbaijanModel.toModel(azerbaijanRegion);
    }
}
