package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GermanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GermanRepo extends CrudRepository<GermanEntity, Long> {

    GermanEntity findByRegion(String region);
}
