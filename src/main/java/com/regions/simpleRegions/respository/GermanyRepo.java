package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GermanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GermanyRepo extends CrudRepository<GermanyEntity, Long> {
    Optional<GermanyEntity> findByRegion(String region);

    @Query("select gernamy from GermanyEntity gernamy WHERE gernamy.description LIKE CONCAT('%',:description,'%')")
    List<GermanyEntity> findByDescription(String description);
}
