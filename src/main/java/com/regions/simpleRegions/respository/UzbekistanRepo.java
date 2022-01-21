package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.UzbekistanEntity;
import org.springframework.data.repository.CrudRepository;

public interface UzbekistanRepo extends CrudRepository<UzbekistanEntity, Long> {

    UzbekistanEntity findByRegion(String region);
}
