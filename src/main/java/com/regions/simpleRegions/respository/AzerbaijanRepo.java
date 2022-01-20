package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.AzerbaijanEntity;
import org.springframework.data.repository.CrudRepository;

public interface AzerbaijanRepo extends CrudRepository<AzerbaijanEntity, Long> {

    AzerbaijanEntity findByRegion(String region);
}
