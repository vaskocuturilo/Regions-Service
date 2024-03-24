package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SwitzerlandDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface SwitzerlandDiplomaticRepository extends CrudRepository<SwitzerlandDiplomaticEntity, Long> {
    Optional<SwitzerlandDiplomaticEntity> findByRegion(final @PathVariable String region);

    @Query("select switzerland from SwitzerlandDiplomaticEntity switzerland WHERE switzerland.description LIKE CONCAT('%',:description,'%') order by switzerland.description asc ")
    List<SwitzerlandDiplomaticEntity> findByDescription(final @PathVariable String description);
}
