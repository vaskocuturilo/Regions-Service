package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.IrelandEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface IrelandRepository extends CrudRepository<IrelandEntity, Long> {
    Optional<IrelandEntity> findByRegion(@PathVariable String region);

    @Query("select ireland from IrelandEntity ireland WHERE ireland.description LIKE CONCAT('%',:description,'%') order by ireland.description asc ")
    List<IrelandEntity> findByDescription(@PathVariable String description);
}
