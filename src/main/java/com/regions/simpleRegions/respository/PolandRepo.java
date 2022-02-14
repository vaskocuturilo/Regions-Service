package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.PolandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolandRepo extends CrudRepository<PolandEntity, Long> {

    PolandEntity findByRegion(String region);
}
