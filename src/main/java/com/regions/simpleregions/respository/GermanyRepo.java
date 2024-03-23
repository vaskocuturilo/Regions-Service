package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.GermanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GermanyRepo extends CrudRepository<GermanyEntity, Long> {
    List<GermanyEntity> findByRegion(String region);

    @Query("select gernamy from GermanyEntity gernamy WHERE gernamy.description LIKE CONCAT('%',:description,'%') order by gernamy.description desc ")
    List<GermanyEntity> findByDescription(String description);
}
