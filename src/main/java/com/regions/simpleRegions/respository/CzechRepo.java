package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.CzechEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CzechRepo extends CrudRepository<CzechEntity, Long> {

    CzechEntity findByRegion(String region);
}
