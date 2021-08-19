package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.CzechEntity;
import org.springframework.data.repository.CrudRepository;

public interface CzechRepo extends CrudRepository<CzechEntity, Long> {

    CzechEntity findByRegion(String region);
}
