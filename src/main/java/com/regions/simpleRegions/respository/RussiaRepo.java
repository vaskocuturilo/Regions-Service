package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.RussiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RussiaRepo extends CrudRepository<RussiaEntity, Long> {

    RussiaEntity findByRegion(String region);

    RussiaEntity findByDescription(String description);

}
