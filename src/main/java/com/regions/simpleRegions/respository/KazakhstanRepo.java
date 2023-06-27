package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.KazakhstanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface KazakhstanRepo extends CrudRepository<KazakhstanEntity, Long> {

    Optional<KazakhstanEntity> findByRegion(@PathVariable String region);

    @Query("select kazakhstan from KazakhstanEntity kazakhstan WHERE kazakhstan.description LIKE CONCAT('%',:description,'%')")
    List<KazakhstanEntity> findByDescription(@PathVariable String description);
}
