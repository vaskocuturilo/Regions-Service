package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.BulgariaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface BulgariaRepo extends CrudRepository<BulgariaEntity, Long> {
    Optional<BulgariaEntity> findByRegion(@PathVariable String region);

    @Query("select bulgaria from BulgariaEntity bulgaria WHERE bulgaria.description LIKE CONCAT('%',:description,'%')")
    List<BulgariaEntity> findByDescription(@PathVariable String description);
}
