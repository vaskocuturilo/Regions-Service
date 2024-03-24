package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.PortugalDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortugalDiplomaticRepository extends CrudRepository<PortugalDiplomaticEntity, Long> {
    Optional<PortugalDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select portugal from PortugalDiplomaticEntity portugal WHERE portugal.description LIKE CONCAT('%',:description,'%') order by portugal.description asc ")
    List<PortugalDiplomaticEntity> findByDescription(@PathVariable String description);
}
