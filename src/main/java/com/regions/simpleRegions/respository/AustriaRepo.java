package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.AustriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AustriaRepo extends CrudRepository<AustriaEntity, Long> {
    AustriaEntity findByRegion(String region);
}
