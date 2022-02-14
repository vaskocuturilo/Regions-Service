package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.SwedenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwedenRepo extends CrudRepository<SwedenEntity, Long> {

    SwedenEntity findByRegion(String region);
}
