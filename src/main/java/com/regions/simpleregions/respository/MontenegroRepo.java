package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.MontenegroEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MontenegroRepo extends CrudRepository<MontenegroEntity, Long> {
    Optional<MontenegroEntity> findByRegion(@PathVariable String region);
    @Query("select montenegro from MontenegroEntity montenegro WHERE montenegro.description LIKE CONCAT('%',:description,'%')")
    List<MontenegroEntity> findByDescription(@PathVariable String description);
}
