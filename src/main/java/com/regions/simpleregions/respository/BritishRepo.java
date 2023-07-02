package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.BritishEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BritishRepo extends CrudRepository<BritishEntity, Long> {

    Optional<BritishEntity> findByRegion(String region);
    @Query("select british from BritishEntity british WHERE british.description LIKE CONCAT('%',:description,'%')")
    List<BritishEntity> findByDescription(String description);
}
