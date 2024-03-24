package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.ArmeniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArmeniaRepository extends CrudRepository<ArmeniaEntity, Long> {
    Optional<ArmeniaEntity> findByRegion(String region);

    @Query("select armenia from ArmeniaEntity armenia WHERE armenia.description LIKE CONCAT('%',:description,'%') order by armenia.description asc ")
    List<ArmeniaEntity> findByDescription(String description);
}
