package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.HungaryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface HungaryRepository extends CrudRepository<HungaryEntity, Long> {
    Optional<HungaryEntity> findByRegion(@PathVariable String region);

    @Query("select hungary from HungaryEntity hungary WHERE hungary.description LIKE CONCAT('%',:description,'%') order by hungary.description asc ")
    List<HungaryEntity> findByDescription(@PathVariable String description);
}
