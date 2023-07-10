package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.ItalianDiplomaticEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItalianDiplomaticRepo extends CrudRepository<ItalianDiplomaticEntity, Long> {
    Optional<ItalianDiplomaticEntity> findByRegion(String region);

    @Query("select italian from ItalianDiplomaticEntity italian WHERE italian.description LIKE CONCAT('%',:description,'%')")
    List<ItalianDiplomaticEntity> findByDescription(String description);
}
