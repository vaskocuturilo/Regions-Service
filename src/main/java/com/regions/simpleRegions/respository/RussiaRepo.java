package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.RussiaEntity;
import org.springframework.data.repository.CrudRepository;

public interface RussiaRepo extends CrudRepository<RussiaEntity, Long> {

    RussiaEntity findByRegion(String region);

    RussiaEntity findByDescription(String description);

}
