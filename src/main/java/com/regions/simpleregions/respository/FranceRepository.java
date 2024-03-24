package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.FranceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FranceRepository extends CrudRepository<FranceEntity, Long> {

    Optional<FranceEntity> findByRegion(String region);

    @Query("select france from FranceEntity france WHERE france.description LIKE CONCAT('%',:description,'%') order by france.description asc ")
    List<FranceEntity> findByDescription(String description);
}
