package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.RussiaDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RussiaDiplomaticRepo extends CrudRepository<RussiaDiplomaticEntity, Long> {

    Optional<RussiaDiplomaticEntity> findByRegion(String region);

    @Query("select russia from RussiaDiplomaticEntity russia WHERE russia.description LIKE CONCAT('%',:description,'%')")
    List<RussiaDiplomaticEntity> findByDescription(String description);
}
