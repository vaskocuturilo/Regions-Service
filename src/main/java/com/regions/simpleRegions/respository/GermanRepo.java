package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GermanEntity;
import org.springframework.data.repository.CrudRepository;

public interface GermanRepo extends CrudRepository<GermanEntity, Long> {

    GermanEntity findByRegion(String region);
}
