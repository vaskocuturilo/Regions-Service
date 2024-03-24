package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.RomaniaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface RomaniaDiplomaticRepository extends CrudRepository<RomaniaDiplomaticEntity, Long> {
    Optional<RomaniaDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select romania from RomaniaDiplomaticEntity romania WHERE romania.description LIKE CONCAT('%',:description,'%') order by romania.description asc ")
    List<RomaniaDiplomaticEntity> findByDescription(@PathVariable String description);
}
