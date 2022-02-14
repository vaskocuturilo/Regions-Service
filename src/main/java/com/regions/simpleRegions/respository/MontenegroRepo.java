package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.MontenegroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MontenegroRepo extends CrudRepository<MontenegroEntity, Long> {
    MontenegroEntity findByRegion(String region);
}
