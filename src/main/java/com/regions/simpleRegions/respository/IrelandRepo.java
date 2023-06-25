package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.IrelandEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface IrelandRepo extends CrudRepository<IrelandEntity, Long> {
    Optional<IrelandEntity> findByRegion(@PathVariable String region);

    @Query("select ireland from IrelandEntity ireland WHERE ireland.description LIKE CONCAT('%',:description,'%')")
    List<IrelandEntity> findByDescription(@PathVariable String description);
}
