package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GreeceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface GreeceRepo extends CrudRepository<GreeceEntity, Long> {
    Optional<GreeceEntity> findByRegion(@PathVariable String region);

    @Query("select greece from GreeceEntity greece WHERE greece.description LIKE CONCAT('%',:description,'%')")
    List<GreeceEntity> findByDescription(@PathVariable String description);
}
