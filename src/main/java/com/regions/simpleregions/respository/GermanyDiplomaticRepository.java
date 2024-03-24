package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.GermanyDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GermanyDiplomaticRepository extends CrudRepository<GermanyDiplomaticEntity, Long> {
    Optional<GermanyDiplomaticEntity> findByRegion(String region);

    @Query("select gernamy from GermanyDiplomaticEntity gernamy WHERE gernamy.description LIKE CONCAT('%',:description,'%') order by gernamy.description asc ")
    List<GermanyDiplomaticEntity> findByDescription(String description);
}
