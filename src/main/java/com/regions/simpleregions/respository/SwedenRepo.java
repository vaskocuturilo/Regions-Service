package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SwedenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwedenRepo extends CrudRepository<SwedenEntity, Long> {

    SwedenEntity findByRegion(String region);
}
