package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.MontenegroEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MontenegroRepository extends CrudRepository<MontenegroEntity, Long> {
    Optional<MontenegroEntity> findByRegion(@PathVariable String region);
    @Query("select montenegro from MontenegroEntity montenegro WHERE montenegro.description LIKE CONCAT('%',:description,'%') order by montenegro.description asc ")
    List<MontenegroEntity> findByDescription(@PathVariable String description);
}
