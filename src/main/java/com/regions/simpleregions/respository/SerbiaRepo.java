package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SerbiaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SerbiaRepo extends CrudRepository<SerbiaEntity, Long> {
    Optional<SerbiaEntity> findByRegion(String region);

    @Query("select serbia from SerbiaEntity serbia WHERE serbia.description LIKE CONCAT('%',:description,'%')")
    List<SerbiaEntity> findByDescription(String description);
}
