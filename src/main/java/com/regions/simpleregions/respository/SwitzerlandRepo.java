package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitzerlandRepo extends CrudRepository<SwitzerlandEntity, Long> {

    SwitzerlandEntity findByRegion(String region);
}
