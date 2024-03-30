package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.MalaysiaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MalaysiaDiplomaticRepository extends CrudRepository<MalaysiaDiplomaticEntity, Long> {
    Optional<MalaysiaDiplomaticEntity> findByRegion(@PathVariable String region);
    @Query("select malaysia from MalaysiaDiplomaticEntity malaysia WHERE malaysia.description LIKE CONCAT('%',:description,'%') order by malaysia.description asc ")
    List<MalaysiaDiplomaticEntity> findByDescription(@PathVariable String description);
}
