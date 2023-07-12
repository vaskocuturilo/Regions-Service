package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.NorwayDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface NorwayDiplomaticRepo extends CrudRepository<NorwayDiplomaticEntity, Long> {

    Optional<NorwayDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select norway from NorwayDiplomaticEntity norway WHERE norway.description LIKE CONCAT('%',:description,'%')")
    List<NorwayDiplomaticEntity> findByDescription(@PathVariable String description);
}
