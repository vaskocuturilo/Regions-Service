package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SlovakiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlovakiaRepo extends CrudRepository<SlovakiaEntity, Long> {

    SlovakiaEntity findByRegion(String region);
}
