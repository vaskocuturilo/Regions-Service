package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.TurkeyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurkeyRepo extends CrudRepository<TurkeyEntity, Long> {

    TurkeyEntity findByRegion(String region);
}
