package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.FranceDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FranceDiplomaticRepo extends CrudRepository<FranceDiplomaticEntity, Long> {

    Optional<FranceDiplomaticEntity> findByRegion(String region);

    @Query("select france from FranceDiplomaticEntity france WHERE france.description LIKE CONCAT('%',:description,'%')")
    List<FranceDiplomaticEntity> findByDescription(String description);
}
