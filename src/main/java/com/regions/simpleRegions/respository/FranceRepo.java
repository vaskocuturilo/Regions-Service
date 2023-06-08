package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.FranceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FranceRepo extends CrudRepository<FranceEntity, Long> {

    Optional<FranceEntity> findByRegion(String region);

    @Query("select france from FranceEntity france WHERE france.description LIKE CONCAT('%',:description,'%')")
    List<FranceEntity> findByDescription(String description);
}
