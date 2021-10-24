package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.ArmeniaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArmeniaRepo extends CrudRepository<ArmeniaEntity, Long> {

    ArmeniaEntity findByRegion(String region);
}
