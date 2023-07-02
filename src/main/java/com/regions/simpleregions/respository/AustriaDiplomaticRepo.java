package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.AustriaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface AustriaDiplomaticRepo extends CrudRepository<AustriaDiplomaticEntity, Long> {
    Optional<AustriaDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select austria from AustriaDiplomaticEntity austria WHERE austria.description LIKE CONCAT('%',:description,'%')")
    List<AustriaDiplomaticEntity> findByDescription(@PathVariable String description);

}
