package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.RomaniaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomaniaRepo extends CrudRepository<RomaniaEntity, Long> {
    RomaniaEntity findByRegion(String region);
}
