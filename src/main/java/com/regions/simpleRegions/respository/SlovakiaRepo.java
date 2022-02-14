package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.SlovakiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlovakiaRepo extends CrudRepository<SlovakiaEntity, Long> {

    SlovakiaEntity findByRegion(String region);
}
