package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.HungaryEntity;
import org.springframework.data.repository.CrudRepository;

public interface HungaryRepo extends CrudRepository<HungaryEntity, Long> {
    HungaryEntity findByRegion(String region);
}
