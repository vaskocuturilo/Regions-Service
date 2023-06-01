package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.BritishEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BritishRepo extends CrudRepository<BritishEntity, Long> {

    BritishEntity findByRegion(String region);
    @Query("select british from BritishEntity british WHERE british.description LIKE CONCAT('%',:description,'%')")
    List<BritishEntity> findByDescription(String description);
}
