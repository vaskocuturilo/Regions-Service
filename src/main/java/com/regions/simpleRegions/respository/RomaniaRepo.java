package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.RomaniaEntity;
import org.springframework.data.repository.CrudRepository;

public interface RomaniaRepo extends CrudRepository<RomaniaEntity, Long> {
    RomaniaEntity findByRegion(String region);
}
