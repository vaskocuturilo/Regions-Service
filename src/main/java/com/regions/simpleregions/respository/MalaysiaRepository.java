package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.MalaysiaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MalaysiaRepository extends CrudRepository<MalaysiaEntity, Long> {

    Optional<MalaysiaEntity> findByRegion(@PathVariable String region);

    @Query("select malaysia from MalaysiaEntity malaysia WHERE malaysia.description LIKE CONCAT('%',:description,'%') order by malaysia.description asc ")
    List<MalaysiaEntity> findByDescription(@PathVariable String description);
}
