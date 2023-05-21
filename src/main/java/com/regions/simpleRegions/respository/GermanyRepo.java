package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GermanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GermanyRepo extends CrudRepository<GermanyEntity, Long> {

    GermanyEntity findByRegion(String region);
}
