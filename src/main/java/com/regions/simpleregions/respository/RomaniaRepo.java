package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.RomaniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface RomaniaRepo extends CrudRepository<RomaniaEntity, Long> {
    Optional<RomaniaEntity> findByRegion(@PathVariable String region);

    @Query("select romania from RomaniaEntity romania WHERE romania.description LIKE CONCAT('%',:description,'%')")
    List<RomaniaEntity> findByDescription(@PathVariable String description);
}
