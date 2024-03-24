package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SwedenDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface SwedenDiplomaticRepository extends CrudRepository<SwedenDiplomaticEntity, Long> {

    Optional<SwedenDiplomaticEntity> findByRegion(final @PathVariable String region);

    @Query("select sweden from SwedenDiplomaticEntity sweden WHERE sweden.description LIKE CONCAT('%',:description,'%') order by sweden.description asc ")
    List<SwedenDiplomaticEntity> findByDescription(final @PathVariable String description);
}
