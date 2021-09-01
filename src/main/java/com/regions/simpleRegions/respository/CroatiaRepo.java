package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.CroatiaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CroatiaRepo extends CrudRepository<CroatiaEntity, Long> {
    CroatiaEntity findByRegion(String region);
}
