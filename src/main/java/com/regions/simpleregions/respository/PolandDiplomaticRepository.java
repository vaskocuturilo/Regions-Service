package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolandDiplomaticRepository extends CrudRepository<PolandDiplomaticEntity, Long> {
    Optional<PolandDiplomaticEntity> findByRegion(final String region);

    @Query("select poland from PolandDiplomaticEntity poland WHERE poland.description LIKE CONCAT('%',:description,'%') order by poland.description asc ")
    List<PolandDiplomaticEntity> findByDescription(final String description);
}
