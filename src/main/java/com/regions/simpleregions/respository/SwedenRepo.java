package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SwedenEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface SwedenRepo extends CrudRepository<SwedenEntity, Long> {

    Optional<SwedenEntity> findByRegion(final @PathVariable String region);

    @Query("select sweden from SwedenEntity sweden WHERE sweden.description LIKE CONCAT('%',:description,'%')")
    List<SwedenEntity> findByDescription(final @PathVariable String description);
}
