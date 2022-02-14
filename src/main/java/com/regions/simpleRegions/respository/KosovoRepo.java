package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.KosovoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KosovoRepo extends CrudRepository<KosovoEntity, Long> {

    KosovoEntity findByRegion(String region);
}
