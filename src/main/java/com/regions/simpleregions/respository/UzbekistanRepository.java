package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.UzbekistanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UzbekistanRepository extends CrudRepository<UzbekistanEntity, Long> {

    Optional<UzbekistanEntity> findByRegion(final @PathVariable String region);

    @Query("select uzbekistan from UzbekistanEntity uzbekistan WHERE uzbekistan.description LIKE CONCAT('%',:description,'%') order by uzbekistan.description asc ")
    List<UzbekistanEntity> findByDescription(final @PathVariable String description);
}
