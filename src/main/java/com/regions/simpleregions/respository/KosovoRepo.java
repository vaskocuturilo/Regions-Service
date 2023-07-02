package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.KosovoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface KosovoRepo extends CrudRepository<KosovoEntity, Long> {
    Optional<KosovoEntity> findByRegion(@PathVariable String region);
    @Query("select kosovo from KosovoEntity kosovo WHERE kosovo.description LIKE CONCAT('%',:description,'%')")
    List<KosovoEntity> findByDescription(@PathVariable String description);
}
