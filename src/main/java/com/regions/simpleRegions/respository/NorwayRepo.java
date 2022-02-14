package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.NorwayEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NorwayRepo extends CrudRepository<NorwayEntity, Long> {

    NorwayEntity findByRegion(String region);
}
