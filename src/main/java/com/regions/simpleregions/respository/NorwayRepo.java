package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.NorwayEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NorwayRepo extends CrudRepository<NorwayEntity, Long> {

    NorwayEntity findByRegion(String region);
}
