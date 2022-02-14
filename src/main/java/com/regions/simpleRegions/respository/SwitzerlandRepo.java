package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.SwitzerlandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitzerlandRepo extends CrudRepository<SwitzerlandEntity, Long> {

    SwitzerlandEntity findByRegion(String region);
}
