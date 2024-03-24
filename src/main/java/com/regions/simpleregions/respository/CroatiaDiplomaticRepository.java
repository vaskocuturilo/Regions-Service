package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.CroatiaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CroatiaDiplomaticRepository extends CrudRepository<CroatiaDiplomaticEntity, Long> {
    Optional<CroatiaDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select croatia from CroatiaDiplomaticEntity croatia WHERE croatia.description LIKE CONCAT('%',:description,'%') order by croatia.description asc ")
    List<CroatiaDiplomaticEntity> findByDescription(@PathVariable String description);
}
