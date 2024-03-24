package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.EstoniaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoniaDiplomaticRepository extends CrudRepository<EstoniaDiplomaticEntity, Long> {

    Optional<EstoniaDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select estonia from EstoniaDiplomaticEntity estonia WHERE estonia.description LIKE CONCAT('%',:description,'%') order by estonia.description asc ")
    List<EstoniaDiplomaticEntity> findByDescription(@PathVariable String description);
}
