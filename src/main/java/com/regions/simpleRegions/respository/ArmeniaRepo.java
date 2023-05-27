package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.ArmeniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArmeniaRepo extends CrudRepository<ArmeniaEntity, Long> {
    ArmeniaEntity findByRegion(String region);

    @Query("select armenia from ArmeniaEntity armenia WHERE armenia.description LIKE CONCAT('%',:description,'%')")
    List<ArmeniaEntity> findByDescription(String description);
}
