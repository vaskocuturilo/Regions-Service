package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.RussiaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RussiaRepo extends CrudRepository<RussiaEntity, Long> {

    RussiaEntity findByRegion(String region);

    @Query("select russia from RussiaEntity russia WHERE russia.description LIKE CONCAT('%',:description,'%')")
    List<RussiaEntity> findByDescription(String description);
}
