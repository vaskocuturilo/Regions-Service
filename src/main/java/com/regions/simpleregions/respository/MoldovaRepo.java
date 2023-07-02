package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.MoldovaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoldovaRepo extends CrudRepository<MoldovaEntity, Long> {

    Optional<MoldovaEntity> findByRegion(@PathVariable String region);

    @Query("select moldova from MoldovaEntity moldova WHERE moldova.description LIKE CONCAT('%',:description,'%')")
    List<MoldovaEntity> findByDescription(@PathVariable String description);
}
