package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.BulgariaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulgariaRepo extends CrudRepository<BulgariaEntity, Long> {
    BulgariaEntity findByRegion(String region);
}
