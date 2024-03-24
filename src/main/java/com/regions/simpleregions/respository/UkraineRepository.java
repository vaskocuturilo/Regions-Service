package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.UkraineEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UkraineRepository extends CrudRepository<UkraineEntity, Long> {
    Optional<UkraineEntity> findByRegion(final String region);
    @Query("select ukraine from UkraineEntity ukraine WHERE ukraine.description LIKE CONCAT('%',:description,'%') order by ukraine.description asc ")
    List<UkraineEntity> findByDescription(final String description);
}
