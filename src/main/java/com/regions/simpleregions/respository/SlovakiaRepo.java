package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.SlovakiaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlovakiaRepo extends CrudRepository<SlovakiaEntity, Long> {

    Optional<SlovakiaEntity> findByRegion(final @PathVariable String region);

    @Query("select slovakia from SlovakiaEntity slovakia WHERE slovakia.description LIKE CONCAT('%',:description,'%')")
    List<SlovakiaEntity> findByDescription(final @PathVariable String description);
}
