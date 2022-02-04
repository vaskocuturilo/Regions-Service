package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.KyrgyzstanEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.KyrgyzstanModel;
import com.regions.simpleRegions.respository.KyrgyzstanRepo;
import org.springframework.stereotype.Service;

@Service
public class KyrgyzstanService {

    KyrgyzstanRepo kyrgyzstanRepo;

    public KyrgyzstanService(KyrgyzstanRepo kyrgyzstanRepo) {
        this.kyrgyzstanRepo = kyrgyzstanRepo;
    }

    public KyrgyzstanModel getOne(String region) throws RegionNotFoundException {
        KyrgyzstanEntity kyrgyzstanRegion = kyrgyzstanRepo.findByRegion(region);
        if (kyrgyzstanRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return KyrgyzstanModel.toModel(kyrgyzstanRegion);
    }
}
