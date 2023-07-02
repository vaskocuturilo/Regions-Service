package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.BelarusEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BelarusRepo extends CrudRepository<BelarusEntity, Long> {
    Optional<BelarusEntity> findByRegion(String region);

    @Query("select belarus from BelarusEntity belarus WHERE belarus.description LIKE CONCAT('%',:description,'%')")
    List<BelarusEntity> findByDescription(String description);
}
