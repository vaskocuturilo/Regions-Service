package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.MoldovaEntity;
import org.springframework.data.repository.CrudRepository;

public interface MoldovaRepo extends CrudRepository<MoldovaEntity, Long> {

    MoldovaEntity findByRegion(String region);
}
