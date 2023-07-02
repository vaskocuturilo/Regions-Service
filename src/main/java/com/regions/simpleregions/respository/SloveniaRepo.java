package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SloveniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface SloveniaRepo extends CrudRepository<SloveniaEntity, Long> {

    Optional<SloveniaEntity> findByRegion(final @PathVariable String region);

    @Query("select slovenia from SloveniaEntity slovenia WHERE slovenia.description LIKE CONCAT('%',:description,'%')")
    List<SloveniaEntity> findByDescription(final @PathVariable String description);
}
