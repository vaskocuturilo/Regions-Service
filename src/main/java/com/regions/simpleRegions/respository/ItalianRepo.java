package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.ItalianEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItalianRepo extends CrudRepository<ItalianEntity, Long> {
    ItalianEntity findByRegion(String region);

    @Query("select italian from ItalianEntity italian WHERE italian.description LIKE CONCAT('%',:description,'%')")
    List<ItalianEntity> findByDescription(String description);
}
