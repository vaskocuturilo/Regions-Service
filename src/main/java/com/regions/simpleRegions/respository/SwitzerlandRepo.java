package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.SwitzerlandEntity;
import org.springframework.data.repository.CrudRepository;

public interface SwitzerlandRepo extends CrudRepository<SwitzerlandEntity, Long> {

    SwitzerlandEntity findByRegion(String region);
}
