package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.EstoniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoniaRepo extends CrudRepository<EstoniaEntity, Long> {

    Optional<EstoniaEntity> findByRegion(@PathVariable String region);

    @Query("select estonia from EstoniaEntity estonia WHERE estonia.description LIKE CONCAT('%',:description,'%')")
    List<EstoniaEntity> findByDescription(@PathVariable String description);
}
