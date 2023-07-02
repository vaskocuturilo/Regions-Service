package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.CroatiaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CroatiaRepo extends CrudRepository<CroatiaEntity, Long> {
    Optional<CroatiaEntity> findByRegion(@PathVariable String region);

    @Query("select croatia from CroatiaEntity croatia WHERE croatia.description LIKE CONCAT('%',:description,'%')")
    List<CroatiaEntity> findByDescription(@PathVariable String description);
}
