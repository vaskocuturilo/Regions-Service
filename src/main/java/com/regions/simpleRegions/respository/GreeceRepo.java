package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GreeceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreeceRepo extends CrudRepository<GreeceEntity, Long> {
    GreeceEntity findByRegion(String region);
}
