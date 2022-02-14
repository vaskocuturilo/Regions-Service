package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.BelarusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BelarusRepo extends CrudRepository<BelarusEntity, Long> {
    BelarusEntity findByRegion(String region);
}
