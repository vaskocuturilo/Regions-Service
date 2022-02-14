package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.FranceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranceRepo extends CrudRepository<FranceEntity, Long> {

    FranceEntity findByRegion(String region);
}
