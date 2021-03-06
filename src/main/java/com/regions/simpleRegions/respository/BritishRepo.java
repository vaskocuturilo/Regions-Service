package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.BritishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BritishRepo extends CrudRepository<BritishEntity, Long> {

    BritishEntity findByRegion(String region);
}
