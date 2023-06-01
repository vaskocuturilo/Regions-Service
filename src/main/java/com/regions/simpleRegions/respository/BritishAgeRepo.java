package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BritishAgeRepo extends CrudRepository<BritishAgeEntity, Long> {
    BritishAgeEntity findByCode(String code);
}
