package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.KyrgyzstanDiplomaticEntity;
import com.regions.simpleregions.entity.KyrgyzstanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface KyrgyzstanDiplomaticRepo extends CrudRepository<KyrgyzstanDiplomaticEntity, Long> {
    Optional<KyrgyzstanDiplomaticEntity> findByRegion(@PathVariable String region);

    @Query("select kyrgyzstan from KyrgyzstanDiplomaticEntity kyrgyzstan WHERE kyrgyzstan.description LIKE CONCAT('%',:description,'%')")
    List<KyrgyzstanDiplomaticEntity> findByDescription(@PathVariable String description);
}
