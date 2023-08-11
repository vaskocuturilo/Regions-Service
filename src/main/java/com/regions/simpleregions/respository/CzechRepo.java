package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.CzechEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CzechRepo extends CrudRepository<CzechEntity, Long> {

    Optional<CzechEntity> findByRegion(final String region);

    @Query("select czech from CzechEntity czech WHERE czech.description LIKE CONCAT('%',:description,'%')")
    List<CzechEntity> findByDescription(final String description);
}