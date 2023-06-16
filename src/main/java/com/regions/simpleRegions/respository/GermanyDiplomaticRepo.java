package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.GermanyDiplomaticEntity;
import com.regions.simpleRegions.entity.GermanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GermanyDiplomaticRepo extends CrudRepository<GermanyDiplomaticEntity, Long> {
    Optional<GermanyDiplomaticEntity> findByRegion(String region);

    @Query("select gernamy from GermanyDiplomaticEntity gernamy WHERE gernamy.description LIKE CONCAT('%',:description,'%')")
    List<GermanyDiplomaticEntity> findByDescription(String description);
}
