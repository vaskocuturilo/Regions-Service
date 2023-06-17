package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.AzerbaijanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface AzerbaijanRepo extends CrudRepository<AzerbaijanEntity, Long> {

    Optional<AzerbaijanEntity> findByRegion(@PathVariable String region);

    @Query("select azerbaijan from AzerbaijanEntity azerbaijan  WHERE azerbaijan.description LIKE CONCAT('%',:description,'%')")
    List<AzerbaijanEntity> findByDescription(@PathVariable String description);
}
