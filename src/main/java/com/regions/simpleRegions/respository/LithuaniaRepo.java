package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.LithuaniaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LithuaniaRepo extends CrudRepository<LithuaniaEntity, Long> {

    LithuaniaEntity findByRegion(String region);
}
