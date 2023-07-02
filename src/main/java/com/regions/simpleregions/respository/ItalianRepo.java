package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.ItalianEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItalianRepo extends CrudRepository<ItalianEntity, Long> {
    Optional<ItalianEntity> findByRegion(String region);

    @Query("select italian from ItalianEntity italian WHERE italian.description LIKE CONCAT('%',:description,'%')")
    List<ItalianEntity> findByDescription(String description);
}
