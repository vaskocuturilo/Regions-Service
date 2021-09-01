package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.FranceEntity;
import org.springframework.data.repository.CrudRepository;

public interface FranceRepo extends CrudRepository<FranceEntity, Long> {

    FranceEntity findByRegion(String region);
}
