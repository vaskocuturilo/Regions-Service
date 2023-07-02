package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.UzbekistanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzbekistanRepo extends CrudRepository<UzbekistanEntity, Long> {

    UzbekistanEntity findByRegion(String region);
}
