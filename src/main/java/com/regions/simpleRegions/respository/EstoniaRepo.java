package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.EstoniaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoniaRepo extends CrudRepository<EstoniaEntity, Long> {

    EstoniaEntity findByRegion(String region);
}
