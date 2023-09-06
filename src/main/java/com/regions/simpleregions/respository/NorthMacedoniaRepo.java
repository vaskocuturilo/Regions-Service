package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.NorthMacedoniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NorthMacedoniaRepo extends CrudRepository<NorthMacedoniaEntity, Long> {
    Optional<NorthMacedoniaEntity> findByRegion(String region);

    @Query("select macedonia from NorthMacedoniaEntity macedonia WHERE macedonia.description LIKE CONCAT('%',:description,'%')")
    List<NorthMacedoniaEntity> findByDescription(String description);
}
