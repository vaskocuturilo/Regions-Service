package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.KyrgyzstanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface KyrgyzstanRepo extends CrudRepository<KyrgyzstanEntity, Long> {
    Optional<KyrgyzstanEntity> findByRegion(@PathVariable String region);

    @Query("select kyrgyzstan from KyrgyzstanEntity kyrgyzstan WHERE kyrgyzstan.description LIKE CONCAT('%',:description,'%')")
    List<KyrgyzstanEntity> findByDescription(@PathVariable String description);
}
