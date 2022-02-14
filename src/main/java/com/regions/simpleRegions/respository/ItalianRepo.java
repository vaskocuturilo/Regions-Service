package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.ItalianEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItalianRepo extends CrudRepository<ItalianEntity, Long> {
    ItalianEntity findByRegion(String region);
}
