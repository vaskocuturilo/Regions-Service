package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.PolandDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolandDiplomaticRepo extends CrudRepository<PolandDiplomaticEntity, Long> {
    Optional<PolandDiplomaticEntity> findByRegion(final String region);

    @Query("select poland from PolandDiplomaticEntity poland WHERE poland.description LIKE CONCAT('%',:description,'%')")
    List<PolandDiplomaticEntity> findByDescription(final String description);
}
