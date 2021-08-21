package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.LithuaniaEntity;
import org.springframework.data.repository.CrudRepository;

public interface LithuaniaRepo extends CrudRepository<LithuaniaEntity, Long> {

    LithuaniaEntity findByRegion(String region);
}
