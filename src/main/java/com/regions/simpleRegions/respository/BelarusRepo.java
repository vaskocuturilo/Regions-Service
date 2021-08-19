package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.BelarusEntity;
import org.springframework.data.repository.CrudRepository;

public interface BelarusRepo extends CrudRepository<BelarusEntity, Long> {
    BelarusEntity findByRegion(String region);
}
