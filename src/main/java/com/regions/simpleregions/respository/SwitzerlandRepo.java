package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface SwitzerlandRepo extends CrudRepository<SwitzerlandEntity, Long> {
    Optional<SwitzerlandEntity> findByRegion(final @PathVariable String region);

    @Query("select switzerland from SwitzerlandEntity switzerland WHERE switzerland.description LIKE CONCAT('%',:description,'%')")
    List<SwitzerlandEntity> findByDescription(final @PathVariable String description);
}
