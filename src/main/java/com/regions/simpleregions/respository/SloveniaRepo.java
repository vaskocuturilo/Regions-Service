package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SloveniaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SloveniaRepo extends CrudRepository<SloveniaEntity, Long> {

    SloveniaEntity findByRegion(String region);
}
