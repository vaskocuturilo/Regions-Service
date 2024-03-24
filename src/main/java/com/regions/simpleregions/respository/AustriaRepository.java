package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.AustriaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface AustriaRepository extends CrudRepository<AustriaEntity, Long> {
    Optional<AustriaEntity> findByRegion(@PathVariable String region);

    @Query("select austria from AustriaEntity austria WHERE austria.description LIKE CONCAT('%',:description,'%') order by austria.description asc ")
    List<AustriaEntity> findByDescription(@PathVariable String description);

}
