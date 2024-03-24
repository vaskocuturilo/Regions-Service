package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.AzerbaijanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface AzerbaijanRepository extends CrudRepository<AzerbaijanEntity, Long> {

    Optional<AzerbaijanEntity> findByRegion(@PathVariable String region);

    @Query("select azerbaijan from AzerbaijanEntity azerbaijan  WHERE azerbaijan.description LIKE CONCAT('%',:description,'%') order by azerbaijan.description asc ")
    List<AzerbaijanEntity> findByDescription(@PathVariable String description);
}
