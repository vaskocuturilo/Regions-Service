package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.LithuaniaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface LithuaniaRepository extends CrudRepository<LithuaniaEntity, Long> {

    Optional<LithuaniaEntity> findByRegion(@PathVariable String region);

    @Query("select lithuania from LithuaniaEntity lithuania WHERE lithuania.description LIKE CONCAT('%',:description,'%') order by lithuania.description asc ")
    List<LithuaniaEntity> findByDescription(@PathVariable String description);
}
