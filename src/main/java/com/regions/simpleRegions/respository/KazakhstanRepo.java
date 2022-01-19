package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.KazakhstanEntity;
import org.springframework.data.repository.CrudRepository;

public interface KazakhstanRepo extends CrudRepository<KazakhstanEntity, Long> {

    KazakhstanEntity findByRegion(String region);
}
