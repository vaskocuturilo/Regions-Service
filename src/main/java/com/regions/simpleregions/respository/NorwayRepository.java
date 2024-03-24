package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.NorwayEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface NorwayRepository extends CrudRepository<NorwayEntity, Long> {

    Optional<NorwayEntity> findByRegion(@PathVariable String region);

    @Query("select norway from NorwayEntity norway WHERE norway.description LIKE CONCAT('%',:description,'%') order by norway.description asc ")
    List<NorwayEntity> findByDescription(@PathVariable String description);
}
