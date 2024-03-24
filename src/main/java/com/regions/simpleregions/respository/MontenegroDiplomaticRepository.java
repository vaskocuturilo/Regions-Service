package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface MontenegroDiplomaticRepository extends CrudRepository<MontenegroDiplomaticEntity, Long> {
    Optional<MontenegroDiplomaticEntity> findByRegion(@PathVariable String region);
    @Query("select montenegro from MontenegroDiplomaticEntity montenegro WHERE montenegro.description LIKE CONCAT('%',:description,'%') order by montenegro.description asc ")
    List<MontenegroDiplomaticEntity> findByDescription(@PathVariable String description);
}
