package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.LithuaniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface LithuaniaRepo extends CrudRepository<LithuaniaEntity, Long> {

    Optional<LithuaniaEntity> findByRegion(@PathVariable String region);

    @Query("select lithuania from LithuaniaEntity lithuania WHERE lithuania.description LIKE CONCAT('%',:description,'%')")
    List<LithuaniaEntity> findByDescription(@PathVariable String description);
}
