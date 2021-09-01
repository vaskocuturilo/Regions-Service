package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.SloveniaEntity;
import org.springframework.data.repository.CrudRepository;

public interface SloveniaRepo extends CrudRepository<SloveniaEntity, Long> {

    SloveniaEntity findByRegion(String region);
}
