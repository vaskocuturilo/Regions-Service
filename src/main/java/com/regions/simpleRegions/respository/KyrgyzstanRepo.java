package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.KyrgyzstanEntity;
import org.springframework.data.repository.CrudRepository;

public interface KyrgyzstanRepo extends CrudRepository<KyrgyzstanEntity, Long> {
    KyrgyzstanEntity findByRegion(String region);
}
