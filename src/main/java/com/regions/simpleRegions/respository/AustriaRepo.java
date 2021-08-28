package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.AustriaEntity;
import org.springframework.data.repository.CrudRepository;

public interface AustriaRepo extends CrudRepository<AustriaEntity, Long> {
    AustriaEntity findByRegion(String region);
}
