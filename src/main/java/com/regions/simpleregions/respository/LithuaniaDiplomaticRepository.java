package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.LithuaniaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface LithuaniaDiplomaticRepository extends CrudRepository<LithuaniaDiplomaticEntity, Long> {

    Optional<LithuaniaDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select lithuania from LithuaniaDiplomaticEntity lithuania WHERE lithuania.description LIKE CONCAT('%',:description,'%') order by lithuania.description asc ")
    List<LithuaniaDiplomaticEntity> findByDescription(@PathVariable String description);
}
