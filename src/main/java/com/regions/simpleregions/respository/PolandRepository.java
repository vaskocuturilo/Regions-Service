package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.PolandEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolandRepository extends CrudRepository<PolandEntity, Long> {

    Optional<PolandEntity> findByRegion(final String region);

    @Query("select poland from PolandEntity poland WHERE poland.description LIKE CONCAT('%',:description,'%') order by poland.description asc ")
    List<PolandEntity> findByDescription(final String description);
}
