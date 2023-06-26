package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.TurkeyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurkeyRepo extends CrudRepository<TurkeyEntity, Long> {
    Optional<TurkeyEntity> findByRegion(@PathVariable String region);

    @Query("select turkey from TurkeyEntity turkey WHERE turkey.description LIKE CONCAT('%',:description,'%')")
    List<TurkeyEntity> findByDescription(@PathVariable String description);
}
